package perscholas.database.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import perscholas.database.entity.Hhq;


@Repository
public interface HhqDAO extends JpaRepository<Hhq, Long>  {
	
	public Hhq findById(@Param("id") Integer id);
	
	public List<Hhq> findAllById(@Param("id") Integer id);

	public Hhq findByQuestion(@Param("question") String question);
	
	@Query(value = "select hq.* from form_hhq hq, form_hhq_answers fqa where hq.id = fqa.question_id and fqa.user_id = :userId", nativeQuery = true)
	List<Hhq> getUserAnsQuestions(@Param("userId") Integer userId);

}
