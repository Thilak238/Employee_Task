package com.demo.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.employee.entity.Employee;
import com.demo.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public ResponseEntity<String> insertEmployee(Employee employee){
		try {
			employeeRepository.save(employee);
			return new ResponseEntity<String>("Employee Successfully created",HttpStatus.CREATED);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<List<Employee>> getAllEmployees() {
		try {
			return new ResponseEntity<List<Employee>>(employeeRepository.findAll(),HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<Employee>>(new ArrayList<Employee>(),HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<List<Employee>> findByDesignationAndSalary() {
		try {
			List<Employee> employeeList = employeeRepository.findByDesignationAndSalary();
			return new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<List<Employee>>(new ArrayList<Employee>(),HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<List<Employee>> findByDesignationAndSalary(String designation, String salary) {
		try {
			List<Employee> employeeList = employeeRepository.findByDesignationAndSalary(designation,salary);
			return new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<List<Employee>>(new ArrayList<Employee>(),HttpStatus.NOT_FOUND);
	}
}
