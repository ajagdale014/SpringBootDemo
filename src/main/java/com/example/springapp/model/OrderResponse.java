package com.example.springapp.model;

public class OrderResponse {
	private String name;
	private String department;
	private long salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public long getSalary() {
		return salary;
	}
	public void setSalary(long salary) {
		this.salary = salary;
	}
	public OrderResponse(String name, String department, long salary) {
		super();
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	public OrderResponse() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderResponse [name=" + name + ", department=" + department + ", salary=" + salary + "]";
	}
	
}
