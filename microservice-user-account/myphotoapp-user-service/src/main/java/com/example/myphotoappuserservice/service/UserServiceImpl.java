package com.example.myphotoappuserservice.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.example.myphotoappuserservice.data.UserRepository;
import com.example.myphotoappuserservice.entity.UserEntity;
import com.example.myphotoappuserservice.shared.UserDto;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	private BCryptPasswordEncoder  bCryptPasswordEncoder;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	
	@Override
	public UserDto createUser(UserDto uDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		UserEntity uEntity = modelMapper.map(uDto, UserEntity.class);
		uEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(uDto.getPassword()));
		userRepository.save(uEntity);
		UserDto uDto1 = modelMapper.map(uEntity, UserDto.class);
		return uDto1;
		
	}

	@Override
	public UserDto getById(String uId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<UserDto> getAll() {
		// TODO Auto-generated method stub
		Iterable<UserEntity>entities =  userRepository.findAll();
        List<UserDto> usersDto = null;
        UserDto dto;
        ModelMapper modelMapper = new ModelMapper();
        
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        
        for(UserEntity entity: entities) {
            dto = modelMapper.map(entity, UserDto.class);	
            usersDto.add(dto);
        }
		return usersDto;
	}


	@Override
	public void delete(String uId) {
		// TODO Auto-generated method stub
//		userRepository.deleteById(uId);
	}
}
