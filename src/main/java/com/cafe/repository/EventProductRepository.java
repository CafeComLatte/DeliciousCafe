package com.cafe.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafe.entity.EventProductVO;

@Repository
public interface EventProductRepository extends JpaRepository<EventProductVO, String>{
	public List<EventProductVO> findAllById(Iterable<String> id);
}
