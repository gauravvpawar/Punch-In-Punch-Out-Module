package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee , Long>{
	public Employee findByEmail(String email);
	
	public Employee findByEmailAndPassword(String email, String password);
}
