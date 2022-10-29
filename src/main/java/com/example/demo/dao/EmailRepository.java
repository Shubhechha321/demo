package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.user.EmailClass;

@Repository
public interface EmailRepository extends JpaRepository<EmailClass, Integer> {

//	UserClass sender;

	List<EmailClass> findById(Long id);

}
