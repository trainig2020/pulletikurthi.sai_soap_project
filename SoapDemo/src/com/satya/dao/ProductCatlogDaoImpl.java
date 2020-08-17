package com.satya.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.satya.model.Product;
@WebService(endpointInterface="com.satya.dao.ProductCatlogDao")
public class ProductCatlogDaoImpl implements ProductCatlogDao {

	
	static Connection con;
	
	static void getConnectionMySql()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
       
            e.printStackTrace();
        }
        try {
            con=DriverManager.getConnection(
            		"jdbc:mysql://localhost:3306/Testmart?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false","root","Root");
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
	}
	@Override
	public List<Product> getAllProducts() {
		getConnectionMySql();
		List<Product> listpro =new ArrayList<>();
		String query ="select * from product";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
				int pid =rs.getInt(1);
				String pname = rs.getString(2);
				double price =rs.getDouble(3);
				Product pro = new Product(pid,pname,price);
				listpro.add(pro);
				
			}
			System.out.println("All Data From Department");
			
			
		} catch (SQLException e) {
			System.err.println("Data may not present");		
			}

		return listpro;
		}
	
	@Override
	public Product getProduct(int pid) {
		getConnectionMySql();
		Product pro = null ;
		String query ="select * from product where pid=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, pid);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
				int proId =rs.getInt(1);
				String pname = rs.getString(2);
				double price =rs.getDouble(3);
				 pro = new Product(pid,pname,price);
				
				
			}
			System.out.println("All Data From Department");
			
			
		} catch (SQLException e) {
			System.err.println("Data may not present");		}

		return pro;
	}

	@Override
	public boolean addProduct(Product product) {
		System.out.println("product details "+product.getPid()+" "+product.getPname()+ " "+product.getPrice());
		
		String query ="insert into product values (default,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, product.getPname());
			ps.setDouble(2, product.getPrice());
			ps.executeUpdate();
			System.out.println("product created");
			
		} catch (SQLException e) {
			System.err.println("Duplicate primary key ! change pid ");
		}
		
	
		return true;
	}

	@Override
	public boolean updateProduct(Product product) {
             getConnectionMySql();
		
		
		String query ="update product set pname=?,price=? where pid=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, product.getPname());
			ps.setDouble(2, product.getPrice());
			ps.setInt(3, product.getPid());
			ps.executeUpdate();
			System.out.println("Product Updated");
			//con.close();
		} catch (SQLException e) {
		
			System.err.println("data not found");
			
		}
		return true;
	}

	@Override
	public boolean deleteProduct(int pid) {
		
		String query ="delete from product where pid=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setInt(1, pid);
			ps.executeUpdate();
			
			System.out.println("Data deleted from product");
			
		} catch (SQLException e) {
			
			System.err.println("data may not present");
		}
		
		return true;
	}
	
}
