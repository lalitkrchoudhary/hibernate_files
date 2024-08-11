package in.lalit.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.lalit.util.HibernateUtil;

public class InsurancePolicyDaoImpl implements InsurancePolicyDao {
	
	private static final String HQL_TRANSFER_QUERY="insert into in.lalit.model.PremiumInsurancePolicy(policyId,policyName,policyType,company,tenure) select  i.policyId, i.policyName, i.policyType, i.company, i.tenure from in.lalit.model.InsurancePolicy as i where i.tenure>=:tenure";                               

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
			
			Query query= session.createQuery(HQL_TRANSFER_QUERY);
			
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
