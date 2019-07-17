package com.example.myphotogalleryaccountservice.data;

import org.springframework.data.repository.CrudRepository;

import com.example.myphotogalleryaccountservice.entity.AccountEntity;

public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {

}
