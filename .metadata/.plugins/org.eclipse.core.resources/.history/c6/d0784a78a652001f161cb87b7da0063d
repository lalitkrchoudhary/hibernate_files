package in.lalit.main;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.lalit.model.InsurancePolicy;
import in.lalit.util.HibernateUtil;

public class LockingAppTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		boolean flag = false;
		
		try {
			transaction = session.beginTransaction();
			InsurancePolicy policy= session.get(InsurancePolicy.class, 3l,LockMode.UPGRADE_NOWAIT);
			System.out.println(policy);
			
			Thread.sleep(30000); //30 second (run LockingAppTest2.java now)
			
			policy.setTenure(2);
			flag=true;
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(flag){
				transaction.commit();
				System.out.println("Object Updated");
			}
			else {
				transaction.rollback();
				System.out.println("Object not updated");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
