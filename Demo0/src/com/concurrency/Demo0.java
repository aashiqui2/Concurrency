package com.concurrency;

import com.concurrency.repository.EmployeeRepository;
import com.concurrency.repository.impl.EmployeeRepositoryImpl1;
import com.concurrency.repository.impl.EmployeeRepositoryImpl2;
import com.concurrency.repository.impl.EmployeeRepositoryImpl3;
import com.concurrency.service.impl.EmployeeServiceImpl;


public class Demo0 {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " started fetching");
		EmployeeServiceImpl employeeServiceImpl = null;
		EmployeeRepository[] employeeRepositories = { 
			new EmployeeRepositoryImpl1(), new EmployeeRepositoryImpl2(),new EmployeeRepositoryImpl3() };
		
		Thread[] employeeServices = new Thread[employeeRepositories.length];
		
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < employeeRepositories.length; i++) {
			employeeServiceImpl = new EmployeeServiceImpl(employeeRepositories[i]);
			employeeServices[i] = new Thread(employeeServiceImpl);
			employeeServices[i].start();
		}
		
		for (int i = 0; i < employeeServices.length; i++) {
			try {
				employeeServices[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Completed in " + (System.currentTimeMillis() - startTime) + " milliseconds");
		System.out.println(Thread.currentThread().getName() + " finished fetching");
		//Exception in thread "main" java.lang.IllegalThreadStateException
		//at java.base/java.lang.Thread.start(Thread.java:1525)
		//at com.concurrency.Demo0.main(Demo0.java:35)
		//we cannot restart the thread once it is dead.
		for (int i = 0; i < employeeRepositories.length; i++) {
			employeeServices[i].start();
		}
	}
}
