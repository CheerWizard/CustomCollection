package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Launcher {

	private static CustomCollection<Employee> collection;
	
	// start method
	public static void main(String[] args) throws Exception {
		collection = new CustomCollection<>();
		addEmployees();
		max();
		min();
		sort();
		filter();
	}
	
	// test adding
	private static void addEmployees() {
		collection.add(new Employee("Jeremy", 10000.00));
		collection.add(new Employee("Arseniy", 12500.50));
		collection.add(new Employee("Yuriy", 25700.25));
		collection.add(new Employee("Michael", 5900.60));
		iterate();
	}
	
	// test removing
	private static void removeEmployees() {
		collection.remove(3);
		System.out.println(collection.getLast().getName());
		
	}
	
	//test max method
	private static void max() {
		System.out.println("Maximum value of collection has : ");
		System.out.println(collection.maxValue((e1 , e2) -> e1.getPayment().compareTo(e2.getPayment())).getName());
	}
	
	//test min method
	private static void min() {
		System.out.println("Minimum value of collection has : ");
		System.out.println(collection.minValue((e1 , e2) -> e1.getPayment().compareTo(e2.getPayment())).getName());
	}
	
	//test sorting
	private static void sort() {
		System.out.println("Sorting collection...");
		collection.sort((e1 , e2) -> e1.getName().compareTo(e2.getName()));
		iterate();
	}
	
	//test searching 
	private static void filter() {
		CustomCollection<Employee> customCollection = collection.filter(new ISelector<Employee>() {
			@Override
			public <Double> Double select(Employee data) {
				return (Double) data.getPayment();
			}
		} , new Employee("Lisa", 12500.50));
		System.out.println("Filtered collection : ");
		for (Iterator<Employee> iterator = customCollection.iterator() ; iterator.hasNext() ;) {
			Employee employee = iterator.next();
			System.out.println("Name : " + employee.getName());
			System.out.println("Payment " + employee.getPayment());
		}
	}
	
	//test iterating
	private static void iterate() {
		System.out.println("Collection of : ");
		for (Iterator<Employee> iterator = collection.iterator() ; iterator.hasNext() ;) {
			Employee employee = iterator.next();
			System.out.println("Name : " + employee.getName());
			System.out.println("Payment " + employee.getPayment());
		}
	}
}

