package com.demo.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.employee.entity.Employee;
import com.demo.employee.entity.EmployeePKId;

//Why JPARepository is used?
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, EmployeePKId> {

		//Native Query
		@Query(nativeQuery = true,value = "SELECT * FROM Employee WHERE is_active = true AND designation = 'software' AND salary > 80000")
		List<Employee> findByDesignationAndSalary();
		 
		//Query JPQL
		//@Query("SELECT e FROM Employee e WHERE isActive = true AND designation = 'software' AND salary > 80000")
		//List<Employee> findByDesignationAndSalary();
	
		//Passing a param with Query Language
		@Query(nativeQuery = true,value = "SELECT * FROM Employee WHERE is_active = true AND designation = :designation AND salary > :salary")
		List<Employee> findByDesignationAndSalary(@Param("designation")String designation, @Param("salary")String salary);
}
