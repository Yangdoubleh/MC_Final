package com.example.demo.vo;

public class BasketVO {

	private String basketNo, memberID, foodName;

	public BasketVO(String basketNo, String memberID, String foodName) {
		setBasketNo(basketNo);
		setMemberID(memberID);
		setFoodName(foodName);
	}

	public BasketVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBasketNo() {
		return basketNo;
	}

	public void setBasketNo(String basketNo) {
		this.basketNo = basketNo;
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

	@Override
	public String toString() {
		return "BasketVO [basketNo=" + basketNo + ", memberID=" + memberID + ", foodName=" + foodName + "]";
	}
	
	
}
