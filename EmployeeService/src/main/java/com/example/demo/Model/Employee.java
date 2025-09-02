package com.example.demo.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Employee {
	 @Id 
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 private String name;
	 private String email;
	 private String password;
	 private String role;
	 
	 @Transient
	 private List<Attendance> Attendance = new ArrayList<>();

	 public Long getId() {
		 return id;
	 }

	 public void setId(Long id) {
		 this.id = id;
	 }

	 public String getName() {
		 return name;
	 }

	 public void setName(String name) {
		 this.name = name;
	 }

	 public String getEmail() {
		 return email;
	 }

	 public void setEmail(String email) {
		 this.email = email;
	 }

	 public String getPassword() {
		 return password;
	 }

	 public void setPassword(String password) {
		 this.password = password;
	 }

	 public String getRole() {
		 return role;
	 }

	 public void setRole(String role) {
		 this.role = role;
	 }

	 public List<Attendance> getAttendance() {
		 return Attendance;
	 }

	 public void setAttendance(List<Attendance> attendance) {
		 Attendance = attendance;
	 }

	 @Override
	 public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + ", Attendance=" + Attendance + "]";
	 }
	 
	 
	 
	 
}
