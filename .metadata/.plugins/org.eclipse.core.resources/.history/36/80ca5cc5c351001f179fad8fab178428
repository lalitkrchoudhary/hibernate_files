package in.lalit.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.lalit.util.HibernateUtil;

public class InsurancePolicyDaoImpl implements InsurancePolicyDao {
	

	@Override
	public String transferPremiumPolicies(int maxTenure) {
		Session session=null;
		Transaction transaction = null;
		boolean flag = false;
		String msg = null;
		int count= 0;
		
		
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			Query query= session.getNamedQuery("HQL_INSERT_TRANSFER_POLICIES");
			
			query.setParameter("tenure", maxTenure);
		    count = query.executeUpdate();
		    
		    flag=true;
		    
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				msg="Number of record transfer is :: "+count;
			}else {
				transaction.rollback();
				msg="record not copied/inserted";
			}
			HibernateUtil.closeSession(session);
		}
		return msg;
	}

}
