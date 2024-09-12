package in.ineuron.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class Employee {
	private Integer eno;
	private String ename="sachin";
	private String edesg;
	private Double salary;
	
	public Employee() {
		System.out.println("Employee.Employee()");
	}
}
