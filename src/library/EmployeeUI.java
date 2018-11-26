package library;

import javafx.scene.control.CheckBox;

public class EmployeeUI 
{
	private String name;
	private String lastname;
	private String email;
	private double salary;
	private String rol;
	private int idEmployee;
    private int restaurant;

    public EmployeeUI(int idEmployee,String name, String lastname, String email, double salary, String rol,int idRestaurant) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.salary = salary;
        this.rol = rol;
        this.idEmployee = idEmployee;
        this.setRestaurant(idRestaurant);
    }
        
        
        
        
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}

        public int getIdEmployee() {
            return idEmployee;
        }

        public void setIdEmployee(int idEmployee) {
            this.idEmployee = idEmployee;
        }

	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}




	public int getRestaurant() {
		return restaurant;
	}




	public void setRestaurant(int restaurant) {
		this.restaurant = restaurant;
	}

}
