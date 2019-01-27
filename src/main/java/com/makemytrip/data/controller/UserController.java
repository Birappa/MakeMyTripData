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
import org.springframework.web.bind.annotation.RestController;

import com.makemytrip.data.exception.AlreadyUserExistException;
import com.makemytrip.data.exception.NoUserExistException;
import com.makemytrip.data.exception.UserNotExistException;
import com.makemytrip.data.model.User;



@RestController
@CrossOrigin("*")
public class UserController {


	@Autowired
	private MongoTemplate mongoTemplate;

	//returns all users from user collection
	@GetMapping("/users")
	public List<User> getAllUsers(){
		
		List<User> users=mongoTemplate.findAll(User.class);
		if(users==null) {
			throw new NoUserExistException("No User Exist");
		}
		return users;
	}

	//returns user object from user collection that matches the email
	@GetMapping("/users/{email}")
	public User getUserByEmail(@PathVariable String email) {
		
		User user=mongoTemplate.findOne(new Query(Criteria.where("email").is(email)), User.class);
		if(user==null) {
			throw new UserNotExistException("User Not Exist");
		}
		return user; 
	}

	//returns user object from user collection that matches the id
	@PostMapping("/users/{id}")
	public User getUserById(@PathVariable long id) {

		User user=mongoTemplate.findById(id, User.class);
		if(user==null) {
			throw new UserNotExistException("User Not Exist");
		}
		return user;
	}

	//save the provided user object in user collection and returns same object back
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		
		User user1=mongoTemplate.findOne(new Query(Criteria.where("email").is(user.getEmail())), User.class);
		if(user1!=null) {
			throw new AlreadyUserExistException("Already User Exist");
		}
		return mongoTemplate.save(user);
		
	}

	//update the provided object in user collection
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable long id,@RequestBody User user) {
		
		return mongoTemplate.save(user);
	}


	//Remove document that match the provided id from the user collection
	@DeleteMapping("/users/{id}")
	public boolean deleteUser(@PathVariable long id) {
		
		User user=mongoTemplate.findById(id, User.class);
		if(user==null) {
			throw new UserNotExistException("User Not Exist");
		}
		
		return mongoTemplate.remove(new Query(Criteria.where("id").is(id)), User.class).wasAcknowledged();
	}


	
}
