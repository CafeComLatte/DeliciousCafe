package com.cafe.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafe.entity.ProductVO;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductVO, String>{
	Page<ProductVO> findAll(Pageable pageable);
	
	Optional<ProductVO> findById(String id);
}
