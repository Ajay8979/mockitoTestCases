package com.candidjava.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.candidjava.spring.bean.User;
public interface UserRepository extends JpaRepository<User, Long>
{
	

}
