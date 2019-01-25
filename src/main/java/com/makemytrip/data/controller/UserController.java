package com.makemytrip.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.makemytrip.data.model.User;


@RestController
//@RequestMapping("/user")
//@CrossOrigin("http://localhost:4200")
public class UserController {


	@Autowired
	private MongoTemplate mongoTemplate;

	@GetMapping("/users")
	public List<User> getAllUsers(){
		
		return mongoTemplate.findAll(User.class);
	}


	@GetMapping("/users/{email}")
	public User getUserByEmail(@PathVariable String email) {
		
		return mongoTemplate.findOne(new Query(Criteria.where("email").is(email)), User.class);
	}

	@PostMapping("/users/{id}")
	public User getUserById(@PathVariable long id) {

		return mongoTemplate.findById(id, User.class);
	}

	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		
		return mongoTemplate.save(user);
		
	}


	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable long id,@RequestBody User user) {
		
		return mongoTemplate.save(user);
	}


	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable long id) {
		
		mongoTemplate.remove(new Query(Criteria.where("id").is(id)), User.class);
		return "user has deleted";
	}


	
}
