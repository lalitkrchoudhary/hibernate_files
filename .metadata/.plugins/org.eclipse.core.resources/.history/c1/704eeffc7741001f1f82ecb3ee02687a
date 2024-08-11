package in.lalit.model;
import javax.persistence.Entity;


@Entity
@Table(name="empTab")
public class Employee {
	
	@Id
	@Column(name="eid")
	private Integer empId;
	
	@Column(name="ename")
	private String empName;
	
	@Column(name="esal")
	private Double empSal;
	
	
	
	static {
		System.out.println("Employee class is loading...");
	}
	
	public Employee(){
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
