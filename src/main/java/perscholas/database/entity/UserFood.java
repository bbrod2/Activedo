package perscholas.database.entity;

import jakarta.persistence.*;

import java.util.Objects;



@Entity
@Table(name = "user_food")
public class UserFood {
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
	@Column(name = "day")
	private Integer day;
	@Column(name = "meal_type")
	private String mealType;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id" , referencedColumnName = "id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "food_id", referencedColumnName = "id")
	private FoodLog foodLog;
	public Integer getId() {
		return id;
	}
	public Integer getDay() {
		return day;
	}
	public String getMealType() {
		return mealType;
	}
	public User getUser() {
		return user;
	}
	public FoodLog getFoodLog() {
		return foodLog;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setFoodLog(FoodLog foodLog) {
		this.foodLog = foodLog;
	}
	@Override
	public int hashCode() {
		return Objects.hash(day, foodLog, id, mealType, user);
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
		UserFood other = (UserFood) obj;
		return Objects.equals(day, other.day) && Objects.equals(foodLog, other.foodLog) && Objects.equals(id, other.id)
				&& Objects.equals(mealType, other.mealType) && Objects.equals(user, other.user);
	}
	@Override
	public String toString() {
		return "UserFood [id=" + id + ", day=" + day + ", mealType=" + mealType + ", user=" + user + ", foodLog="
				+ foodLog + "]";
	} 
	

}
