package com.example.springapp.servies;

import java.util.List;


import com.example.springapp.model.Employee;

public interface EmployeeService {
	public Employee getEmployee(Integer id);
	
	public Employee addEmployee(Employee e);
	
	public List<Employee> getAllEmployee();

	
}
