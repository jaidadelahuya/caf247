package com.jevalab.azure.cbt;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public class CBT implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5998555358321781827L;
	private String vendorName, vendorLogo, year, username,title;
	private int noQ, time;
	private Map<String, List<Question>> questionMap;
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorLogo() {
		return vendorLogo;
	}
	public void setVendorLogo(String vendorLogo) {
		this.vendorLogo = vendorLogo;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNoQ() {
		return noQ;
	}
	public void setNoQ(int noQ) {
		this.noQ = noQ;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public Map<String, List<Question>> getQuestionMap() {
		return questionMap;
	}
	public void setQuestionMap(Map<String, List<Question>> questionMap) {
		this.questionMap = questionMap;
	}
	@Override
	public String toString() {
		return "CBT [vendorName=" + vendorName + ", vendorLogo=" + vendorLogo
				+ ", year=" + year + ", username=" + username + ", title="
				+ title + ", noQ=" + noQ + ", time=" + time + ", questionMap="
				+ questionMap + "]";
	}
	
	

}
