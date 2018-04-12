package edu.handong.csee.java.lab09;	//package name
import java.util.Scanner;	//import scanner
import edu.handong.csee.java.lab09.SalesAssociate;	//import the class 'SalesAssociate'

/**
 * This class gets data(number of salesman, name, sales) and find out 
 * who has the highest sales, and display the name of the highest seller and average sales of all salesman
 * @author KKB
 *
 */
public class SalesReport {		//declare the class 'SalesReport'
	
	private double highestSales;	//declare a double-type value for highest sales
	private double averageSales;	//declare a double-type value for average sales
	private SalesAssociate[] team;	//declare an Array named team
	
	
	/**
	 * This main method will run the program
	 * @param args
	 */
	public static void main(String[] args) {	//this is main method which sets data, computes highest and average sales, and displays the result

		SalesReport sales = new SalesReport();	//instantiate the class to sales
		
		sales.getData();	//get data from user(number of salesman, name and sales)
		sales.computeHighest();	//compute the highest sales
		sales.computeAverage();	//compute the average sales
		sales.displayResults();	//display results
		
	}
	
	/**
	 * This method gets all the data from user.
	 */
	public void getData() {	//declare the method 'getData'
		System.out.println("enter the number of salesman: ");	//print out this message to get the number of salesman
		Scanner keyboard = new Scanner(System.in);	//instantiate the scanner to keyboard
		int numOfSalesman = keyboard.nextInt();	//get the number of salesman from user
		
		team = new SalesAssociate[numOfSalesman];	//instantiate the array to team
		
		for(int i=0; i<numOfSalesman; i++) {	//repeat the loop while i is less than number of salesman
			keyboard.nextLine();	//get rid of the character enter
			System.out.println("Enter data for associate number "+(i+1));	//print out this message to get the name and sales of salesman
			System.out.print("name? ");	//print out this message to get the name of associate 
			String name = keyboard.nextLine();	//get name from user
			System.out.println("Sales? ");	//print out this method to get sales from user
			double sales = keyboard.nextDouble();	//get sales from user
			team[i] = new SalesAssociate();	//instantiate
			team[i].setName(name);	//set name on the array team
			team[i].setSales(sales);	//set sales on the array team
		}	
		keyboard.close();	//close scanner
	}
	
	/**
	 * This method finds the highest seller
	 */
	public void computeHighest() {	//declare the method named 'computedHighest'
		double highestSales = 0;	//initiate the highestSales to 0
		

		for(int i=0; i<team.length; i++)	//repeat the loop while index value is less than the length of the array team
			if(highestSales < team[i].getSales())	//if the value highestSales is less than ith element of the array team.
				highestSales = team[i].getSales();	//replace the highestSales value to ith element of the array
		this.highestSales = highestSales;	//substitute the class value highestSales for highestSles
	}
	
	/**
	 * This method computes average sales of the all sellers.
	 */
	public void computeAverage() {	//declare the method named 'computedAverage'
		double sum=0;	//initiate the sum to 0
		
		for(int i=0; i<team.length; i++)	//repeat the loop while index value is less than length of the array team
			sum = sum+team[i].getSales();	//replace the sum value to sum + ith element of the array
		averageSales = sum/team.length;	//substitute the class value 'averageSales' to average value of the array 'team' 
	}
	
	/**
	 * This method print out the results
	 */
	public void displayResults() {	//declare the class named 'displayResult'
		System.out.println("Salesman who has the highest sales: ");	//print out this message
		
		for(int i=0; i<team.length; i++) {	//repeat the loop while index value is less than length fo the array 'team'
			if(team[i].getSales()==highestSales) {	//if ith element of the class team is highest sales 
				System.out.println("Name: "+team[i].getName());	//print out the name of the salesman
				System.out.println("Sales: "+team[i].getSales());	//print out the sales of the salesman
			}
		}
		System.out.println("Average Sales per associate is "+averageSales);	//print out the average sales of the whole salesman
	}		
}
