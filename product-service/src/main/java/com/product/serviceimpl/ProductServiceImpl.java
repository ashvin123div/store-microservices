package com.product.serviceimpl;

import com.product.entity.Product;
import com.product.repository.ProductRepository;
import com.product.service.ProductService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;
	
	@Override
	public Product save(Product product) {
		product.setId(null);
		return productRepository.save(product);
	}

}
