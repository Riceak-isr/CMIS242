package edu.UMUC.CMIS242.Project1;

/**
 * Created by riceak.isr
 * Filename: Employee.java
 * Date: March 20, 2018
 * Assignment: Project 1, CMIS 242
 * Purpose: initializes employee name and monthly salary; computes annualSalary
 *    to be displayed in output.
 */

import java.text.DecimalFormat;

public class Employee {

    private String name;
    private double monthlySalary;
    private int year;
    protected static DecimalFormat df = new DecimalFormat("$0.00");


    //Constructors
    public Employee() {

    }// End no argument constructor

    public Employee(int year, String name, double monthlySalary) {
        this.year = year;
        this.name = name;
        this.monthlySalary = monthlySalary;
    } //End constructor

    //Methods
    //Method to return annual salary for whole year
    public double annualSalary() {
        return this.monthlySalary * 12;
    } //End annualSalary method

    //toString method returning name and annual salary
    public String toString() {
        return "\nEmployee Name: \t\t\t" + this.name +
                "\nAnnual Salary: \t\t\t" + df.format(this.annualSalary());
    } //End toString

    //Getters and Setters
    public String getName() {
        return name;
    } //End getter Name

    public void setName(String name) {
        this.name = name;
    }//End setter Name

    public double getMonthlySalary() {
        return monthlySalary;
    } //End getter MonthlySalary

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    } //End setter MonthlySalary

    public int getYear() {
        return year;
    } //end getter Year

    public void setYear(int year) {
        this.year = year;
    } //end setter Year
}
