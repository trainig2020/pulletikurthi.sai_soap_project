package com.satya;

import java.util.List;


import javax.jws.WebService;

import com.satya.model.Product;
import com.satya.service.ProductCatlogService;
import com.satya.service.ProductServiceImpl;

@WebService(endpointInterface = "com.satya.ProductCatlogInterface")
public class ProductCatlog implements ProductCatlogInterface {
     
	ProductCatlogService pcs = new ProductServiceImpl();
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> lst = pcs.getAllProducts();
		return lst;
	}

	@Override
	public Product getProduct(int pid) {
		Product product =pcs.getProduct(pid);
		return product;
	}

	@Override
	public boolean addProduct(String pname, double price) {
		Product pt = new Product();
		pt.setPname(pname);
		pt.setPrice(price);
		pcs.addProduct(pt);
		return false;
	}

	@Override
	public boolean updateProduct(int pid, String pname, double price) {
		Product product = new Product(pid, pname, price);
		pcs.updateProduct(product);
		return false;
	}

	@Override
	public boolean deleteProduct(int id) {
		pcs.deleteProduct(id);
		return false;
	}
   
	
}
