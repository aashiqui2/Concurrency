package com.concurrency.repository;

import java.util.List;

import com.concurrency.entity.Employee;


public interface EmployeeRepository {

	List<Employee> fetchEmployees();

}