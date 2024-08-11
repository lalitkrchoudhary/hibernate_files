package in.lalit.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.lalit.model.MobileCustomer;
import in.lalit.util.HibernateUtil;

public class VersionModify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    Session session= null;
	    Transaction transaction = null;
	    Integer idValue= null;
	    boolean flag = false;
	    MobileCustomer mobileCustomer= null;
	    
		
		session =HibernateUtil.getSession();
		
		
		try {
			transaction= session.beginTransaction();
			mobileCustomer=session.get(MobileCustomer.class, 1);
			if(mobileCustomer!=null) {
				System.out.println(mobileCustomer);
				mobileCustomer.setCallerTune("Kantara");
				flag =true;
			}else {
				System.out.println("record is not available");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		finally {
			
			if(flag) {
				transaction.commit();
				System.out.println("Object is modified");
				System.out.println("The version count after modified :: "+mobileCustomer.getVersionCount());
			}else{
				transaction.rollback();
				System.out.println("Object is not modified");
			}
			HibernateUtil.closeSession(session);
			
		}
		

	}

}
