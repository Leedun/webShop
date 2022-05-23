package com.kosta.model;

import java.util.List;
import java.util.Map;

import com.kosta.dto.EmpVO;
import com.kosta.dto.JobVO;



//����� ��û --> Controller --> Service --> DAO --> DB
// 		   <--			 <--		 <--     <--
public class EmpService
{
	EmpDAO emoDAO = new EmpDAO();
		//1. ���������ȸ
		public List<EmpVO> selectAll()
		{		
			return emoDAO.selectAll();
		}
		
		public List<JobVO> selectJobAll(){
			return emoDAO.selectJobAll();
		}
		
		public Map<Integer, String> selectMGAll(){
			return emoDAO.selectMGAll();
		}

	
		//2. ������ȸ(Ư���μ�)
		public List<EmpVO> selectByDept(int deptid)
		{		
			return emoDAO.selectByDept(deptid);
		}
		
		//3. ������ȸ(Ư���޴���)
		public List<EmpVO> selectByManager(int mid)
		{		
			return emoDAO.selectByManager(mid);
		}
		
		//4. ������ȸ(Ư�� job_id)
		public List<EmpVO> selectByJob(String job_id)
		{			
			return emoDAO.selectByJob(job_id);
		}
		
		//5. ������ȸ(Ư�� department_id, jod_id, salary>=?, hire_date>=?)
		public List<EmpVO> selectByCondition(int deptid, String job_id, double sal, String hire_date)
		{			
			return emoDAO.selectByCondition(deptid, job_id, sal, hire_date);
		}

		//6. Ư������ 1�� ��ȸ(�󼼺���)
		public EmpVO selectById(int empid)
		{
			return emoDAO.selectById(empid);
		}
		
		//7. insert
		public int empInsert(EmpVO emp)
		{			
			return emoDAO.empInsert(emp);
		}
		
		//8. update(Ư������ 1�� employee_id=?)
		public int empUpdate(EmpVO emp)
		{			
			return emoDAO.empUpdate(emp);
		}	
		
		//9. update(���� department_id= ?	)
		public int empUpdateByDept(EmpVO emp, int deptid)
		{			
			return emoDAO.empUpdate(emp);
		}			
		
		//10. delete(Ư������ 1�� employee_id=?)
		public int empDelete(int deptid)
		{
			return emoDAO.empDelete(deptid);
		}	

		//11. delete(���� employee_id=?)
		public int empDeleteByDept(int deptid)
		{
			return emoDAO.empDeleteByDept(deptid);
		}

}
