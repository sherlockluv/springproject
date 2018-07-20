package com.project.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TackClassVO {
	private String subejct;
	private String s_class;
	private String id;
	private String name;
	private String school;
	private String tname;
	private String start_date;
	private String stop_date;
	private String grade;
	private String mark;
	public String getSubejct() {
		return subejct;
	}
	public void setSubejct(String subejct) {
		this.subejct = subejct;
	}
	public String getS_class() {
		return s_class;
	}
	public void setS_class(String s_class) {
		this.s_class = s_class;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getStop_date() {
		return stop_date;
	}
	public void setStop_date(String stop_date) {
		this.stop_date = stop_date;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "TackClassVO [subejct=" + subejct + ", s_class=" + s_class + ", id=" + id + ", name=" + name
				+ ", school=" + school + ", tname=" + tname + ", start_date=" + start_date + ", stop_date=" + stop_date
				+ ", grade=" + grade + ", mark=" + mark + "]";
	}
	
	
	
}
