package com.example.springapp.servies;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.springapp.exception.DataNotFoundException;
import com.example.springapp.model.Employee;
import com.example.springapp.model.OrderResponse;
import com.example.springapp.model.RequestWrapperOrder;
import com.example.springapp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	private Employee save;

	@Override
	public Employee getEmployee(Integer id) {
		Optional<Employee> findById = employeeRepository.findById(id);
		if(!findById.isPresent()) {
			throw new DataNotFoundException("emp is not found"+ id);
		}
		return findById.get();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employee = employeeRepository.findAll();
		return employee;
	}

	@Override
	public OrderResponse getOrderList(RequestWrapperOrder order) {
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setDepartment("IT");
		orderResponse.setName("Sagar");
		orderResponse.setSalary(10000);
		return orderResponse;
	}

	@Override
	public ResponseEntity<Employee> createEmployeeDetail(Employee employee) {
		Employee save = employeeRepository.save(employee);
//
//		URI uri = ServletUriComponentsBuilder
//				.fromCurrentRequest()
//				.path("/{id}")
//				.buildAndExpand(save.getId())
//				.toUri();
		if(null == save) {
			throw new DataNotFoundException("Employee Not Found");
		}
		return new ResponseEntity<Employee>(save, HttpStatus.CREATED);
		//return ResponseEntity.created(uri).build();

	}

}
