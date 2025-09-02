package com.example.demo.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Model.Attendance;
import com.example.demo.Model.Employee;
import com.example.demo.Repo.EmployeeRepo;
import com.example.demo.Service.EmployeeService;

@Service
public class EmployeeDao implements EmployeeService{
	
	@Autowired
	EmployeeRepo er;
	@Autowired
	RestTemplate rt;

	@Override
	public Employee save(Employee e) {
		
		return er.save(e);
	}

	@Override
	public List<Employee> all() {
	    List<Employee> employee = er.findAll();
	    for(Employee e : employee) {
	    	List<Attendance> attendance = rt.getForObject("http://localhost:9092/attendance/history/"+e.getId(), ArrayList.class);
	    	e.setAttendance(attendance);
	    }
		return employee;
	}

	@Override
	public Employee find(Long id) {
		List<Attendance> la = rt.getForObject("http://localhost:9092/attendance/history/"+id, ArrayList.class);
		Employee e = er.findById(id).orElse(null);
		e.setAttendance(la);
		return e;
	}

	@Override
	public void delete(Long id) {
		er.deleteById(id);
	}

	@Override
	public Employee findByEmail(String email) {
		
		return er.findByEmail(email);
	}

	@Override
	public Employee findByEmailAndPassword(String email, String password) {
		Employee employee = er.findByEmailAndPassword(email, password);
		long id = employee.getId();
		List<Attendance> la = rt.getForObject("http://localhost:9092/attendance/history/"+id, ArrayList.class);
		employee.setAttendance(la);
		return employee;

	}

	
}
