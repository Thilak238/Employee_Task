package com.demo.employee.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.demo.employee.entity.Employee;
import com.demo.employee.service.EmployeeService;

//Difference between @Controller and @RestController 
//@Controller - returns a view template like HTML or JSP. @ResponseBody required for returning HTML or XML
//@RestController - Automatically serializes the return value into JSON or XML
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping(value = "/createEmployee")
	public ResponseEntity<String> save(@RequestBody Employee employee) {
		return employeeService.insertEmployee(employee);
	}
	
	@GetMapping(value = "/allEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping(value = "/fetchEmployeeByDesignation")
	public ResponseEntity<List<Employee>> findByDesignationAndSalary(@RequestParam(required=false) String designation, @RequestParam(required=false) String salary) {
		if(designation != null && !designation.isEmpty() && salary != null && !salary.isEmpty()) {
			return employeeService.findByDesignationAndSalary(designation,salary);
		}else {
			return employeeService.findByDesignationAndSalary();
		}
	}
	
	//Getting via JPA methods 
	@GetMapping(value = "/fetchEmployeeBySalary")
	public ResponseEntity<List<Employee>> findBySalary() {
		return employeeService.findBySalary();
	}
	
	//Find top Three Salary persons based on department
	@GetMapping(value = "/fetchTopThreeSalaryPerson")
	public ResponseEntity<List<Employee>> findTopThreeSalaryPerson() {
		return employeeService.findTopThreeSalaryPerson();
	}
	
	
	
	//{
		//"EmployeePKId": {
				//"employeeId":9,
				//"employeeCode":"101_G"
		//}
		//		"firstName": "Harshith",
		//      "lastName": "Rana",
	    //      "isActive": true,
		//      "designation": "software",
		//      "salary": 91000.0
	//}
}
