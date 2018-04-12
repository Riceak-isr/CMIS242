package edu.UMUC.CMIS242.Project1;

/**
 * Created by riceak.isr
 * Filename: Employee.java
 * Date: March 20, 2018
 * Assignment: Project 1, CMIS 242
 * Purpose: Reads in Employee information and adds data specific to Executives;
 *    computes bonus if stockprice greater than $50 
 */

public class Executive extends Employee{

    private double currentStockPrice;

    //Constructors
    public Executive() {

    } //End no argument constructor

    //Constructor to initialize name, monthlySalary, and currentStockPrice
    public Executive(int year, String name, double monthlySalary, double currentStockPrice) {
        super(year, name, monthlySalary);
        this.currentStockPrice = currentStockPrice;
    } //End constructor

    //Methods
    @Override
    public double annualSalary() {
        double bonus = 0;

        // The bonus is $30,000 if the current stock price is greater than $50, nothing otherwise.
        if (this.currentStockPrice > 50) {
            bonus = 30000;
        }

        return super.annualSalary() + bonus;
    }

    //toString method returning name, monthlySalary, and currentStockPrice
    @Override
    public String toString() {
        return super.toString() + "\nCurrent Stock Price: \t\t" +
                df.format(this.currentStockPrice);
    }

    //Getters and Setters
    public double getCurrentStockPrice() {
        return currentStockPrice;
    }

    public void setCurrentStockPrice(float currentStockPrice) {
        this.currentStockPrice = currentStockPrice;
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
}//end Executive Class extended from Employee Class
