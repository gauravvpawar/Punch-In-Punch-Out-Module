package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.Attendance;

public interface AttendanceRepo extends JpaRepository<Attendance , Long>{
	public List<Attendance> findByEmployeeId(Long empId);
    public Attendance findTopByEmployeeIdOrderByIdDesc(Long empId);
}
