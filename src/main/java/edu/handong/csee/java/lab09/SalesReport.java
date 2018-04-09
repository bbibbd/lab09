package edu.handong.csee.java.lab09;	//test3
import java.util.Scanner;	//import scanner
import edu.handong.csee.java.lab09.SalesAssociate;	//import the class 'SalesAssociate'


public class SalesReport {	
	
	private double highestSales;
	private double averageSales;
	private SalesAssociate[] team;
	
	public static void main(String[] args) {

		SalesReport sales = new SalesReport();
		
		sales.getData();
		sales.computeHigest();
		sales.computeAverage();
		sales.displayResults();
		
	}
	
	public void getData() {
		System.out.println("enter the number of salesman: ");
		Scanner keyboard = new Scanner(System.in);
		int numOfSalesman = keyboard.nextInt();
		
		team = new SalesAssociate[numOfSalesman];	
		
		for(int i=0; i<numOfSalesman; i++) {
			keyboard.nextLine();
			System.out.println("Enter data for associate number "+(i+1));
			System.out.print("name? ");
			String name = keyboard.nextLine();
			System.out.println("Sales? ");
			double sales = keyboard.nextDouble();
			team[i] = new SalesAssociate();
			team[i].setName(name);
			team[i].setSales(sales);
		}	
		keyboard.close();
	}
	
	public void computeHigest() {
		double highestSales = 0;
		

		for(int i=0; i<team.length; i++)
			if(highestSales < team[i].getSales())
				highestSales = team[i].getSales();
		this.highestSales = highestSales;
	}
	
	public void computeAverage() {
		double sum=0;
		
		for(int i=0; i<team.length; i++)
			sum = sum+team[i].getSales();
		averageSales = sum/team.length;
	}
	
	public void displayResults() {
		System.out.println("Salesman who hs the highest sales: ");
		
		for(int i=0; i<team.length; i++) {
			if(team[i].getSales()==highestSales) {
				System.out.println("Name: "+team[i].getName());
				System.out.println("Sales: "+team[i].getSales());
			}
		}
	}		
}
