package com.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.data.config.DBConfig;
import com.data.constants.DBConstants;
import com.data.entity.Employee;

public class EmployeeDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String query;
	public EmployeeDAO() {
		String url = DBConstants.URL;
		String user = DBConstants.USER_NAME;
		String pwd = DBConstants.PASSWORD;
		String driver = DBConstants.DRIVER_CLASS;
		DBConfig config = new DBConfig(url, user, pwd, driver);
		con = config.getConnection();
	}
	
	public Employee createEmployee(ResultSet res) {
		Employee emp = new Employee();
		try {
			emp.setDob(res.getString("dob"));
			emp.setEmail(res.getString("email"));
			emp.setEname(res.getString("ename"));
			emp.setGender(res.getString("gender"));
			emp.setId(res.getInt("id"));
			emp.setPhone(res.getString("phone"));
			emp.setQualification(res.getString("qualification"));
			emp.setStatus(res.getBoolean("status"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	public List<Employee> getAll(){
		List<Employee> emps = new ArrayList<Employee>();
		try {
			query = "select * from employee";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Employee emp = createEmployee(rs);
				emps.add(emp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return emps;
	}
	
	public Employee getById(int id) {
		Employee emp = null;
		try {
			query = "select * from employee where id = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				emp = createEmployee(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	public void save(Employee emp) {
		try {
			String name = emp.getEname();
			String qual = emp.getQualification();
			String dob = emp.getDob();
			String phone = emp.getPhone();
			String email = emp.getEmail();
			String gender = emp.getGender();
			boolean status = emp.isStatus();
			query = "insert into employee(ename, email, phone, dob, gender, qualification, status) value(?,?,?,?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phone);
			ps.setString(4, dob);
			ps.setString(5, gender);
			ps.setString(6, qual);
			ps.setBoolean(7, status);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
