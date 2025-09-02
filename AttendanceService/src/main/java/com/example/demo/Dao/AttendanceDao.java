package com.example.demo.Dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Attendance;
import com.example.demo.Repo.AttendanceRepo;
import com.example.demo.Service.AttendanceService;

@Service
public class AttendanceDao implements AttendanceService{
	
	@Autowired
	AttendanceRepo ar;

	@Override
	public void punchIn(Long empId) {
		 Attendance rec=new Attendance();
	     rec.setEmployeeId(empId);
	     rec.setDate(LocalDate.now());
	     rec.setPunchIn(LocalDateTime.now());
		
	     ar.save(rec);
		
	}

	@Override
	public void punchOut(Long empId) {
		Attendance rec=ar.findTopByEmployeeIdOrderByIdDesc(empId);
        if(rec!=null && rec.getPunchOut()==null){
            rec.setPunchOut(LocalDateTime.now());
            rec.setTotalHours(Duration.between(rec.getPunchIn(),rec.getPunchOut()).toMinutes()/60.0);
            ar.save(rec);
        }
		
	}

	@Override
	public List<Attendance> history(Long empId) {
		return ar.findByEmployeeId(empId);
	}

//	for to get all the employee attendance history
	public List<Attendance> getAllAttendance()
	{
		List<Attendance> l1 = ar.findAll();
		return l1;
	}
	

}
