package com.example.demo.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Attendance {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Long employeeId;
    private LocalDate date;
    private LocalDateTime punchIn;
    private LocalDateTime punchOut;
    private Double totalHours;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalDateTime getPunchIn() {
		return punchIn;
	}
	public void setPunchIn(LocalDateTime punchIn) {
		this.punchIn = punchIn;
	}
	public LocalDateTime getPunchOut() {
		return punchOut;
	}
	public void setPunchOut(LocalDateTime punchOut) {
		this.punchOut = punchOut;
	}
	public Double getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(Double totalHours) {
		this.totalHours = totalHours;
	}
	@Override
	public String toString() {
		return "Attendance [id=" + id + ", employeeId=" + employeeId + ", date=" + date + ", punchIn=" + punchIn
				+ ", punchOut=" + punchOut + ", totalHours=" + totalHours + "]";
	}
    
    
    
    
    
    
}
