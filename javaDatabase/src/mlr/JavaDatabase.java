package mlr;

import java.util.List;

import java.util.Scanner;

public class JavaDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag = true;
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDAO dao = new DepartmentDAO();
		
		while(flag) {
			System.out.println("Welcome to DMS");
			System.out.println("1.Add Dept");
			System.out.println("2.Update Dept");
			System.out.println("3.Delete Dept");
			System.out.println("4.Select Dept");
			System.out.println("5.Select All");
			System.out.println("0.Exit");
			
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("Enter Department no:");
				int dno1 = sc.nextInt();
				
				System.out.println("Enter Department name:");
				String dname1 = sc.next();
				
				System.out.println("Enter Department location:");
				String location1 = sc.next();
				
				Department dept1 = new Department();
				
				dept1.setDno(dno1);
				dept1.setDname(dname1);
				dept1.setLocation(location1);
				
				int count = dao.addDept(dept1);
				count++;
				System.out.println(count+"records inserted");
				break;
			case 2:
				System.out.println("Enter Department no:");
				int dno2 = sc.nextInt();
				
				System.out.println("Enter Department name:");
				String dname2 = sc.next();
				
				System.out.println("Enter Department location:");
				String location2 = sc.next();
				
				Department dept2 = new Department();
				dept2.setDno(dno2);
				dept2.setDname(dname2);
				dept2.setLocation(location2);
				
				int count1 = dao.updateDept(dept2);
				count1++;
				System.out.println(count1+"records updated");
				
				break;
			case 3:
				System.out.println("Enter Dept to delete one record");
				int dno3 = sc.nextInt();
				int count2 = dao.deleteDept(dno3);
				count2++;
				System.out.println(count2+"recored Deleted");
				
				
				break;
			case 4:
				System.out.println("Enter dno to select record");
				int dno4 = sc.nextInt();
				Department deptObj = dao.selectDept(dno4);
			
				System.out.println(deptObj);
	
				break;
			case 5:
				List<Department> list = dao.getAll();

				for (Department department : list) {
					System.out.println(department);

				}

	
				break;
			case 0:
				flag = false;

			default:
				System.out.println("invalid input");
				break;
			}
		}
	}

}
