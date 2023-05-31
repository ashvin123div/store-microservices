package com.product.repository;

import com.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	//@Query(value="SELECT * FROM store_discounts_application.product p ORDER BY RAND() LIMIT 3",nativeQuery = true)
	//public List<Product> findAllProduct();

}
