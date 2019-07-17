package com.example.myphotogalleryaccountservice.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.example.myphotogalleryaccountservice.data.AccountRepository;
import com.example.myphotogalleryaccountservice.entity.AccountEntity;
import com.example.myphotogalleryaccountservice.shared.AccountDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AccuntServiceImpl implements AccountService {

	private AccountRepository accountRepository;

	
	public AccuntServiceImpl(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDto createAccount(AccountDto aDto) {
		// TODO Auto-generated method stub
		
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		AccountEntity accountEntity = modelMapper.map(aDto, AccountEntity.class);
		
		accountRepository.save(accountEntity);
		
		AccountDto aDto2 = modelMapper.map(accountEntity, AccountDto.class);
		return aDto2;
		
	}

	
}
