package com.student.webservices.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {

	private long no; //Student Number
	private String name; //Student Name
	private String dob; // Student Date Of Birth
	private String doj;  //Student Date of joining
	
	public Student(){
		
	}

	public Student(long no, String name, String dob, String doj) {
		super();
		this.no = no;
		this.name = name;
		this.dob = dob;
		this.doj = doj;
	}

	public long getNo() {
		return no;
	}

	public void setNo(long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "Student {no:" + no + ", name:" + name + ", dob:" + dob + ", doj:" + doj + "}";
	}
	
	
}
