package com.aap.demo.model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class Emp {



	@Id
    @Column(name = "EMPNO")
    Long empNo;
	
    @Column(name = "ENAME")
    String eName;
    
    @Column(name = "JOB")
    String job;
    
    @Column(name = "MGR")
    Long mgr;
    
    @Column(name = "HIREDATE")
    Date hireDate;
    
    @Column(name = "SAL")
    Long sal;
    
    @Column(name = "COMM")
    Long comm;
    
    @Column(name = "DEPTNO")
    Long deptNo;

    public Long getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Long empNo) {
		this.empNo = empNo;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Long getMgr() {
		return mgr;
	}

	public void setMgr(Long mgr) {
		this.mgr = mgr;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Long getSal() {
		return sal;
	}

	public void setSal(Long sal) {
		this.sal = sal;
	}

	public Long getComm() {
		return comm;
	}

	public void setComm(Long comm) {
		this.comm = comm;
	}

	public Long getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Long deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", eName=" + eName + ", job=" + job + ", mgr=" + mgr + ", hireDate=" + hireDate
				+ ", sal=" + sal + ", comm=" + comm + ", deptNo=" + deptNo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comm == null) ? 0 : comm.hashCode());
		result = prime * result + ((deptNo == null) ? 0 : deptNo.hashCode());
		result = prime * result + ((eName == null) ? 0 : eName.hashCode());
		result = prime * result + ((empNo == null) ? 0 : empNo.hashCode());
		result = prime * result + ((hireDate == null) ? 0 : hireDate.hashCode());
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((mgr == null) ? 0 : mgr.hashCode());
		result = prime * result + ((sal == null) ? 0 : sal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (comm == null) {
			if (other.comm != null)
				return false;
		} else if (!comm.equals(other.comm))
			return false;
		if (deptNo == null) {
			if (other.deptNo != null)
				return false;
		} else if (!deptNo.equals(other.deptNo))
			return false;
		if (eName == null) {
			if (other.eName != null)
				return false;
		} else if (!eName.equals(other.eName))
			return false;
		if (empNo == null) {
			if (other.empNo != null)
				return false;
		} else if (!empNo.equals(other.empNo))
			return false;
		if (hireDate == null) {
			if (other.hireDate != null)
				return false;
		} else if (!hireDate.equals(other.hireDate))
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (mgr == null) {
			if (other.mgr != null)
				return false;
		} else if (!mgr.equals(other.mgr))
			return false;
		if (sal == null) {
			if (other.sal != null)
				return false;
		} else if (!sal.equals(other.sal))
			return false;
		return true;
	}
	
	
	

    //getters and setters, contructors
}