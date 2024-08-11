package in.lalit.main;

import org.hibernate.Session;

import in.lalit.model.InsurancePolicy;
import in.lalit.util.HibernateUtil;

public class SecondLevelCacheTestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session=null;
		InsurancePolicy policy = null;
		
		session = HibernateUtil.getSession();
		
		try {
			policy =session.get(InsurancePolicy.class, 1l); //get from DB keep in L1 and L2 cache
			System.out.println("1:: "+policy);
			
			policy =session.get(InsurancePolicy.class, 1l);//get from L1 cache
			System.out.println("2:: "+policy);
			
			session.evict(policy); // remove from L1 cache
			
			policy =session.get(InsurancePolicy.class, 1l);//get from L2 cache and keep it in L1 cache
			System.out.println("3:: "+policy);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
