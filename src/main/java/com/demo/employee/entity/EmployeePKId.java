package com.demo.employee.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//What is the purpose of @EqualsAndHashCode
@EqualsAndHashCode  
//Why implements Serializable
//Advantages & Disadvantages 
@Embeddable
public class EmployeePKId implements Serializable{
	private Integer employeeId;
	private String  employeeCode;
}
