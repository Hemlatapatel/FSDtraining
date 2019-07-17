package com.example.myphotoappuserservice.service;

import java.util.List;

import com.example.myphotoappuserservice.entity.UserEntity;
import com.example.myphotoappuserservice.shared.UserDto;

public interface UserService {

	UserDto createUser(UserDto uDto);

	UserDto getById(String uId);
	
	List<UserDto> getAll();
	
	void delete(String uId);
	
}
