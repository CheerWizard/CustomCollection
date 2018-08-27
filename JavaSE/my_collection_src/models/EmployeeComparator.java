package models;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee firstEmployee, Employee secondEmployee) {
		if (firstEmployee.getPayment() > secondEmployee.getPayment()) return 1;
		if (firstEmployee.getPayment() < secondEmployee.getPayment()) return -1;
		else return 0; 
	}

}
