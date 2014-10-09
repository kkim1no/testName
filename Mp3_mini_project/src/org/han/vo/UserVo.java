package org.han.vo;

import java.util.Date;

public class UserVo {

	private String userid; 
	private String pw; 
	private Date regdate;
	
	@Override
	public String toString() {
		return "UserVo [userid=" + userid + ", pw=" + pw + "]";
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	} 

}
