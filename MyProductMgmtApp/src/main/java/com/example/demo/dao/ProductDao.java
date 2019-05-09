package com.example.demo.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductDao {
	
	@Autowired
	private ProductRepository productSevice;
	
	public List<Product> getAllTopic(){
		List<Product> topics = new ArrayList<>();
		this.productSevice.findAll()
		.forEach(topics::add);
		return topics;
	}
	
//	public List<Product> getAllProduct(){
//		
//		return this.productSevice.findAll();
//	}
	
	public void getSaveProduct(Product product) {
		this.productSevice.save(product);
	}
	
	public Iterable<Product>  findOne(Iterable<Long> id) {
		return this.productSevice.findAllById(id);
	}
	public void deleteProduct(Product prod) {
		this.productSevice.delete(prod);
	}
	
	public Product getTopic(String id) {
		return this.getAllTopic().stream().filter(x->x.getName().equals(id)).findFirst().get();
	}

	public void updateTopic(String id) {
		for(int i =0; i < this.getAllTopic().size();i++) {
			Product product= getAllTopic().get(i);
			if(product.getName().equals(id)) {
				getAllTopic().set(i, product);
			return;
			}
		
		}
		
	}

	public void deleteTopic(String id) {
		this.getAllTopic().removeIf(c->c.getName().equals(id));
		
	}

}
