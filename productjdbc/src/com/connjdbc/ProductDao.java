package com.connjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ProductDao {
	
	Connection conn = DButil.getDBConnection();
	
	public int addProd(Product prod) {
		String insertQuery = "insert product values(?,?,?,?)";
		int count = 0;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);
			pstmt.setInt(1, prod.getPid());
			pstmt.setString(2, prod.getPname());
			pstmt.setDouble(3, prod.getPrice());
			pstmt.setString(4, prod.getDom());
			
			count = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	
	public int updateProd(Product prod) {
		String updateQuery = "update product set pname=?,price=?,dom=? where pid =?";
		int count1 = 0;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, prod.getPname());
			pstmt.setDouble(2, prod.getPrice());
			pstmt.setInt(3, prod.getPid());
			pstmt.setString(4, prod.getDom());
			
			count1 = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return count1;
	}
	
	public Product selectDept(int pidNo) {
		String selectQuerry = "select * from product where pid =?";
		Product prod = new Product();
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectQuerry);
			pstmt.setInt(1, pidNo);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				Double price = rs.getDouble("price");
				String dom = rs.getString("dom");
				
				prod.setPid(pid);
				prod.setPname(pname);
				prod.setPrice(price);
				prod.setDom(dom);
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return prod;
	}
	
	public int deleteProd(int pidNo) {
		String deleteQuery = "delete from product where pid=?";
		int count2 = 0;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
			pstmt.setInt(1, pidNo);
			
			count2 = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return count2;
	}
	public List<Product> getAll() {

		String selectAllQuery = "select * from product";

		List<Product> list = new ArrayList<Product>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(selectAllQuery);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int pid = rs.getInt("pid");
				String pname = rs.getString("pname");
				Double price = rs.getDouble("price");
				String dom = rs.getString("dom");

				Product prod = new Product();
				list.add(prod);

				prod.setPid(pid);
				prod.setPname(pname);
				prod.setPrice(price);
				prod.setDom(dom);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
