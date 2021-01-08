package amar.jp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import amar.jp.model.User;
import amar.jp.service.RegistrationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@PostMapping("/register")
	public ResponseEntity<User> RegisterUser(@RequestBody User user) throws Exception{
		
		String tempEmailId= user.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)) {
			User userObj = registrationService.fetchUserByEmail(tempEmailId);
			if(userObj != null) {
				throw new Exception("User with "+tempEmailId+ " already exist");
			}
		}
		User userObj= null;
		userObj = registrationService.saveUser(user);
		return ResponseEntity.ok(userObj);
	}
	
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String temppassword = user.getPassword();
		User userObj = null;
		if(tempEmailId != null && temppassword != null) {
			userObj = registrationService.fetchUserByEmailIdAndPassword(tempEmailId, temppassword);
		}
		if(userObj == null) {
			throw new Exception("Bad Credentials!!");
		}
		return ResponseEntity.ok(userObj);
	}
	
	
	
	
	
}
