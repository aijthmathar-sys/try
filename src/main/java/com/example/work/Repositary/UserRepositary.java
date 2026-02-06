package com.example.work.Repositary;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.work.model.User;

public interface UserRepositary extends MongoRepository<User, String> {


    
} 
    
