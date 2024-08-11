package in.lalit.main;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.lalit.util.HibernateUtil;

public class DeleteRecordApp2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		int count = 0;
		
		try {
			session=HibernateUtil.getSession();
			transaction=session.beginTransaction();
			
			Query  query= session.createQuery("DELETE FROM in.lalit.model.Employee where eno<=:id");
			
			
			query.setParameter("id", 4);
	
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
				System.out.println("Number of records deleted is :: "+count);
			}else {
				transaction.rollback();
				System.out.println("Result not found");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
