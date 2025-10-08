package com.concurrency.service.impl;

import java.util.List;
import java.util.concurrent.Callable;

import com.concurrency.entity.Employee;
import com.concurrency.repository.EmployeeRepository;


public class EmployeeServiceImpl implements Callable<List<Employee>> {
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	public List<Employee> call() {
		System.out.println(Thread.currentThread().getName() + " started fetching from : " + employeeRepository);
		List<Employee> employeeList = employeeRepository.fetchEmployees();
		System.out.println(Thread.currentThread().getName() + " finished fetching from : " + employeeRepository);
		return employeeList;
	}
}
