package com.example.springapp.servies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Employee;
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
		System.out.println(employee.toString());
		Employee save = EmployeeRepository.save(employee);
		System.out.println(save.toString());
		return save;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employee = EmployeeRepository.findAll();
		System.out.println(employee);
		return employee;
	}

}
