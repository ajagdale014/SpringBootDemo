package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.exception.DataNotFoundException;
import com.example.springapp.model.Employee;
import com.example.springapp.model.OrderResponse;
import com.example.springapp.model.RequestWrapperOrder;
import com.example.springapp.servies.EmployeeServiceImpl;

@RestController("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@RequestMapping(path = "/welcome")
	public String welcome() {
		return "Welocome to Spring boot RESTful Api";
	}
	
	@PostMapping("/add-employee")
	public Employee addEmployee(@RequestBody Employee employee ) {
		return employeeService.addEmployee(employee);
	}
	
	@PostMapping("/createEmployeeDetail")
	public ResponseEntity<Employee> createEmployeeDeatils(@RequestBody Employee employee){
		return 	employeeService.createEmployeeDetail(employee);
		
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/getAllEmployeeById/{id}")
	public ResponseEntity<Employee> getAllEmployeeById(@PathVariable (name = "id")Integer id) throws DataNotFoundException{
		Employee employee = employeeService.getEmployee(id);
		
		return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/fetchOrderList")
	public OrderResponse getOrderList(@RequestBody RequestWrapperOrder reqOrderWrapper) {
		
		return employeeService.getOrderList(reqOrderWrapper);
	}

}
