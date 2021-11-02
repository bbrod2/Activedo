package perscholas.database.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import perscholas.database.entity.PreScreen;


@Repository 
public interface PreScreenDAO extends JpaRepository<PreScreen, Long> {
	@Query("select p from PreScreen p where p.user.id = :userId")
	List<PreScreen> getWeight(Integer userId);
	
	@Query("select p from PreScreen p where p.user.id = :userId")
	List<PreScreen> getHeight(Integer userId);
	
	@Query("select p from PreScreen p where p.user.id = :userId")
	List<PreScreen> getGoalWeight(Integer userId);
	
	@Modifying
	@Transactional
	@Query(value = "delete from pre_screen where user_id = :userId", nativeQuery = true)
	 void deleteAnswers(Integer userId);

}
