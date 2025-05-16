package com.demo.employee.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

//Purpose of @Entity >>
@Entity
//Purpose of @Data
@Data
@AllArgsConstructor
@NoArgsConstructor
//@IdClass(EmployeePKId.class)
public class Employee {

	//Why Wrapper class?
	//@Id
	//private Integer employeeId;
	//@Id
	@EmbeddedId
	private EmployeePKId employeePKId;
	//When Using @Id annotation then only we need to declare EmployeeCode in both of the classes 
	//private String  employeeCode;
	private String firstName;
	private String lastName;
	private Boolean isActive;
	private String designation;
	private double salary;
	private String department;
}
