package in.lalit.main;



import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.lalit.model.Emloyee;



public class StandartApp {

	public static void main(String[] args) {
		
		
		Configuration cfg = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		 Transaction transaction= null;
		 Serializable idValue=null;
		 boolean flag=false;
		
		cfg= new Configuration();
		cfg.configure();
		System.out.println(cfg.getProperties());
		
		sessionFactory= cfg.buildSessionFactory();
		session= sessionFactory.openSession();
	
		Emloyee employee= new Emloyee();
		//employee.setEmpId(9);
		employee.setEmpName("kholi");
		employee.setEmpSal(3333.5);
		
		try {
			transaction= session.beginTransaction();
			idValue =(Integer) session.save(employee);
			System.out.println("Genterated idValue id:: "+idValue);
			flag=true;
			System.out.println("id value is :: "+employee.getEmpId());
		} catch (Exception e) {
		
		}
		finally {
			if(flag==true) {
				transaction.commit(); //till we say commit the entire object or data is store in L1cache
			}else {
				transaction.rollback();
			}
			
			session.close();
			sessionFactory.close();
		}
		
		
	
		
		
	
		 
	}
}
