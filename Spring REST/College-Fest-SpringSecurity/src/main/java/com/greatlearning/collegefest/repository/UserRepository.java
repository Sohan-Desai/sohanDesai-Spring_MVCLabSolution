package com.greatlearning.collegefest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.collegefest.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsername(String username);
}
