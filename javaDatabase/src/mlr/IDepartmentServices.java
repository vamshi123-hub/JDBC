package mlr;

import java.util.List;

public interface IDepartmentServices {
	
	public int addDept(Department dept);
	public int updateDept(Department dept);
	public Department selectDept(int deptNo);
	public int deleteDept(int deptNo);
	public List<Department> getAll();
}
