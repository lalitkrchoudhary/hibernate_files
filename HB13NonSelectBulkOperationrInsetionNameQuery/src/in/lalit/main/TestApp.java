package in.lalit.main;

import in.lalit.dao.InsurancePolicyDao;
import in.lalit.dao.InsurancePolicyDaoImpl;
import in.lalit.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InsurancePolicyDao dao= null;
		dao = new InsurancePolicyDaoImpl();
		String result=dao.transferPremiumPolicies(12);
		System.out.println(result);
		HibernateUtil.closeSessionFactory();
	}

}
