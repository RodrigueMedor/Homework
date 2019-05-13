package com.MyProductsMgmtWebApp.ServicesProduct;

import java.util.List;

import com.MyProductsMgmtWebApp.model.Product;
import com.MyProductsMgmtWebApp.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {


    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct(){
       return  this.productRepository.findAll();
        
    }

    public void addProduct(Product product){
        this.productRepository.save(product);
    }

    public Product findOne(int id){
        return getAllProduct().stream()
        .filter(x->x.getProdID() == id).findFirst().get();
    }
    public boolean deleteProduct(int id){
        return getAllProduct().removeIf(x->x.getProdID()==id);
    }

    public void updateProduct(int id) {
		for(int i =0; i < this.getAllProduct().size();i++) {
            Product prod = getAllProduct().get(i);
            if(prod.getProdID()== id){
            getAllProduct().set(i, prod);
			return;
			}
		
		}
		
	}
}