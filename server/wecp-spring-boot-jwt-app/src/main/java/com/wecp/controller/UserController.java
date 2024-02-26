package com.wecp.controller;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.wecp.entities.User;
import com.wecp.repos.UserRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@RestController

//@CrossOrigin("*")
public class UserController {
	
	@Autowired
	UserRepository repository;
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> saveUser(@RequestBody User user)
			throws Exception {

		/**
		 * @todo Perform mandatory validations on the incoming attributes of the User object passed.
		 */

		/**
		 * @todo make sure the user is created if the userId doesn't exist
		 * @todo make sure teh user is updated if the user id passed do exists
		 * 		
		 */
		User usr = null;
			if(usr == null) {
				
			}else {
				usr.setPassword(user.getPassword());			
			}
		Map<String, String> data = new HashMap<>();
		data.put("success", "User added successfully");
		return new ResponseEntity<>(data, null);
	}
	/**
	 * @todo Add the appropriate RequestMapping & PreAuthorize annotations
	 */
	public ResponseEntity<?> getAllUsers()
			throws Exception {

		List<User> users = repository.findAll();

		return ResponseEntity.ok(null);
	}

}
