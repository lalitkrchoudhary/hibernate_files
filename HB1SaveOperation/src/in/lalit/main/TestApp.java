package in.lalit.main;

import org.hibernate.cfg.Configuration;

import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.SessionFactory;

import in.lalit.model.Employee;

public class TestApp {
	
	public static void main(String[] args) {
		// Step 1. Create a configuration object
		Configuration cfg=new Configuration();
		
		//Step 2. configure hibernate.cfg.xml file to Configuration object
		cfg.configure();
		
		//Step 3. create SessionFactory object
		SessionFactory sessionFactory= cfg.buildSessionFactory();
		
		//Step 4. Get session object from SessionFactory
		Session session= sessionFactory.openSession();
		
		//Step 5. Begin the Transaction within a session
		Transaction transaction=session.beginTransaction();
		
		Employee employee = new Employee();
		employee.setEmpId(10);
		employee.setEmpName("lalit");
		employee.setEmpSal(20000.50);
		
	   //Step 6. Perform operations
		session.save(employee);
		
		//Step 7. Perform transaction operation
		transaction.commit();
		
		//Step 8. Close the session
		session.close();
	}

}
