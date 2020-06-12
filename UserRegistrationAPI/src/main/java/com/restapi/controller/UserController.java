/**
* @author  Jayesh Patel
*/

package com.restapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.model.User;
import com.restapi.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/users")
@Api
public class UserController {
   
	@Autowired
	private UserRepository userRepository;
	
	@ApiResponses(
       value = {
             @ApiResponse(code = 201, message = "User Registered Successfully"),
             @ApiResponse(code = 401, message = "User have no rights to access this resources")
       }
    )
	@RequestMapping(value="/", method=RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Long> userRegistration(@Valid @RequestBody User user) {
        User newUser = new User();    
        newUser= userRepository.save(user);
        
        return ResponseEntity.ok().body(newUser.getId());
	}
	
	@GetMapping(path="/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.ok().body(userRepository.findAll());
	}
	
}
