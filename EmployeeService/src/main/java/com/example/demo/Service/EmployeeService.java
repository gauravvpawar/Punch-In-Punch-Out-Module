package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Employee;

public interface EmployeeService {
	public Employee save(Employee e);
    public List<Employee> all();
    public Employee find(Long id);
    public void delete(Long id);
    public Employee findByEmail(String email);
    
    public Employee  findByEmailAndPassword(String email , String password);
}
