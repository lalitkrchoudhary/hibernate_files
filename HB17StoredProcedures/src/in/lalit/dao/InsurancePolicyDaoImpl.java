package in.lalit.dao;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.Query;

import in.lalit.model.InsurancePolicy;
import in.lalit.util.HibernateUtil;

public class InsurancePolicyDaoImpl implements InsurancePolicyDao {

	@Override
	public List<InsurancePolicy> getPolicyByTenure(int start, int end) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSession();
		ProcedureCall procedureCall = session.createStoredProcedureCall("GET_POLICIES_BY_TENURE",InsurancePolicy.class);
		
		procedureCall.registerParameter(1, Integer.class, ParameterMode.IN).bindValue(start);
		procedureCall.registerParameter(2, Integer.class, ParameterMode.IN).bindValue(end);
		
		List<InsurancePolicy> list = procedureCall.getResultList();
		

		return list;
	}
	

	

}
