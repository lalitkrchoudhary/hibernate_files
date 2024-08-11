package in.lalit.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.lalit.model.Account;
import in.lalit.model.Empolyee;
import in.lalit.util.HibernateUtil;

public class RetervingTestApp2 {
	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		boolean flag= false;
		
		try {
			session=HibernateUtil.getSession();
			Empolyee emp=session.get(Empolyee.class, 1);
			System.out.println(emp);
				
				
			
				
				
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
