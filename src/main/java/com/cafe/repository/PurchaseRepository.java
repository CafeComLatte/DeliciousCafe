package com.cafe.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafe.entity.PurchaseVO;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseVO, String>{

	Page<PurchaseVO> findAll(Pageable pageable);
}
