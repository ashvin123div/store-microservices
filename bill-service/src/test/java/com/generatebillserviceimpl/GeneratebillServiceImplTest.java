package com.generatebillserviceimpl;

import com.bill.dto.BillDto;
import com.bill.entity.Product;
import com.bill.entity.User;
import com.bill.exception.ValidationException;
import com.bill.repository.ProductRepository;
import com.bill.repository.UserRepository;
import com.bill.serviceimpl.GeneratebillServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class GeneratebillServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private GeneratebillServiceImpl generatebillService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGenerateBillWithDiscount_UserNotFound() {
        // Arrange
        Long userId = 1L;
        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Act and Assert
        Assertions.assertThrows(ValidationException.class, () -> {
            generatebillService.generateBillWithDiscount(userId);
        });

        verify(userRepository, times(1)).findById(userId);
        verifyNoMoreInteractions(userRepository);
        verifyNoInteractions(productRepository);
    }

    @Test
    public void testGenerateBillWithDiscount_ProductNotFound() {
        // Arrange
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(productRepository.findAll()).thenReturn(new ArrayList<>());
    }

    @Test
    public void testGenerateBillWithDiscount_Success() {
        // Arrange
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setUserName("John");
        user.setAddress("123 Main St");
        user.setRole("Customer");
        Calendar cal = Calendar.getInstance();
		  cal.add(Calendar.YEAR, 3); 
		  Date date = cal.getTime();
        user.setCreateDate(date);

        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", "groceries", 10.0));
        products.add(new Product("Product 2", "non-groceries", 20.0));
        products.add(new Product("Product 3", "non-groceries", 30.0));
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(productRepository.findAll()).thenReturn(products);

        // Act
        BillDto result = generatebillService.generateBillWithDiscount(userId);


        verify(userRepository, times(1)).findById(userId);
        verify(productRepository, times(1)).findAll();
        verifyNoMoreInteractions(userRepository, productRepository);
    }
    
    @Test
    public void testGenerateBillWithDiscount_Success1() {
        // Arrange
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setUserName("John");
        user.setAddress("123 Main St");
        user.setRole("EMPLOYEE");
        user.setCreateDate(new Date());

        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", "groceries", 10.0));
        products.add(new Product("Product 2", "non-groceries", 20.0));
        products.add(new Product("Product 3", "non-groceries", 30.0));
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(productRepository.findAll()).thenReturn(products);

        // Act
        BillDto result = generatebillService.generateBillWithDiscount(userId);


        verify(userRepository, times(1)).findById(userId);
        verify(productRepository, times(1)).findAll();
        verifyNoMoreInteractions(userRepository, productRepository);
    }
    
    @Test
    public void testGenerateBillWithDiscount_Success2() {
        // Arrange
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setUserName("John");
        user.setAddress("123 Main St");
        user.setRole("AFFILIATE");
        user.setCreateDate(new Date());

        List<Product> products = new ArrayList<>();
        products.add(new Product("Product 1", "groceries", 10.0));
        products.add(new Product("Product 2", "non-groceries", 20.0));
        products.add(new Product("Product 3", "non-groceries", 30.0));
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(productRepository.findAll()).thenReturn(products);

        // Act
        BillDto result = generatebillService.generateBillWithDiscount(userId);


        verify(userRepository, times(1)).findById(userId);
        verify(productRepository, times(1)).findAll();
        verifyNoMoreInteractions(userRepository, productRepository);
    }

    // Add more test cases for other methods as needed

}

