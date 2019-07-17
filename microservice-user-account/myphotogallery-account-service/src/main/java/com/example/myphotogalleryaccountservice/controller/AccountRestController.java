package com.example.myphotogalleryaccountservice.controller;

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

import com.example.myphotogalleryaccountservice.model.AccountModel;
import com.example.myphotogalleryaccountservice.response.AccountResponseEntity;
import com.example.myphotogalleryaccountservice.service.AccountService;
import com.example.myphotogalleryaccountservice.shared.AccountDto;

@RestController
@RequestMapping("/accounts")
public class AccountRestController {

	@Autowired
	private Environment env;
	
	private AccountService accountService;

	@Autowired
	public AccountRestController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@GetMapping("/status/check")
	public String getAccountStatus() {
		return "account service: running on port: " + env.getProperty("local.server.port");
	}

	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<AccountResponseEntity> createAccount(@RequestBody AccountModel accountModel) {

		ModelMapper modelMapper = new ModelMapper();

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		AccountDto aDto = modelMapper.map(accountModel, AccountDto.class);
		aDto.setAccountNumber(UUID.randomUUID().toString());
	    AccountDto aDto2 = accountService.createAccount(aDto);
	    AccountResponseEntity response = modelMapper.map(aDto2, AccountResponseEntity.class);
		return new ResponseEntity<AccountResponseEntity>(response, HttpStatus.CREATED);
	}
}
