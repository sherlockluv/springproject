package com.project.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MemberVO {
	private static final Logger logger = LoggerFactory.getLogger(MemberVO.class);
	
	private String id;
	private String pwd;
	private String name;
	private String birthday;
	private String address;
	private String school;
	private String ptel;
	private String tel;
	private String email;
	private String joindate;
	private int agree;
	
	private  int upoint;
	
	private String year;
	private String month;
	private String day;
	
	
	
	

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getUpoint() {
		return upoint;
	}
	public void setUpoint(int upoint) {
		this.upoint = upoint;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getPtel() {
		return ptel;
	}
	public void setPtel(String ptel) {
		this.ptel = ptel;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public int getAgree() {
		return agree;
	}
	public void setAgree(int agree) {
		this.agree = agree;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pwd=" + pwd + ", name=" + name + ", birthday=" + birthday + ", address="
				+ address + ", school=" + school + ", ptel=" + ptel + ", tel=" + tel + ", email=" + email
				+ ", joindate=" + joindate + ", agree=" + agree + ", upoint=" + upoint + ", year=" + year + ", month="
				+ month + ", day=" + day + "]";
	}

	
	
}
