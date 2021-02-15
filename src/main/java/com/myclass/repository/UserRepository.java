package com.myclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.myclass.dto.UserDto;
import com.myclass.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("SELECT new com.myclass.dto.UserDto(u.id, u.fullname, u.email, r.description) FROM User u JOIN Role r ON u.roleId = r.id")
	public List<UserDto> findAllJoin(); 
	
//	@Query("SELECT u FROM User u WHERE u.email = :email")
//	public User findByEmail(@Param("email") String email);
	
	public User findByEmail(String email);
}
