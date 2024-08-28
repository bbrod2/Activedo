package perscholas.database.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import perscholas.database.entity.FoodLog;
import perscholas.database.entity.UserFood;



@Repository
public interface UserFoodDAO extends JpaRepository<UserFood, Long> {

	@Query("select uf from UserFood uf where uf.user.id = :userId")
	List<UserFood> getUserfood(Integer userId);
	
	
	
	
}
