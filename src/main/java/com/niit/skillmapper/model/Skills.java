package com.niit.skillmapper.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Skills")
public class Skills {
	
	@Id
	private int employeeId;
	private String technicalSkills;
	private String certifications;
	private double years_of_experience;
	private long total_no_of_hours;
	private long total_no_of_students;
	private String feedback;
	private long no_of_students_placed;
	private String known_languages;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getTechnicalSkills() {
		return technicalSkills;
	}
	public void setTechnicalSkills(String technicalSkills) {
		this.technicalSkills = technicalSkills;
	}
	public String getCertifications() {
		return certifications;
	}
	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}
	public double getYears_of_experience() {
		return years_of_experience;
	}
	public void setYears_of_experience(double years_of_experience) {
		this.years_of_experience = years_of_experience;
	}
	public long getTotal_no_of_hours() {
		return total_no_of_hours;
	}
	public void setTotal_no_of_hours(long total_no_of_hours) {
		this.total_no_of_hours = total_no_of_hours;
	}
	public long getTotal_no_of_students() {
		return total_no_of_students;
	}
	public void setTotal_no_of_students(long total_no_of_students) {
		this.total_no_of_students = total_no_of_students;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public long getNo_of_students_placed() {
		return no_of_students_placed;
	}
	public void setNo_of_students_placed(long no_of_students_placed) {
		this.no_of_students_placed = no_of_students_placed;
	}
	public String getKnown_languages() {
		return known_languages;
	}
	public void setKnown_languages(String known_languages) {
		this.known_languages = known_languages;
	}
	
}
