package connection;

import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ObjectPool <Connection>
{
	private long expirationTime;
	private Hashtable<Connection, Long> locked, unlocked;
	
	public ObjectPool() 
	{
		expirationTime = 30000; // 30 seconds
		locked = new Hashtable<Connection, Long>();
		unlocked = new Hashtable<Connection, Long>();
	}
    
	protected abstract Connection create();
	public abstract boolean validate(Connection pConnection);
	public abstract void expire(Connection pConnection);
	public synchronized Connection checkOut() 
	{
		long now = System.currentTimeMillis();
		Connection t;
	    if (unlocked.size() > 0) 
	    {
	    	Enumeration<Connection> e = unlocked.keys();
	    	while (e.hasMoreElements())
	    	{
		        t = e.nextElement();
		        if ((now - unlocked.get(t)) > expirationTime) 
		        {
		        	// object has expired
		        	unlocked.remove(t);
		            expire(t);
		            t = null;
		        } 
		        else 
		        {
		        	if (validate(t)) 
		        	{
		        		unlocked.remove(t);
		                locked.put(t, now);
		                return (t);
		            }
		        	else 
		        	{
		        		// object failed validation
		        		unlocked.remove(t);
		        		expire(t);
		        		t = null;
		        	}
		        }
	    	}
	    }
	    // no objects available, create a new one
	    t = (Connection) create();
	    locked.put(t, now);
	    return (t);
	  }

	  public synchronized void checkIn(Connection t) {
	    locked.remove(t);
	    unlocked.put(t, System.currentTimeMillis());
	  }
}