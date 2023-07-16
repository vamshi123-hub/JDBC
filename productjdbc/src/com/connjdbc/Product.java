package com.connjdbc;



public class Product {
	private int pid;
	private String pname;
	private double price;
	private String dom;
	
	public Product() {
		
	}

	public Product(int pid, String pname, double price, String dom) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.dom = dom;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", dom=" + dom + "]";
	}

	
	

}
