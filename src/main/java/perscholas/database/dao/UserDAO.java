package perscholas.database.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import perscholas.database.entity.FoodLog;
import perscholas.database.entity.PreScreen;
import perscholas.database.entity.User;
import perscholas.database.entity.UserRole;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

	public User findById(@Param("id") Integer id);

	public User findByEmail(@Param("email") String email);

	@Query("select u from User u where lower(u.email) like lower(concat('%', :email,'%'))")
	public List<User> findByEmailStartsWith(@Param("email") String email);

	@Query("select ur from UserRole ur where ur.user.id = :userId")
	List<UserRole> getUserRoles(Integer userId);

	

}
