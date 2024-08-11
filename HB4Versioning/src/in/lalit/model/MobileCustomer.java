package in.lalit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class MobileCustomer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cno;
	
	@Column(length = 20)
	private String cname;
	private long mobileNo;
	
	@Column(length=40)
	private String callerTune;
	
	@Version // it keep tract how many time the object is loaded and modified using hibernate
	private Integer versionCount;

	
	
	
	
	public Integer getCno() {
		return cno;
	}





	public void setCno(Integer cno) {
		this.cno = cno;
	}





	public String getCname() {
		return cname;
	}





	public void setCname(String cname) {
		this.cname = cname;
	}





	public long getMobileNo() {
		return mobileNo;
	}





	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}





	public String getCallerTune() {
		return callerTune;
	}





	public void setCallerTune(String callerTune) {
		this.callerTune = callerTune;
	}





	public Integer getVersionCount() {
		return versionCount;
	}





	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}





	@Override
	public String toString() {
		return "MobileCustomer [cno=" + cno + ", cname=" + cname + ", mobileNo=" + mobileNo + ", callerTune="
				+ callerTune + ", versionCount=" + versionCount + "]";
	}
	
	
	

}
