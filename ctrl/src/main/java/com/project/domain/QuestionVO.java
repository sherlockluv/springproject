package com.project.domain;

import java.util.Arrays;
import java.util.Date;

public class QuestionVO {
	
	private int bno;
	private String writer;
	private String b_pwd;
	private String id;
	private String title;
	private String content;
	private Date regdate;
	private Date updatedate;
	private String viewcnt;
	private String replycnt;
	private String[] files;
	
	
	
	
	public String[] getFiles() {
		return files;
	}
	public void setFiles(String[] files) {
		this.files = files;
	}
	public Integer getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	
	public String getB_pwd() {
		return b_pwd;
	}
	public void setB_pwd(String b_pwd) {
		this.b_pwd = b_pwd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public String getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(String viewcnt) {
		this.viewcnt = viewcnt;
	}
	public String getReplycnt() {
		return replycnt;
	}
	public void setReplycnt(String replycnt) {
		this.replycnt = replycnt;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "QuestionVO [bno=" + bno + ", writer=" + writer + ", b_pwd=" + b_pwd + ", id=" + id + ", title=" + title
				+ ", content=" + content + ", regdate=" + regdate + ", updatedate=" + updatedate + ", viewcnt="
				+ viewcnt + ", replycnt=" + replycnt + ", files=" + Arrays.toString(files) + "]";
	}


	
}
