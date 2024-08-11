package in.lalit.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.lalit.model.Account;
import in.lalit.model.Empolyee;
import in.lalit.util.HibernateUtil;

public class TestApp {
	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		boolean flag= false;
		
		try {
			session=HibernateUtil.getSession();
			
				transaction= session.beginTransaction();
				
				Account account = new Account();
				account.setAccNo("IN101");
				account.setAccName("Lalit");
				account.setAccType("saving");
				
				Empolyee emp = new Empolyee();
				emp.setAccount(account);
				emp.setEname("lalit");
				emp.setEaddress("Assam");
				emp.setEsal(20000.0f);
				
				session.save(emp);
				
				flag = true;
				
				
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			if(flag) {
				transaction.commit();
				System.out.println("Object is saveed");
				
			}else {
				System.out.println("Object is not saved");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}
