package com.example.myphotoappuserservice.data;

import org.springframework.data.repository.CrudRepository;

import com.example.myphotoappuserservice.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
