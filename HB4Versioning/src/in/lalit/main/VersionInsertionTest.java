package in.lalit.main;





import org.hibernate.Session;
import org.hibernate.Transaction;

import in.lalit.model.MobileCustomer;
import in.lalit.util.HibernateUtil;

public class VersionInsertionTest {
	
	public static void main(String[] args) {
		
	    Session session= null;
	    Transaction transaction = null;
	    Integer idValue= null;
	    boolean flag = false;
	    
		
		session =HibernateUtil.getSession();
		
		MobileCustomer mobileCustomer= new MobileCustomer();
		mobileCustomer.setCname("Sachin");
		mobileCustomer.setMobileNo(757891234);
		mobileCustomer.setCallerTune("KGF-2");
		
		try {
			transaction= session.beginTransaction();
			 
				idValue=(Integer) session.save(mobileCustomer);
				System.out.println("Generated is value is :: "+idValue);
				flag = true;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object is saved");
			}else{
				transaction.rollback();
				System.out.println("Object is not saved");
			}
			HibernateUtil.closeSession(session);
			
		}
		
		
	}

}
