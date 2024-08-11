package in.lalit.main;



import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import in.lalit.model.InsurancePolicy;
import in.lalit.util.HibernateUtil;



public class TestApp {

	public static void main(String[] args) {
	
		Session session= HibernateUtil.getSession();
		
		NativeQuery<Object[]> query = session.getNamedNativeQuery("GET_ALL_POLICY_TYPE");
		query.setParameter("type", "half");
		List<Object[]> list = query.getResultList();
		list.forEach(row->{
			for(Object obj: row) {
				System.out.print(obj+" ");
			}
			System.out.println();
		});
		
		System.out.println("Fetching all the data");
		NativeQuery<InsurancePolicy> query2=session.getNamedNativeQuery("GET_ALL_POLICY");
		List<InsurancePolicy> list2= query2.getResultList();
		list2.forEach(System.out::println);
		 
	}
}
