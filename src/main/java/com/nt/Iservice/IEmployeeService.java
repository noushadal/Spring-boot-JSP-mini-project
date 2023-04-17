package com.nt.Iservice;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeService 
{
	
	public List<Employee> getEmployee();
	
	
	public String addEmployee(Employee emp);

}
