package amar.jp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import amar.jp.model.User;

@Repository
public interface RegistrationRepository extends JpaRepository<User, Long>{
	
	public User findByEmailId(String email);
	public User findByEmailIdAndPassword(String email, String password);
}
