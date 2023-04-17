package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.Iservice.IEmployeeService;
import com.nt.model.Employee;
import com.nt.repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements IEmployeeService
{
	
	@Autowired
	private EmployeeRepository  repository;

	@Override
	public List<Employee> getEmployee() 
	{
		
		return repository.findAll();
	}

	@Override
	public String addEmployee(Employee emp) 
	{
		int no=repository.save(emp).getEmpno();
		return "Employee is  added having empno is::"+no;
	}

}
