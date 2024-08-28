package perscholas.database.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import perscholas.database.entity.FoodLog;

@Repository
public interface FoodLogDAO extends JpaRepository<FoodLog, Long> {

	public FoodLog findById(@Param("id") Integer id);

	public List<FoodLog> findAllById(@Param("id") Integer id);

	public FoodLog findByFoodName(@Param("food_name") String foodName);

	@Query(value = "select fl.* from food_log fl, user_food uf where fl.id = uf.food_id and uf.user_id = :userId and uf.meal_type = :mealType and uf.day = :day", nativeQuery = true)
	List<FoodLog> getUserFoodLog(@Param("userId") Integer userId, @Param("mealType") String mealType,
			@Param("day") Integer day);

}
