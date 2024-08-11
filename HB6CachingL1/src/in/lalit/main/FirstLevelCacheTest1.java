package in.lalit.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.lalit.model.InsurancePolicy;
import in.lalit.util.HibernateUtil;

public class FirstLevelCacheTest1 {

	public static void main(String[] args) {
		Session session= null;
		Transaction transaction = null;
		boolean flag=false;
		
		session= HibernateUtil.getSession();
		InsurancePolicy policy = new InsurancePolicy();
		policy.setCompany("ICICI");
		policy.setPolicyName("NotLife");
		policy.setPolicyType("half");
		policy.setTenure(5);
		
		try {
			transaction= session.beginTransaction();
			
			session.save(policy);
			flag=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		finally {
			if (flag) {
			 transaction.commit();	
			 System.out.println("Object saved to database");
			}else {
				transaction.rollback();
				System.out.println("Object failed to save in database");
			}
			HibernateUtil.closeSession(session);
			
		}
		
	}

}
