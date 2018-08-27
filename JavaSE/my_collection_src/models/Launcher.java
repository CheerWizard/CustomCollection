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
		removeEmployees();
		sort();
		search();
	}
	
	// test adding
	private static void addEmployees() {
		collection.add(new Employee("Jeremy", 10000.00));
		collection.add(new Employee("Arseniy", 12500.50));
		collection.add(new Employee("Yuriy", 25700.25));
		collection.add(new Employee("Michael", 5900.60));
		System.out.println(collection.getLast().getName());
	}
	
	// test removing
	private static void removeEmployees() {
		collection.remove(3);
		System.out.println(collection.getLast().getName());
		
	}
	
	//test max method
	private static String max() {
		return collection.maxValue(new EmployeeComparator()).getName();
	}
	
	//test min method
	private static String min() {
		return collection.minValue(new EmployeeComparator()).getName();
	}
	
	//test sorting
	private static void sort() {
		
		collection.sort(new EmployeeComparator());
		
		for(Iterator<Employee> iter = collection.iterator(); iter.hasNext();) {
	         Employee employee = iter.next();
	         System.out.println("Name : " + employee.getName());
	    } 
	}
	
	//test searching 
	private static void search() {
		System.out.println("Search Yuriy...");
		System.out.println(collection.search(new Employee("Yuriy", 0.0)).getPayment());
		System.out.println("-----------------------------");
		System.out.println("Search George...");
		//TODO throws NullPointerException because inserted element doesn't exist in collection
		System.out.println(collection.search(new Employee("George", 0.0)).getPayment());
	}
}
