package models;

public class Employee implements Comparable<Employee> {

	private String name;
	private double payment;
	
	public Employee(String name , double payment) {
		this.name = name;
		this.payment = payment;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}

	//TODO used to search element in collection by name
	@Override
	public int compareTo(Employee employee) {
		if (this.name == employee.getName()) return 1;
		else return -1;
	}
	
}
