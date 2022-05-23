package com.kosta.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
//import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.kosta.dto.EmpVO;
import com.kosta.dto.JobVO;
import com.kosta.util.DBUtill;

//CRUD�۾� (insert(C), select(R), update(U), Delete(D)  ==> DAO(Data Access Object)
public class EmpDAO
{
	static final String SQL_SELECT_ALL = "select * from employees order by 1";
	static final String SQL_SELECT_BYDEPT = "select * from employees where department_id = ? order by 1"; // ? ���ε� ����
																											// (��������)
	static final String SQL_SELECT_BYMANAGER = "select * from employees where MANAGER_ID = ? order by 1"; // ? ���ε� ����
																											// (��������)
	static final String SQL_SELECT_JOB = "select * from employees where job_id = ? order by 1"; // ? ���ε� ���� (��������)
	static final String SQL_SELECT_CONDITION = "select * from employees " + "where DEPARTMENT_ID = ? " + "and JOB_ID=? "
			+ "and SALARY>=? " + "and HIRE_DATE>=? " + "order by 1";
	static final String SQL_SELECT_ByID = "select * from employees where EMPLOYEE_ID = ?";
	static final String SQL_INSERT = "insert into employees values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	static final String SQL_UPDATE = "UPDATE EMPLOYEES SET\r\n" + "FIRST_NAME=?,\r\n" + "LAST_NAME =?,\r\n"
			+ "EMAIL  =?,\r\n" + "PHONE_NUMBER  =?,\r\n" + "HIRE_DATE  =?,\r\n" + "JOB_ID  =?,\r\n" + "SALARY  =?,\r\n"
			+ "COMMISSION_PCT  =?,\r\n" + "MANAGER_ID  =decode(?,0,null,?),\r\n" + "DEPARTMENT_ID  =?\r\n" + "WHERE EMPLOYEE_ID  =?";

	static final String SQL_UPDATE_BYDEPT= "UPDATE EMPLOYEES SET\r\n"
	 		+ "SALARY  =?,\r\n"
	 		+ "COMMISSION_PCT  =?\r\n"
	 		+ "WHERE EMPLOYEE_ID  =?";
	static final String SQL_DELETE= "DELETE FROM EMPLOYEES\r\n"
			+ "WHERE EMPLOYEE_ID = ?";
	
	static final String SQL_DELETE_BYDEPT= "DELETE FROM EMPLOYEES\r\n"
			+ "WHERE DEPARTMENT_ID = ?";	
	
	
	static final String SQL_SELECT_MANAGERALL="SELECT EMPLOYEE_ID, FIRST_NAME\r\n"
			+ "FROM EMPLOYEES\r\n"
			+ "WHERE EMPLOYEE_ID  IN (SELECT DISTINCT MANAGER_ID FROM EMPLOYEES)";

	Connection conn;
	Statement st;
	PreparedStatement pst; // ���ε� ���� ���� (?)
	ResultSet rs;
	int result;

	// 1. ���������ȸ
	public List<EmpVO> selectAll()
	{
		List<EmpVO> emplist = new ArrayList<EmpVO>();
		conn = DBUtill.getConnection();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery(SQL_SELECT_ALL);

			while (rs.next())
			{
				emplist.add(makeEmp(rs));
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, st, conn);
		}

		return emplist;
	}
	
	//모든 메니저 조회
	public Map<Integer, String> selectMGAll()
	{
		
		Map<Integer, String> mgMap = new HashMap<Integer, String>();		
		
		conn = DBUtill.getConnection();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery(SQL_SELECT_MANAGERALL);
			
			while (rs.next())
			{
				mgMap.put(rs.getInt(1), rs.getString(2));
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, st, conn);
		}
		
		return mgMap;
	}
	
	//모든 jobs 조회
	public List<JobVO> selectJobAll()
	{
		List<JobVO> joblist = new ArrayList<JobVO>();
		conn = DBUtill.getConnection();
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery("select * from jobs order by 1");
			
			while (rs.next())
			{
				JobVO job = new JobVO(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4));
				joblist.add(job);
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, st, conn);
		}
		
		return joblist;
	}

	private EmpVO makeEmp(ResultSet rs) throws SQLException
	{
		EmpVO emp = new EmpVO();
		emp.setCommission_pct(rs.getDouble("COMMISSION_PCT"));
		emp.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
		emp.setEmail(rs.getString("EMAIL"));
		emp.setEmployee_id(rs.getInt("EMPLOYEE_ID"));
		emp.setFirst_name(rs.getString("FIRST_NAME"));
		emp.setHire_date(rs.getDate("HIRE_DATE"));
		emp.setJob_id(rs.getString("JOB_ID"));
		emp.setLast_name(rs.getString("LAST_NAME"));
		emp.setManager_id(rs.getInt("MANAGER_ID"));
		emp.setPhone_number(rs.getString("PHONE_NUMBER"));
		emp.setSalary(rs.getDouble("SALARY"));

		return emp;
	}

	// 2. ������ȸ(Ư���μ�)
	public List<EmpVO> selectByDept(int deptid)
	{
		List<EmpVO> emplist = new ArrayList<EmpVO>();
		conn = DBUtill.getConnection();
		try
		{
//			st = conn.createStatement();
//			rs = st.executeQuery(SQL_SELECT_ALL);

			pst = conn.prepareStatement(SQL_SELECT_BYDEPT);
			pst.setInt(1, deptid); // ù��° ?(1) �� �μ���ȣ(deptid)�� �ִ´�.
			rs = pst.executeQuery();

			while (rs.next())
			{
				emplist.add(makeEmp(rs));
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, pst, conn);
		}

		return emplist;
	}

	// 3. ������ȸ(Ư���޴���)
	public List<EmpVO> selectByManager(int mid)
	{
		List<EmpVO> emplist = new ArrayList<EmpVO>();
		conn = DBUtill.getConnection();
		try
		{

			pst = conn.prepareStatement(SQL_SELECT_BYMANAGER);
			pst.setInt(1, mid); // ù��° ?(1) �� �μ���ȣ(deptid)�� �ִ´�.
			rs = pst.executeQuery();

			while (rs.next())
			{
				emplist.add(makeEmp(rs));
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, pst, conn);
		}

		return emplist;
	}

	// 4. ������ȸ(Ư�� job_id)
	public List<EmpVO> selectByJob(String job_id)
	{
		List<EmpVO> emplist = new ArrayList<EmpVO>();
		conn = DBUtill.getConnection();
		try
		{

			pst = conn.prepareStatement(SQL_SELECT_JOB);
			pst.setString(1, job_id); // ù��° ?(1) �� �ִ´�.
			rs = pst.executeQuery();

			while (rs.next())
			{
				emplist.add(makeEmp(rs));
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, pst, conn);
		}

		return emplist;
	}

	// 5. ������ȸ(Ư�� department_id, jod_id, salary>=?, hire_date>=?)
	public List<EmpVO> selectByCondition(int deptid, String job_id, double sal, String hire_date)
	{

		List<EmpVO> emplist = new ArrayList<EmpVO>();
		conn = DBUtill.getConnection();
		try
		{

			pst = conn.prepareStatement(SQL_SELECT_CONDITION);
			pst.setInt(1, deptid); // ù��° ? deptid �ִ´�.
			pst.setString(2, job_id); // �ι�° ? job_id �ִ´�.
			pst.setDouble(3, sal); // ����° ? sal �ִ´�.
			pst.setString(4, hire_date); // �׹�° ? hire_date �ִ´�.

			rs = pst.executeQuery();

			while (rs.next())
			{
				emplist.add(makeEmp(rs));
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, pst, conn);
		}

		return emplist;
	}

	// 6. Ư������ 1�� ��ȸ(�󼼺���)
	public EmpVO selectById(int empid)
	{
		EmpVO emp = null;
		conn = DBUtill.getConnection();
		try
		{

			pst = conn.prepareStatement(SQL_SELECT_ByID);
			pst.setInt(1, empid); // ù��° ? empid �ִ´�..

			rs = pst.executeQuery();

			while (rs.next())
			{
				emp = makeEmp(rs);
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, pst, conn);
		}

		return emp;
	}

	// 7. insert
	public int empInsert(EmpVO emp)
	{
		int result = 0;

		// SQL_INSERT
		conn = DBUtill.getConnection();
		try
		{
			pst = conn.prepareStatement(SQL_INSERT);
			pst.setInt(1, emp.getEmployee_id());
			pst.setString(2, emp.getFirst_name());
			pst.setString(3, emp.getLast_name());
			pst.setString(4, emp.getEmail());
			pst.setString(5, emp.getPhone_number());
			pst.setDate(6, emp.getHire_date());
			pst.setString(7, emp.getJob_id());
			pst.setDouble(8, emp.getSalary());
			pst.setDouble(9, emp.getCommission_pct());
			pst.setInt(10, emp.getManager_id());
			pst.setInt(11, emp.getDepartment_id());
					
			result = pst.executeUpdate();

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, pst, conn);
		}

		return result;
	}

	// 8. update(Ư������ 1�� employee_id=?)
	public int empUpdate(EmpVO emp)
	{
		int result = 0;

		conn = DBUtill.getConnection();
		try
		{
			pst = conn.prepareStatement(SQL_UPDATE);
			
			pst.setInt(12, emp.getEmployee_id());
			pst.setString(1, emp.getFirst_name());
			pst.setString(2, emp.getLast_name());
			pst.setString(3, emp.getEmail());
			pst.setString(4, emp.getPhone_number());
			pst.setDate(5, emp.getHire_date());
			pst.setString(6, emp.getJob_id());
			pst.setDouble(7, emp.getSalary());
			pst.setDouble(8, emp.getCommission_pct());
			pst.setInt(9, emp.getManager_id());
			pst.setInt(10, emp.getManager_id());
			pst.setInt(11, emp.getDepartment_id());
			result = pst.executeUpdate();

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, pst, conn);
		}

		return result;
	}

	// 9. update(���� department_id= ? )
	public int empUpdateByDept(EmpVO emp, int deptid)
	{
		int result = 0;

		conn = DBUtill.getConnection();
		try
		{
			pst = conn.prepareStatement(SQL_UPDATE_BYDEPT);
		
			pst.setDouble(1, emp.getSalary());
			pst.setDouble(2, emp.getCommission_pct());
			pst.setInt(3, emp.getDepartment_id());
			result = pst.executeUpdate();

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, pst, conn);
		}

		return result;
	}

	// 10. delete(Ư������ 1�� employee_id=?)
	public int empDelete(int empid)
	{
		int result = 0;

		conn = DBUtill.getConnection();
		try
		{
			pst = conn.prepareStatement(SQL_DELETE);
			pst.setInt(1, empid);
			result = pst.executeUpdate();

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, pst, conn);
		}

		return result;
	}

	// 11. delete(���� employee_id=?)
	public int empDeleteByDept(int deptid)
	{
		int result = 0;

		conn = DBUtill.getConnection();
		try
		{
			pst = conn.prepareStatement(SQL_DELETE_BYDEPT);
			pst.setInt(1, deptid);
			result = pst.executeUpdate();

		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			DBUtill.dbClose(rs, pst, conn);
		}

		return result;
	}

}