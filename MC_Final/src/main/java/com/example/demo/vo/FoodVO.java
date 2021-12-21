package com.example.demo.vo;

public class FoodVO {
	
	private String foodName, recipeURL, imageURL;
	private int kcal, carb, prot, fat;
	
	public FoodVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodVO(String foodName, String recipeURL, String imageURL, int kcal, int carb, int prot, int fat) {
		super();
		this.foodName = foodName;
		this.recipeURL = recipeURL;
		this.imageURL = imageURL;
		this.kcal = kcal;
		this.carb = carb;
		this.prot = prot;
		this.fat = fat;
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

	public String getRecipeURL() {
		return recipeURL;
	}

	public void setRecipeURL(String recipeURL) {
		if(recipeURL!=null && !recipeURL.equals("")) {
			this.recipeURL = recipeURL;
		} else {
			System.out.println("recipeURL error");
		}
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
			this.imageURL = imageURL;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		if(kcal>=0) {
			this.kcal = kcal;
		} else {
			System.out.println("kcal error");
		}
	}

	public int getCarb() {
		return carb;
	}

	public void setCarb(int carb) {
		if(carb>=0) {
			this.carb = carb;
		} else {
			System.out.println("carb error");
		}
	}

	public int getProt() {
		return prot;
	}

	public void setProt(int prot) {
		if(prot>=0) {
			this.prot = prot;
		} else {
			System.out.println("prot error");
		}
	}

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		if(fat>=0) {
			this.fat = fat;
		} else {
			System.out.println("fat error");
		}
	}

	@Override
	public String toString() {
		return "FoodVO [foodName=" + foodName + ", recipeURL=" + recipeURL + ", imageURL=" + imageURL + ", kcal=" + kcal
				+ ", carb=" + carb + ", prot=" + prot + ", fat=" + fat + "]";
	}
	
	
}
