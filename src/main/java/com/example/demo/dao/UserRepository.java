package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.example.demo.user.EmailClass;
import com.example.demo.user.UserClass;

public interface UserRepository extends JpaRepository<UserClass, Integer> {
	@Modifying(clearAutomatically = true)
	List<UserClass> findById(Long id);

	default Long updateCount(UserClass sender, EmailClass email) {
		UserClass user = email.getSender();
		
		user.ecount = 9;
		return null;
	}

	

//	default Long updateCount(UserClass sender, EmailClass email) {
//		if(sender.getId().equals(sender.id)) {
//			int ecount = sender.getEcount() + 1;
//			sender.setEcount(ecount+1);
//			return (long) ecount;
//		}
//		return null;
//	};
	
	

}