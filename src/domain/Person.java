package domain;

public class Person {
    private String name;
    private String lastName;
    private int id;
    private int identification;

    public Person(String name, String lastName, int id,int identification) {
        this.name = name;
        this.lastName= lastName;
        this.id = id;
        this.identification = identification;
    }
    
    public Person(String name, String lastName, int id) {
        this.name = name;
        this.lastName= lastName;
        this.id = id;
    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}