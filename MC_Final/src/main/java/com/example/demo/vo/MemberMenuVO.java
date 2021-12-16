package com.example.demo.vo;

import java.util.Date;

public class MemberMenuVO {
	
	private int menuNo;
	private String memberID, foodName, foodDate;
	
	
	public MemberMenuVO(int menuNo, String memberID, String foodName, String foodDate) {
		setMenuNo(menuNo);
		setMemberID(memberID);
		setFoodName(foodName);
		setFoodDate(foodDate);
	}
	
	public MemberMenuVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	public String getFoodDate() {
		return foodName;
	}
	public void setFoodDate(String foodDate) {
		this.foodDate = foodDate;
	}
	
	@Override
	public String toString() {
		return "MemberMenuVO [menuNo=" + menuNo + ", memberID=" + memberID + ", foodName=" + foodName + ", foodDate=" + foodDate + "]";
	}

}
