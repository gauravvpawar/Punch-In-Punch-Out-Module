package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Attendance;
import com.example.demo.Service.AttendanceService;

@RestController
@RequestMapping("/attendance")
@CrossOrigin("*")
public class AttendanceController {
	
	@Autowired
	AttendanceService as;
	
	@PostMapping("/punch-in/{id}") 
	public String in(@PathVariable Long id){
		as.punchIn(id);
		return "PunchIn OK";
	}
	
    @PostMapping("/punch-out/{id}") 
    public String out(@PathVariable Long id){
    	as.punchOut(id);
    	return "PunchOut OK";
    }
    
    @GetMapping("/history/{id}") 
    public List<Attendance> h(@PathVariable Long id){
    	return as.history(id);
    }
    
//    to fetch the all history of employee
    @GetMapping("/getAllAttendance")
    public List<Attendance> getAll()
    {
    	return as.getAllAttendance();
    }

}
