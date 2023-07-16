package com.connjdbc;

import java.util.List;

public interface IProductServices {
	public int addProd(Product prod);
	public int updateProd(Product prod);
	public int deleteProd(int pidNo);
	public Product selectDept(int pidNo);
	public List<Product> getAll();

}
