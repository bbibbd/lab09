package edu.handong.csee.java.lab09;	//package name
import java.util.ArrayList;	//import ArrayList
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
	private ArrayList <SalesAssociate> team;	//declare an ArrayList named team, which use SalesAssociate
	
	
	/**
	 * This main method runs the program
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

		Scanner keyboard = new Scanner(System.in);	//instantiate the scanner to keyboard
		team = new ArrayList<SalesAssociate>();	//instantiate the array to team
		boolean done = false;	//initiate the boolean variable 'done' to false
	
		int i=1;	//declare and initiate the index variable 'i' to 1
		while(!done) {	//'done' was initiated to false, so the condition becomes true and can starts the loop 
			SalesAssociate salesman = new SalesAssociate();	//initiate the class SalesAssociate to salesman
			System.out.println("Enter data for associate number "+(i++));	//print out this message to get the name and sales of salesman. The index value will increase per loops
			System.out.print("name? ");	//print out this message to get the name of associate
			String name = keyboard.nextLine();	//get name from user
			System.out.println("Sales? ");	//print out this method to get sales from user
			double sales = keyboard.nextDouble();	//get sales from user
			salesman.setName(name);	//set name to the instance salesman
			salesman.setSales(sales);	//set sales to the instance salesman
			team.add(salesman);	//add salesman to team
			
			System.out.println("add more salesman? (y/n)");	//ask user whether add more salesman or not

			if(keyboard.next().equalsIgnoreCase("y")) {	//if user_inputed value is "y" or "Y"
				keyboard.nextLine();	//remove enter on the buffer
				done = false;	//boolean variable done is false to repeat the loop one more
			}
			else	done=true;	//if user_inputed value is not "y" or "Y",  'done' becomes true so that escape the loop
		}	
		keyboard.close();	//close scanner
	}
	
	/**
	 * This method finds the highest seller
	 */
	public void computeHighest() {	//declare the method named 'computedHighest'
		double highestSales = 0;	//initiate the highestSales to 0
		
		int length = team.size();	//initiate length to size of the the AaaryList 'team'
		for(int i=0; i<length; i++)	//repeat the loop while the index value is less than the length of the ArrayList
			if(highestSales < team.get(i).getSales())	//if the value highestSales is less than ith element of the ArrayList
				highestSales = team.get(i).getSales();	//replace the highestSales value to ith element of the array
		this.highestSales = highestSales;	//substitute the class value highestSales for highestSles
	}
	
	/**
	 * This method computes average sales of the all sellers.
	 */
	public void computeAverage() {	//declare the method named 'computedAverage'
		double sum=0;	//initiate the sum to 0
		
		int length = team.size();	//initiate the length to the size of the ArrayList
		for(int i=0; i<length; i++)	//repeat the loop while index value is less than length of the array team
			sum = sum+team.get(i).getSales();	//replace the sum value to sum + ith element of the array
		averageSales = sum/length;	//substitute the class value 'averageSales' to average value of the array 'team' 
	}
	
	/**
	 * This method print out the results
	 */
	public void displayResults() {	//declare the class named 'displayResult'
		System.out.println("Salesman who has the highest sales: ");	//print out this message
	
		for(int i=0; i<team.size(); i++) {	//repeat the loop while index value is less than length fo the array 'team'
			if(team.get(i).getSales()==highestSales) {	//if ith element of the class team is highest sales 
				System.out.println("Name: "+team.get(i).getName());	//print out the name of the salesman
				System.out.println("Sales: "+team.get(i).getSales());	//print out the sales of the salesman
			}
		}
		System.out.println("Average Sales per associate is "+averageSales);	//print out the average sales of the whole salesman
	}		
}