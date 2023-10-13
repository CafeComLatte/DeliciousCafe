package com.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cafe.entity.UsersVO;

@Repository
public interface UsersRepository extends JpaRepository<UsersVO, Integer>{
	@Procedure("SIGNUP")
	int signUp(@Param("id") String id,@Param("password") String password,@Param("name") String name,@Param("email") String email,@Param("phone") String phone );

	int countByIdAndPassword(String id, String password);
}
