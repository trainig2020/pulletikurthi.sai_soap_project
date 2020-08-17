package com.satya.service;

import java.util.List;

import javax.jws.WebService;

import com.satya.dao.ProductCatlogDao;
import com.satya.dao.ProductCatlogDaoImpl;
import com.satya.model.Product;

@WebService(endpointInterface = "com.satya.service.ProductCatlogService")
public class ProductServiceImpl implements ProductCatlogService {
    
	ProductCatlogDao pcd = new ProductCatlogDaoImpl();
	
	@Override
	public List<Product> getAllProducts() {
		return  pcd.getAllProducts();
		
	}

	@Override
	public Product getProduct(int pid) {
		return pcd.getProduct(pid);
		
	}

	@Override
	public boolean addProduct(Product product) {
		pcd.addProduct(product);
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		pcd.updateProduct(product);
		return false;
	}

	@Override
	public boolean deleteProduct(int id) {
		pcd.deleteProduct(id);
		return false;
	}
     

}
