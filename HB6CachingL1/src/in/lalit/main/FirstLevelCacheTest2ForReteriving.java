package in.lalit.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;

import in.lalit.model.InsurancePolicy;
import in.lalit.util.HibernateUtil;

public class FirstLevelCacheTest2ForReteriving {

	public static void main(String[] args) {
		Session session= null;
		Transaction transaction = null;
		boolean flag=false;
		InsurancePolicy policy=null;
		
		session= HibernateUtil.getSession();
		
		
		try {
			
			
			policy =session.get(InsurancePolicy.class, 1l );
			if(policy==null) {
				System.out.println("Record not found");
			}else {
				System.out.println("Record found and displayed");
				System.out.println(policy);
				
				transaction=session.beginTransaction();
				policy.setTenure(31);
				session.update(policy);
				System.out.println(policy);

				
				policy.setTenure(29);
				session.update(policy);
				System.out.println(policy);
				flag=true;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			flag=false;
		}
		finally {
			if (flag) {
				transaction.commit();
			System.out.println("Object get update with the latest value");
			} else {
                transaction.rollback();
                System.out.println("Object not get update");
			}
			
		}
		
	}

}
