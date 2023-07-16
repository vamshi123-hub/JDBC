package com.connjdbc;

import java.util.List;


public class ProductServicesImp implements IProductServices {
	
	private ProductDao dao = new ProductDao();

	@Override
	public int addProd(Product prod) {
		// TODO Auto-generated method stub
		return dao.addProd(prod);
	}

	@Override
	public int updateProd(Product prod) {
		// TODO Auto-generated method stub
		return dao.updateProd(prod);
	}

	@Override
	public int deleteProd(int pidNo) {
		// TODO Auto-generated method stub
		return dao.deleteProd(pidNo);
	}

	@Override
	public Product selectDept(int pidNo) {
		// TODO Auto-generated method stub
		return dao.selectDept(pidNo);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}
	public static boolean dataInputValidation(Product prod) {
		boolean flag = false;
		if(prod.getPid() >10 && prod.getPname().length()>=2 
				&& prod.getPrice() > 1 && prod.getDom()!=null) {
			flag = true;
			
		}
		return flag;
	}

}
