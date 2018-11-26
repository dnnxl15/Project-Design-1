package library;

public class Gain 
{
	private String typeName;
	private float gain;
	
	public Gain(String pTypeName, float pGain)
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

	public float getGain() {
		return gain;
	}

	public void setGain(float gain) {
		this.gain = gain;
	}
}