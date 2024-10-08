package in.lalit.main;



import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.lalit.model.Emloyee;
import in.lalit.util.HibernateUtil;



public class DemoApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		boolean flag=false;
		
		
		 try {
			session =HibernateUtil.getSession();
			
			if(session!=null) {
				transaction=session.beginTransaction();
			}
			
			if(transaction!=null) {
				Emloyee employee= new Emloyee();
				employee.setEmpId(3);
				employee.setEmpName("Bikash");
				employee.setEmpSal(20.5);
				
				session.save(employee);
				flag= true;
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			 if(flag==true) {
				 transaction.commit();
			 }else {
				 transaction.rollback();
			 }
			 
			 HibernateUtil.closeSession(session);
		 }
		
		
	
		 
	}
}
