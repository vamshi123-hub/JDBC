package mlr;

import java.util.List;

public class DepartmentServicesImp implements IDepartmentServices {
	
	private DepartmentDAO dao = new DepartmentDAO();
	@Override
	public int addDept(Department dept) {
		// TODO Auto-generated method stub
		return dao.addDept(dept);
	}
	@Override
	public int deleteDept(int deptNo) {
		// TODO Auto-generated method stub
		return dao.deleteDept(deptNo);
	}@Override
	public List<Department> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}@Override
	public Department selectDept(int deptNo) {
		// TODO Auto-generated method stub
		return dao.selectDept(deptNo);
	}@Override
	public int updateDept(Department dept) {
		// TODO Auto-generated method stub
		return dao.updateDept(dept);
	}
	
	public static boolean  dateValidation(Department dept){
		
		boolean flag = false;
		if(dept.getDno() > 10 && dept.getDname().length()>=4 
				&& dept.getLocation().equals(dept.getLocation().toUpperCase())) {
			flag = true;
			
		}
		
		return flag;
	}
}
