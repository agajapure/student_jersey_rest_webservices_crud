package com.student.webservices.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.student.webservices.h2connection.H2ConnectionFactory;
import com.student.webservices.model.Student;

public class StudentService {
	
	public StudentService(){
		this.createTableIfNotExists();
	}
	
	public void createTableIfNotExists(){
		try(Connection con =  H2ConnectionFactory.getConnection()){
			String query = "CREATE TABLE IF NOT EXISTS student (no IDENTITY NOT NULL PRIMARY KEY, name VARCHAR(255), dob VARCHAR(255), doj VARCHAR(255))";
			PreparedStatement ps = con.prepareStatement(query);
			ps.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Student> getAllStudents(){
		List<Student> stdList = new ArrayList<Student>();
		try(Connection con =  H2ConnectionFactory.getConnection()){
			String query = "SELECT * FROM student";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				final long no = rs.getLong("no");
				final String name = rs.getString("name");
				final String dob = rs.getString("dob");
				final String doj = rs.getString("doj");
				Student std = new Student(no, name, dob, doj);
				stdList.add(std);
			}
			System.out.println("student list size = "+stdList.size());
			return stdList;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void saveStudent(Student student){
		try(Connection con =  H2ConnectionFactory.getConnection()) {
			String query = "INSERT INTO student (name, dob, doj) VALUES(?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, student.getName());
			ps.setString(2, student.getDob());
			ps.setString(3, student.getDoj());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Student getStudentByNo(long no){
		try(Connection con =  H2ConnectionFactory.getConnection()) {
			String query = "SELECT * FROM student WHERE no=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, no);
			try(ResultSet rs = ps.executeQuery()){
				if(rs.next()){
					final long sno = rs.getLong("no");
					final String name = rs.getString("name");
					final String dob = rs.getString("dob");
					final String doj = rs.getString("doj");
					return new Student(sno, name, dob, doj);
				}else{
					return null;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateStudentByNo(long no, String name, String dob, String doj){
		try(Connection con =  H2ConnectionFactory.getConnection()) {
			String query = "UPDATE student SET name=?, dob=?, doj=? WHERE no=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, dob);
			ps.setString(3, doj);
			ps.setLong(4, no);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deleteStudentByNo(long no){
		try(Connection con =  H2ConnectionFactory.getConnection()) {
			String query = "DELETE FROM student WHERE no=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, no);
			ps.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
