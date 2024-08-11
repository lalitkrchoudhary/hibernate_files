package in.lalit.main;

import java.util.List;

import in.lalit.dao.InsurancePolicyDao;
import in.lalit.dao.InsurancePolicyDaoImpl;
import in.lalit.model.InsurancePolicy;
import in.lalit.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsurancePolicyDao dao= null;
		dao = new InsurancePolicyDaoImpl();
		List<InsurancePolicy> list = dao.getPolicyByTenure(2, 4);
		list.forEach(System.out::println);
		HibernateUtil.closeSessionFactory(); 

	}

}
