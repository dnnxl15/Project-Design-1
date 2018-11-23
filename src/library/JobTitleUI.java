/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author egapb
 */
public class JobTitleUI {
        private String name;
        private int minSalary;
	private int maxSalary;

    public JobTitleUI(String jName, int jMinSalary, int jMaxSalary)
    {   
	name = jName;
	minSalary = jMinSalary;
        maxSalary = jMaxSalary;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

 
}
