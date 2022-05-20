package com.kosta.model;

import java.util.List;
import com.kosta.dto.EmpVO;



//사용자 요청 --> Controller --> Service --> DAO --> DB
// 		   <--			 <--		 <--     <--
public class EmpService
{
	EmpDAO emoDAO = new EmpDAO();
		//1. 모든직원조회
		public List<EmpVO> selectAll()
		{		
			return emoDAO.selectAll();
		}
		
		
		//2. 조건조회(특정부서)
		public List<EmpVO> selectByDept(int deptid)
		{		
			return emoDAO.selectByDept(deptid);
		}
		
		//3. 조건조회(특정메니저)
		public List<EmpVO> selectByManager(int mid)
		{		
			return emoDAO.selectByManager(mid);
		}
		
		//4. 조건조회(특정 job_id)
		public List<EmpVO> selectByJob(String job_id)
		{			
			return emoDAO.selectByJob(job_id);
		}
		
		//5. 조건조회(특정 department_id, jod_id, salary>=?, hire_date>=?)
		public List<EmpVO> selectByCondition(int deptid, String job_id, double sal, String hire_date)
		{			
			return emoDAO.selectByCondition(deptid, job_id, sal, hire_date);
		}

		//6. 특정직원 1건 조회(상세보기)
		public EmpVO selectById(int empid)
		{
			return emoDAO.selectById(empid);
		}
		
		//7. insert
		public int empInsert(EmpVO emp)
		{			
			return emoDAO.empInsert(emp);
		}
		
		//8. update(특정직원 1건 employee_id=?)
		public int empUpdate(EmpVO emp)
		{			
			return emoDAO.empUpdate(emp);
		}	
		
		//9. update(조건 department_id= ?	)
		public int empUpdateByDept(EmpVO emp, int deptid)
		{			
			return emoDAO.empUpdate(emp);
		}			
		
		//10. delete(특정직원 1건 employee_id=?)
		public int empDelete(int deptid)
		{
			return emoDAO.empDelete(deptid);
		}	

		//11. delete(조건 employee_id=?)
		public int empDeleteByDept(int deptid)
		{
			return emoDAO.empDeleteByDept(deptid);
		}

}
