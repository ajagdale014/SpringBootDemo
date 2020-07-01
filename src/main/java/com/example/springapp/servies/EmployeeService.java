package com.example.springapp.servies;

import java.util.List;


import com.example.springapp.model.Employee;
import com.example.springapp.model.OrderResponse;
import com.example.springapp.model.RequestWrapperOrder;

public interface EmployeeService {
	public Employee getEmployee(Integer id);
	
	public Employee addEmployee(Employee e);
	
	public List<Employee> getAllEmployee();

	public OrderResponse getOrderList(RequestWrapperOrder order);
}
