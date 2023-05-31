package com.bill.service;

import com.bill.dto.BillDto;

public interface GeneratebillService {

	BillDto generateBillWithDiscount(Long userId);

}
