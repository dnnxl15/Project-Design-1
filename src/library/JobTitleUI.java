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
        private int idJobTitle;

    public JobTitleUI(String jName, int jMinSalary, int jMaxSalary, int idJobTitle)
    {   
	name = jName;
	minSalary = jMinSalary;
        maxSalary = jMaxSalary;
        this.idJobTitle = idJobTitle;
    }

    public int getIdJobTitle() {
        return idJobTitle;
    }

    public void setIdJobTitle(int idJobTitle) {
        this.idJobTitle = idJobTitle;
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
