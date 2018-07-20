package com.project.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubjectVO {
	private static final Logger logger = LoggerFactory.getLogger(SubjectVO.class);
	
	private String subject;
	private String s_class;
	private String grade;
	private String tname;
	private String open_date;
	private String close_date;
	private String mark;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getS_class() {
		return s_class;
	}
	public void setS_class(String s_class) {
		this.s_class = s_class;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getOpen_date() {
		return open_date;
	}
	public void setOpen_date(String open_date) {
		this.open_date = open_date;
	}
	public String getClose_date() {
		return close_date;
	}
	public void setClose_date(String close_date) {
		this.close_date = close_date;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	@Override
	public String toString() {
		return "SubjectVO [subject=" + subject + ", s_class=" + s_class + ", grade=" + grade + ", tname=" + tname
				+ ", open_date=" + open_date + ", close_date=" + close_date + ", mark=" + mark + "]";
	}
	
}
