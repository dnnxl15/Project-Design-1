package library;

public class Gain 
{
	private String typeName;
	private int gain;
	
	public Gain(String pTypeName, int pGain)
	{
		setTypeName(pTypeName);
		setGain(pGain);
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getGain() {
		return gain;
	}

	public void setGain(int gain) {
		this.gain = gain;
	}
}