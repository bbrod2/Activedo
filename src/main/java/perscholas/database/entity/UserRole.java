package perscholas.database.entity;

import java.util.Objects;
import jakarta.persistence.*;


@Entity
@Table(name = "user_role")
public class UserRole {
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	@Column(name = "user_role")
    private String UserRole;
	public Integer getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public String getUserRole() {
		return UserRole;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setUserRole(String userRole) {
		UserRole = userRole;
	}
	@Override
	public int hashCode() {
		return Objects.hash(UserRole, id, user);
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
		UserRole other = (UserRole) obj;
		return Objects.equals(UserRole, other.UserRole) && Objects.equals(id, other.id)
				&& Objects.equals(user, other.user);
	}
	@Override
	public String toString() {
		return "UserRole [id=" + id + ", user=" + user + ", UserRole=" + UserRole + "]";
	}
	
	
	
	
	

	
}
