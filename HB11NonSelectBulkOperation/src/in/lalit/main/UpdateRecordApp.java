package in.lalit.main;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.lalit.util.HibernateUtil;

public class UpdateRecordApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		int count = 0;
		
		try {
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			
			Query  query= session.createQuery("UPDATE in.lalit.model.Employee SET esalary = esalary+:increment WHERE eno>=:id ");
			
			query.setParameter("increment", 1500);
			query.setParameter("id", 3);
			count =query.executeUpdate();
			flag =true;
			
		} catch (Exception e) {
			// TODO: handle exception 
			flag=false;
			e.printStackTrace();
			
		}
		finally {
			if(flag== true) {
				transaction.commit();
				System.out.println("Number of records update is :: "+count);
			}else {
				transaction.rollback();
				System.out.println("Result not found");
			}
		}

	}

}
