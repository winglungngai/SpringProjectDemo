package org.spring.demo.model;

import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "tea")
public class Tea {
 
	String name;
	int quanlity;
	String origin;
	
	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	
 
	public int getQuanlity() {
		return quanlity;
	}
 
	public void setQuanlity(int quanlity) {
		this.quanlity = quanlity;
	}
 
	public Tea(String name, int quanlity, String origin) {
		this.name = name;
		this.quanlity = quanlity;
		this.origin = origin;
	}
 
	public Tea() {
	}
 
}