package com.example.demo;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {
	
	
	@RequestMapping(path="/user", method = RequestMethod.GET)
	public ResponseEntity<List<User>>  listUser(ModelMap model){
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName(); //get logged in username
	      
	      
			
//	      model.addAttribute("username", name);
	      System.out.println("hello"+" "+name+" "+"ur logged in");
		return new ResponseEntity<List<User>>(getUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(path="/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User>  listUser(@PathVariable(value = "id") String id){
		return new ResponseEntity<User>(getUsers().stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null), HttpStatus.OK);
		
	}
	
	@RequestMapping(path="/user", method = RequestMethod.POST)
	public ResponseEntity<String>  listUser(@RequestBody User user){
		return new ResponseEntity<String>("18", HttpStatus.OK);
	}
	
	private List<User> getUsers() {
		User user = new User();
		user.setId("12");
		user.setEmail("johndoe123@gmail.com");
		user.setName("John Doe");
		user.setAddress("Bangalore, Karnataka");
		User user1 = new User();
		user1.setId("13");
		user1.setEmail("amitsingh@yahoo.com");
		user1.setName("Amit Singh");
		user1.setAddress("Chennai, Tamilnadu");
		User user2 = new User();
		user2.setId("14");
		user2.setEmail("bipulkumar@gmail.com");
		user2.setName("Bipul Kumar");
		user2.setAddress("Bangalore, Karnataka");
		User user3 = new User();
		user3.setId("15");
		user3.setEmail("prakashranjan@gmail.com");
		user3.setName("Prakash Ranjan");
		user3.setAddress("Chennai, Tamilnadu");
		return Arrays.asList(user, user1, user2, user3);
	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	if (auth != null){ 
	new SecurityContextLogoutHandler().logout(request, response, auth);
	}
	return "redirect:/login";
	}


}
