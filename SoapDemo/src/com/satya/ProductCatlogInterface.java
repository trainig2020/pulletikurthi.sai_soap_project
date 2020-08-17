package com.satya;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.satya.model.Product;


@WebService
public interface ProductCatlogInterface {
     
	@WebMethod
	 List<Product> getAllProducts();
    
	@WebMethod
	 Product getProduct(int pid);
    
	@WebMethod
	 boolean addProduct(String pname , double price);
	
	@WebMethod
	 boolean updateProduct(int pid , String pname , double price);
	
	@WebMethod
	 boolean deleteProduct(int id);
    
}