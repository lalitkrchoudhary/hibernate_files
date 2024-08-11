package in.lalit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="eno")
	private Integer eno;
	
	@Column(length = 20, name = "ename")
	private String ename;
	
	
	@Column(length=40, name="eaddr")
	private String eaddr;
	
	@Column(name="esalary")
	private Integer esalary;

		
	public Integer getEno() {							
		return eno;
	}


	public void setEno(Integer eno) {
		this.eno = eno;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getEaddr() {
		return eaddr;
	}


	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}


	public Integer getEsalary() {
		return esalary;
	}


	public void setEsalary(Integer esalary) {
		this.esalary = esalary;
	}


	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", eaddr=" + eaddr + ", esalary=" + esalary + "]";
	}

	
	
	

	
	
	

}
