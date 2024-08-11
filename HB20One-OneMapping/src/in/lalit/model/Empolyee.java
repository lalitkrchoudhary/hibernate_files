package in.lalit.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Empolyee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;
	private String ename;
	private float esal;
	private String eaddress;
	
	@OneToOne(cascade = CascadeType.ALL) // cascade means if we delete employee then account is automatically deleted
	private Account account;
	
	

	public Integer getEid() {
		return eid;
	}



	public void setEid(Integer eid) {
		this.eid = eid;
	}



	public String getEname() {
		return ename;
	}



	public void setEname(String ename) {
		this.ename = ename;
	}



	public float getEsal() {
		return esal;
	}



	public void setEsal(float esal) {
		this.esal = esal;
	}



	public String getEaddress() {
		return eaddress;
	}



	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}



	public Account getAccount() {
		return account;
	}



	public void setAccount(Account account) {
		this.account = account;
	}



	@Override
	public String toString() {
		return "Empolyee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + ", eaddress=" + eaddress + ", account="
				+ account + "]";
	}



	
}
