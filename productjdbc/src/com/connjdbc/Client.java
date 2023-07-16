package com.connjdbc;


import java.util.List;
import java.util.Scanner;


public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean flag = true;
		
		Scanner sc = new Scanner(System.in);
		
		IProductServices service = new ProductServicesImp();
		
		while(flag) {
			System.out.println("Welcome to DMS");
			System.out.println("1.Add prod");
			System.out.println("2.Update prod");
			System.out.println("3.Delete prod");
			System.out.println("4.Select prod");
			System.out.println("5.Select All");
			System.out.println("0.Exit");
			
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("Enter Product pid:");
				int pid1 = sc.nextInt();
				
				System.out.println("Enter Product name:");
				String pname1 = sc.next();
				
				System.out.println("Enter Product price:");
				Double price1 = sc.nextDouble();
				
				System.out.println("Enter Product dom:");
				String dom1 = sc.next();
				
				
				
				Product prod1 = new Product();
				
				prod1.setPid(pid1);
				prod1.setPname(pname1);
				prod1.setPrice(price1);
				prod1.setDom(dom1);
				
				boolean isValid = ProductServicesImp.dataInputValidation(prod1);
				if(isValid == true) {
					int count = service.addProd(prod1);
					System.out.println(count+"record inserted");
				}
					
					else {
						System.out.println("Invalid input");
					}
				
				
				break;
			case 2:
				System.out.println("Enter Product id:");
				int pid2 = sc.nextInt();
				
				System.out.println("Enter Product name:");
				String pname2 = sc.next();
				
				System.out.println("Enter Product Price:");
				Double price2 = sc.nextDouble();
				
				System.out.println("Enter Product Dom:");
				String dom2 = sc.next();
				
				Product prod2 = new Product();
				
				prod2.setPid(pid2);
				prod2.setPname(pname2);
				prod2.setPrice(price2);
				prod2.setDom(dom2);
				
				boolean isValid1 = ProductServicesImp.dataInputValidation(prod2);
				if(isValid1 == true) {
					int count = service.updateProd(prod2);
					System.out.println(count+"record updated");
				}
					
					else {
						System.out.println("Invalid input");
					}
				
				break;
			case 3:
				System.out.println("Enter pid to delete one record");
				int pid3 = sc.nextInt();
				int count2 = service.deleteProd(pid3);
				count2++;
				System.out.println(count2+"recored Deleted");
				
				if(count2 == 0) {
					try {
					throw new ProductNotFoundException();
				}
					catch(Exception e) {
						System.err.println("Prod Not Found");
					}
				}
				break;
			case 4:
				System.out.println("Enter pid to select record");
				int pid4 = sc.nextInt();
				Product prodObj = service.selectDept(pid4);
			
				System.out.println(prodObj);
				if(prodObj == null) {
					try {
					throw new ProductNotFoundException();
				}
					catch(Exception e) {
						System.err.println("prod Not Found");
					}
				}
	
				break;
			case 5:
				List<Product> list = service.getAll();

				for (Product product : list) {
					System.out.println(product);

				}

	
				break;
			case 0:
				flag = false;
				DButil.closeConnection();
				System.out.println("Thank you");
				
				break;
			default:
				System.err.println("invalid input");
				break;
			}
		}
	}

}


