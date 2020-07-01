package com.example.springapp.servies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.exception.MyFileNotFoundException;
import com.example.springapp.model.Employee;
import com.example.springapp.model.OrderResponse;
import com.example.springapp.model.RequestWrapperOrder;
import com.example.springapp.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository EmployeeRepository;

	@Override
	public Employee getEmployee(Integer id) {
		return EmployeeRepository.findById(id).get();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		if(null == employee) {
			throw new MyFileNotFoundException("Exception Occure due Null");
		}
		Employee save = EmployeeRepository.save(employee);
		if(null == save) {
			throw new MyFileNotFoundException("Failed to add Employee");
		}
		return save;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employee = EmployeeRepository.findAll();
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

}
