package in.lalit.model;
import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="empTab")
public class Emloyee {
	
	@Id
	@Column(name="eid")
	//@GeneratedValue(strategy = GenerationType.IDENTITY) // to generate automatic primary value
	@GenericGenerator(name="gen1",strategy = "identity")
	@GeneratedValue(generator = "gen1")
	private Integer empId;
	
	@Column(name="ename" ,length=20)
	private String empName;
	
	@Column(name="esal")
	private Double empSal;
	
	
	
	static {
		System.out.println("Employee class is loading...");
	}
	
	public Emloyee(){
		System.out.println("Zero parameter constructor is used by the hibernate");
	}
	
	
	public Integer getEmpId() {
		return empId;
	}






	public void setEmpId(Integer empId) {
		this.empId = empId;
	}






	public String getEmpName() {
		return empName;
	}






	public void setEmpName(String empName) {
		this.empName = empName;
	}






	public Double getEmpSal() {
		return empSal;
	}






	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}






	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
	}
	
	

}
