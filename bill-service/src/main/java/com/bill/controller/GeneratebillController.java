package com.bill.controller;

import com.bill.dto.BillDto;
import com.bill.service.GeneratebillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/bill")
@Slf4j
@AllArgsConstructor
public class GeneratebillController {
	
    private GeneratebillService generatebillService;
    
	@GetMapping("/generate-bill/{userId}")
	public ResponseEntity<BillDto> generateBillWithDiscount(
			@PathVariable Long userId) {
		log.info("generate bill method {}");
		return new ResponseEntity<BillDto>(generatebillService.generateBillWithDiscount(userId),
				HttpStatus.OK);
	}
}
