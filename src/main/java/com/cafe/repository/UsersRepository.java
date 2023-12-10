package com.cafe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cafe.entity.UsersVO;
import java.util.List;


@Repository
public interface UsersRepository extends JpaRepository<UsersVO, String>{
	@Procedure("SIGNUP")
	int signUp(@Param("id") String id,@Param("password") String password,@Param("name") String name,@Param("email") String email,@Param("phone") String phone );

	int countById(String id);
	
	int countByIdAndPassword(String id, String password);
	
	Optional<UsersVO> findByIdAndPassword(String id, String password);
	
	Optional<UsersVO> findById(String id);
}
