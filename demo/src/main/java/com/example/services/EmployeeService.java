package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pojo.Employee;
import com.example.repositories.EmployeeRepository;

@Service
public class EmployeeService implements Empservices {
	
	@Autowired
	EmployeeRepository empRepository;

	public Employee getEmpbyID(int id) {
		Optional<Employee> result = empRepository.findById(id);
		if(result.isPresent())
			return result.get();
		else
			return null;
	}
	public void addnewEmp(Employee e) {
	
		empRepository.save(e);
	}
	
	public void addnewEmplist() {
		List<Employee> emplist = new ArrayList<Employee>();
		List<Employee> result = new ArrayList<Employee>();
		emplist.add(new Employee(1,"one","10","a"));
		emplist.add(new Employee(2,"two","10","a"));
		emplist.add(new Employee(3,"thre","10","a"));
		emplist.add(new Employee(4,"four","10","b"));
		emplist.add(new Employee(5,"five","10","b"));
		result=empRepository.saveAll(emplist);
		
	}
}
