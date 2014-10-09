package org.han.vo;

import java.util.Date;

public class ReviewVo {
	
	private Integer rno; 
	private Integer mno; 
	private String review; 
	private String userid; 
	private Date regate; 
	private Integer score;
	
	@Override
	public String toString() {
		return "ReviewVo [rno=" + rno + ", mno=" + mno + ", review=" + review
				+ ", userid=" + userid + ", score=" + score + "]";
	}
	public Integer getRno() {
		return rno;
	}
	public void setRno(Integer rno) {
		this.rno = rno;
	}
	public Integer getMno() {
		return mno;
	}
	public void setMno(Integer mno) {
		this.mno = mno;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getRegate() {
		return regate;
	}
	public void setRegate(Date regate) {
		this.regate = regate;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	} 

	
	

}
