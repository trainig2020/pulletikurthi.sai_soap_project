package com.satya.service;

import java.util.List;

import javax.jws.WebMethod;

import javax.jws.WebService;

import com.satya.model.Product;

@WebService
public interface ProductCatlogService {
     
	@WebMethod
	 List<Product> getAllProducts();
    
	@WebMethod
	 Product getProduct(int pid);
    
	@WebMethod
	 boolean addProduct(Product product);
	
	@WebMethod
	 boolean updateProduct(Product product);
	
	@WebMethod
	 boolean deleteProduct(int id);

    
}