package perscholas.form;

public class FoodInputForm {
	private Integer Id;
	
	private String foodName;
	
	private Integer calories;
	
	private Integer quantity;

	public Integer getId() {
		return Id;
	}

	public String getFoodName() {
		return foodName;
	}

	public Integer getCalories() {
		return calories;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "FoodInputForm [Id=" + Id + ", foodName=" + foodName + ", calories=" + calories + ", quantity="
				+ quantity + "]";
	}
}
