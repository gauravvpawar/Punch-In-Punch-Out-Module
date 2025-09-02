package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Attendance;

public interface AttendanceService {
	public void punchIn(Long empId);
    public void punchOut(Long empId);
    public List<Attendance> history(Long empId);
    
    public List<Attendance> getAllAttendance();
}
