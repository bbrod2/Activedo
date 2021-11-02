package perscholas.form;

public class AddFoodItemForm {
	private Integer Id;
	
	private Integer day;
	
	private String mealType;
	
	private String foodName;
	

	public Integer getId() {
		return Id;
	}

	public Integer getDay() {
		return day;
	}

	public String getMealType() {
		return mealType;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	@Override
	public String toString() {
		return "AddFoodItemForm [Id=" + Id + ", day=" + day + ", mealType=" + mealType + ", foodName=" + foodName + "]";
	}

	

}
	
