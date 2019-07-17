package com.example.myphotoappuserservice.controller;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myphotoappuserservice.model.UserModel;
import com.example.myphotoappuserservice.response.UserResponseEntity;
import com.example.myphotoappuserservice.service.UserService;
import com.example.myphotoappuserservice.shared.UserDto;

@RestController
@RequestMapping("/users")
public class UserRestController {

	private UserService userService;

	@Autowired
	public UserRestController(UserService userService) {
		super();
		this.userService = userService;
	}

	@Autowired
	private Environment env;

	
	
	@GetMapping("/status/check")
	public String getUsersStatus() {
		return "users service: running on port: " + env.getProperty("local.server.port");
	}

	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE})
	
	public ResponseEntity<UserResponseEntity> createUser(@RequestBody UserModel uModel) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		UserDto uDto = modelMapper.map(uModel, UserDto.class);

	    uDto.setuId(UUID.randomUUID().toString());
		UserDto uDto1 = userService.createUser(uDto);
		
		UserResponseEntity response = modelMapper.map(uDto1, UserResponseEntity.class);

		return new ResponseEntity<UserResponseEntity>(response, HttpStatus.CREATED);

	}
	
	@GetMapping
	public List<UserResponseEntity> getAll() {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		List<UserDto> users= userService.getAll();
		
		List<UserResponseEntity> userResponseEntities = null;
		
		for(UserDto user: users) {
			UserResponseEntity response = modelMapper.map(user, UserResponseEntity.class);
			userResponseEntities.add(response);
		}
		return userResponseEntities;
		
	}
}
