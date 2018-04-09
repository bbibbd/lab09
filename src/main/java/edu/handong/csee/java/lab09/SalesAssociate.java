package edu.handong.csee.java.lab09;	//package name

/**
 * The class sets name and sales of the sales associate
 * @author KKB
 */
public class SalesAssociate {	//declare the class 'SalesAssociate'
	
	/**
	 * this method gets name and return it
	 * @return
	 */
	public String getName() {	//declare the getter method 
		return name;	//return name of the salesman
	}
	
	/**
	 * this method sets name
	 * @param name
	 */
	public void setName(String name) {	//declare the setter method
		this.name = name;	//put name to the class variable 'name'
	}
	
	/**
	 * this method gets sales
	 * @return
	 */
	public double getSales() {	//declare the getter method
		return sales;	//return sales
	}
	
	/**
	 * this method sets sales
	 * @param sales
	 */
	public void setSales(double sales){	//declare the setter method
		this.sales = sales; //put sales to the class variable sales
	}
	
	private String name;	//declare a string variable name
	private double sales;	//declare double type variable sales
}
