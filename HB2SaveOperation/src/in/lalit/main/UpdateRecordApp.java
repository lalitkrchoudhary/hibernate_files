package in.lalit.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.lalit.model.Emloyee;
import in.lalit.util.HibernateUtil;

public class UpdateRecordApp {

	public static void main(String args[]) {
		
		Session session= HibernateUtil.getSession();
		Emloyee employee = null; 
		Boolean flag=false;
		Transaction transaction = null; 
		
		//updating the total object using the id
		 employee = new Emloyee();
		 employee.setEmpId(4);
		 employee.setEmpName("lal");
		 employee.setEmpSal(200.10);
		
		try {
			transaction=session.beginTransaction();
			session.update(employee);
			flag=true;
		    
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block\
			flag=false;
			e.printStackTrace();
		}
		finally {
			if(flag==true) {
				transaction.commit();
				System.out.println("Object has been updated");
			}else {
				transaction.rollback();
			System.out.println("Object not updated");
			}
		}
	}
}
