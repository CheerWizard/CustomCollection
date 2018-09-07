package models;

public class Employee {

	private String name;
	private Double payment;
	
	public Employee(String name , Double payment) {
		this.name = name;
		this.payment = payment;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPayment() {
		return payment;
	}
	public void setPayment(Double payment) {
		this.payment = payment;
	}
}
