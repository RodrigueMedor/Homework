package com.example.demo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;


@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);	
	}
	void saveProduct() {		
		Product product = new Product();
		product.setPid(104);
		product.setProductNumber(12);
		product.setUnitPrice(1500.2f);
		product.setName("iPhone XS Max");
		product.setDateMfd(LocalDate.of(2018, 10, 24));
		
		System.out.println(productRepository.findAll());
		
		productRepository.save(product);
	}
	
	@Override
	public void run(String... args) throws Exception {
		saveProduct();		
	}

}
