package mlr;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
	
	Connection conn = DButil.getDBConnection();

	public int addDept(Department dept) {
		String insertQuery = "insert Dept values(?,?,?)";
		int count = 0;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);
			pstmt.setInt(1, dept.getDno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLocation());
			
			count = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	
	public int updateDept(Department dept) {
		String updateQuery = "update dept set dname=?,location=? where dno =?";
		int count1 = 0;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(updateQuery);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLocation());
			pstmt.setInt(3, dept.getDno());
			
			count1 = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return count1;
	}
	
	public Department selectDept(int deptNo) {
		String selectQuerry = "select * from dept where dno =?";
		Department dept = new Department();
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectQuerry);
			pstmt.setInt(1, deptNo);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int dno = rs.getInt("dno");
				String dname = rs.getString("dname");
				String location = rs.getString("location");
				
				
				dept.setDno(dno);
				dept.setDname(dname);
				dept.setLocation(location);
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return dept;
	}
	
	public int deleteDept(int deptNo) {
		String deleteQuery = "delete from dept where dno=?";
		int count2 = 0;
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
			pstmt.setInt(1, deptNo);
			
			count2 = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return count2;
	}
	public List<Department> getAll() {

		String selectAllQuery = "select * from dept";

		List<Department> list = new ArrayList<Department>();

		try {
			PreparedStatement pstmt = conn.prepareStatement(selectAllQuery);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				int dno = rs.getInt("dno");
				String dname = rs.getString("dname");
				String location = rs.getString("location");

				Department dept = new Department();
				list.add(dept);

				dept.setDno(dno);
				dept.setDname(dname);
				dept.setLocation(location);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}


