package in.lalit.main;



import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.lalit.model.Emloyee;



public class TestApp {

	public static void main(String[] args) {
	
		//Step 1. Creating a configuration object
		Configuration cfg= new Configuration();
		
		//Step 2. configure hibernate.cfg.xml file to Configuration object
		cfg.configure();
		
		//Step 3. Create SessionFactory Object
		SessionFactory sessionFactory= cfg.buildSessionFactory();
		
		//Step 4. Get the Session object from the SessionFactory
		Session session= sessionFactory.openSession();
		
		//Step 5. Begin the transaction within a session
		 Transaction transaction= session.beginTransaction();
		 
		Emloyee employee= new Emloyee();
		employee.setEmpId(10);
		employee.setEmpName("lalit");
		employee.setEmpSal(2000.5);
		
		//Step 6. Perform object
		Serializable object = session.save(employee);
		System.out.println(object);
		
		//Step 7. Performing transaction operation
		transaction.commit();
		
		//Step 8. Close the session
		session.close();
		 
	}
}
