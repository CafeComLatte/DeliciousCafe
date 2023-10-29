package com.cafe.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.cafe.entity.PurchaseVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PurchasePageDTO {
	private List<PurchaseDTO> elements;
	private long totalElements;
	private int currentPage;
	private int totalPages;
	
	public static PurchasePageDTO of(Page<PurchaseVO> pages) {
		return PurchasePageDTO.builder()
				.elements(pages.getContent().stream().map(entity -> PurchaseDTO.of(entity)).collect(Collectors.toList()))
				.totalElements(pages.getTotalElements())
				.totalPages(pages.getTotalPages())
				.currentPage(pages.getNumber()).build();
	}

	@Override
	public String toString() {
		return "PurchasePageDTO [elements=" + elements + ", totalElements=" + totalElements + ", currentPage="
				+ currentPage + ", totalPages=" + totalPages + "]";
	}
	
	
}
