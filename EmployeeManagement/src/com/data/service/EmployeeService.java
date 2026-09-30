package com.data.service;

import java.util.List;
import java.util.Scanner;

import com.data.dao.EmployeeDAO;
import com.data.entity.Employee;

public class EmployeeService {
	private static final Scanner scan = new Scanner(System.in);
	private EmployeeDAO dao;
	public EmployeeService() {
		dao = new EmployeeDAO();
	}
	
	public void getAllEmployees() {
		List<Employee> employees = dao.getAll();
		if(employees.size()>0) {
			for(Employee emp : employees) {
				System.out.println(emp);
			}
		}
		else {
			System.out.println("No employee is present");
		}
	}
	
	public void getEmployee() {
		System.out.println("Please enter the employee id to search");
		int id = scan.nextInt();
		Employee emp = dao.getById(id);
		if(null == emp) {
			System.out.println("No Employee is present with the given id");
		}
		else {
			System.out.println(emp);
		}
	}
	
	public void menu() {
		while(true) {
			System.out.println("1. Register New Employee");
			System.out.println("2. Display all employees");
			System.out.println("3. Display Employee by Id");
			System.out.println("9. Exit");
			int ch = scan.nextInt();
			switch(ch){
				case 1 : System.out.println("Under construction");break;
				case 2 : getAllEmployees();break;
				case 3 : getEmployee();break;
				case 9 : System.exit(ch);
				default : System.out.println("Enter the correct option");
			}
			menu();
		}
	}
}
