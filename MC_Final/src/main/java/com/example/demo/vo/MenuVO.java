package com.example.demo.vo;

import java.util.Date;

public class MenuVO {
	
	private String memberID, foodName, foodDate;

	public MenuVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MenuVO(String memberID, String foodName, String foodDate) {
		super();
		this.memberID = memberID;
		this.foodName = foodName;
		this.foodDate = foodDate;
	}

	public String getFoodDate() {
		return foodDate;
	}

	public void setFoodDate(String foodDate) {
		if(foodDate!=null && !foodDate.equals("")) {
			this.foodDate = foodDate;
		} else {
			System.out.println("foodDate error");
		}	
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		if(memberID!=null && !memberID.equals("")) {
			this.memberID = memberID;
		} else {
			System.out.println("memberID error");
		}	
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		if(foodName!=null && !foodName.equals("")) {
			this.foodName = foodName;
		} else {
			System.out.println("foodName error");
		}	
	}

	@Override
	public String toString() {
		return "MenuVO [memberID=" + memberID + ", foodName=" + foodName + ", foodDate=" + foodDate + "]";
	}


	
	
}
