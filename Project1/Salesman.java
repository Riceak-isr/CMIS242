package edu.UMUC.CMIS242.Project1;

/**
 * Created by riceak.isr
 * Filename: Employee.java
 * Date: March 20, 2018
 * Assignment: Project 1, CMIS 242
 * Purpose: Reads in Employee information and adds data specific to Salesmen;
 *    computes commission from annual sales and adds to annualSalary
 */

public class Salesman extends Employee {

    private double annualSales;

    //Constructors
    public Salesman() {

    } //End no argument constructor

    public Salesman(int year, String name, double monthlySalary, double annualSales) {
        super(year, name, monthlySalary);
        this.annualSales = annualSales;
    } //End constructor

    /**
     * Overridden Method
     * Returns Annual Salary
     * Computes Annual Salary and 2% of annual sales as commission
     * Caps commission at $20,000
     */
    @Override
    public double annualSalary() {
        double commission = this.annualSales * .02;

        // The maximum commission a salesman can earn is $20,000.
        if (commission > 20000) {
            commission = 20000;
        }

        return super.annualSalary() + commission;
    }

    /**
     * Overridden toString
     * Returns Name, Monthly Salary, and Annual Sales
     */
    @Override
    public String toString() {
        return super.toString() + "\nAnnual Sales: \t\t\t" +
                df.format(this.annualSales);
    }

    //Getters and Setters
    public double getAnnualSales() {
        return annualSales;
    }

    public void setAnnualSales(double annualSales) {
        this.annualSales = annualSales;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public double getMonthlySalary() {
        return super.getMonthlySalary();
    }

    @Override
    public void setMonthlySalary(double monthlySalary) {
        super.setMonthlySalary(monthlySalary);
    }

    @Override
    public int getYear() {
        return super.getYear();
    }

    @Override
    public void setYear(int year) {
        super.setYear(year);
    }
} //End Salesman Class, Extended from Employee Class
