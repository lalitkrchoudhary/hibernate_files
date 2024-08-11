package in.lalit.main;



import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.lalit.model.PersonInfo;
import in.lalit.util.HibernateUtil;



public class StandartApp {

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
				PersonInfo person = new PersonInfo();
				person.setPname("Java");
				person.setPaddress("Oracle based");
				person.setDob(LocalDate.of(1997, 12, 9));
				person.setDom(LocalDateTime.of(1999, 11, 8, 12, 3));
				person.setDoj(LocalTime.of(1, 30));
				
				session.save(person);
				flag= true;
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			 if(flag==true) {
				 transaction.commit();
				 System.out.println("Object save to database...");
			 }else {
				 transaction.rollback();
				 System.out.println("OBject not save to database..");
			 }
			 
			 HibernateUtil.closeSession(session);
		 }
		
		
	
		 
	}
}
