package amar.jp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amar.jp.model.User;
import amar.jp.repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	public User saveUser(User user) {
		return registrationRepository.save(user);
	}
	
	public User fetchUserByEmail(String email) {
		return registrationRepository.findByEmailId(email);
	}
	
	public User fetchUserByEmailIdAndPassword(String emailId, String password) {
		return registrationRepository.findByEmailIdAndPassword(emailId, password);
	}
}
