package org.spring.demo.model;

public class WorkLog {

	int wid;
	String author;
	String content;
	String date;

	public WorkLog(String author, String content, String date)
	{
		this.author = author;
		this.content = content;
		this.date = date;
	}
	
	public WorkLog(int wid, String author, String content, String date)
	{
		this.wid = wid;
		this.author = author;
		this.content = content;
		this.date = date;
	}
	
	public int getWid() {
		return wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "WorkLog [wid=" + wid + ", author=" + author + ", content="
				+ content + ", date=" + date + "]";
	}

}
