package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.springapp.model.Employee;
import com.example.springapp.servies.EmployeeServiceImpl;

@RestController("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@RequestMapping(path = "/welcome")
	public String welcome() {
		return "Welocome to Spring boot RESTful Api";
	}
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee employee ) {
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/getAllEmployeeById/{id}")
	public Employee getAllEmployeeById(@PathVariable (name = "id")Integer id){
		return employeeService.getEmployee(id);
	}

}
