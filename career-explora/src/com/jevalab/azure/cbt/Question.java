package com.jevalab.azure.cbt;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4228495498192673667L;
	protected String webKey, body,image,userAns,extraInfo;
	protected List<String> alts;
	@Override
	public String toString() {
		return "Question [webKey=" + webKey + ", body=" + body + ", image="
				+ image + ", userAns=" + userAns + ", extraInfo=" + extraInfo
				+ ", alts=" + alts + "]";
	}
	public String getWebKey() {
		return webKey;
	}
	public void setWebKey(String webKey) {
		this.webKey = webKey;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUserAns() {
		return userAns;
	}
	public void setUserAns(String userAns) {
		this.userAns = userAns;
	}
	public String getExtraInfo() {
		return extraInfo;
	}
	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}
	public List<String> getAlts() {
		return alts;
	}
	public void setAlts(List<String> alts) {
		this.alts = alts;
	}
	
	

}
