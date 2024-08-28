package perscholas.database.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "food_log")
public class FoodLog {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
	@Column(name = "food_name")
	private String foodName;
	@Column(name = "calories")
	private Integer calories;
	@Column(name = "quantity")
	private Integer quantity;
	@OneToMany(mappedBy = "foodLog", fetch = FetchType.LAZY)
   	private List<UserFood> userFood  = new ArrayList<UserFood>();
	
	public Integer getId() {
		return id;
	}
	public List<UserFood> getUserFood() {
		return userFood;
	}
	public void setUserFood(List<UserFood> userFood) {
		this.userFood = userFood;
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
		this.id = id;
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
	public int hashCode() {
		return Objects.hash(calories, foodName, id, quantity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		FoodLog other = (FoodLog) obj;
		return Objects.equals(calories, other.calories) && Objects.equals(foodName, other.foodName)
				&& Objects.equals(id, other.id) && Objects.equals(quantity, other.quantity);
	}
	@Override
	public String toString() {
		return "FoodLog [id=" + id + ", foodName=" + foodName + ", calories=" + calories + ", quantity=" + quantity
				+ "]";
	}
}
