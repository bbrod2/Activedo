package perscholas.database.dao;

import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import perscholas.database.entity.HhqAnswers;
import perscholas.database.entity.UserFood;

@Repository
public interface HhqAnswersDAO extends JpaRepository<HhqAnswers, Long> {
	
	@Query("select ha from HhqAnswers ha where ha.user.id = :userId")
	List<HhqAnswers> getUserAnswers(Integer userId);
	
	@Modifying
	@Transactional
	@Query(value = "delete from form_hhq_answers where user_id = :userId", nativeQuery = true)
	 void deleteAnswers(Integer userId);
	
	
	
	

	

	

}
