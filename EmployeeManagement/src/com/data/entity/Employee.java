package com.data.entity;

public class Employee {
	private int id;
	private String ename;
	private String email;
	private String phone;
	private String dob;
	private String gender;
	private String qualification;
	private boolean status = true;
	
	public Employee() {}

	public Employee(String ename, String email, String phone, String dob, String gender, String qualification) {
		super();
		this.ename = ename;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.gender = gender;
		this.qualification = qualification;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", ename=" + ename + ", email=" + email + ", phone=" + phone + ", status="
				+ status + "]";
	}
	
}
