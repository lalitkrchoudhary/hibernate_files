package in.lalit.main;

import java.util.Iterator;
import java.util.List;


import org.hibernate.Session;
import org.hibernate.query.Query;

import in.lalit.model.Employee;
import in.lalit.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session= HibernateUtil.getSession();
		
		/*
		 * //First method try { Query<Employee> query=
		 * session.createQuery("FROM in.lalit.model.Employee"); List<Employee> employees
		 * = query.list();
		 * 
		 * employees.forEach(employee -> System.out.println(employee));
		 * 
		 * } catch (Exception e) { // TODO: handle exception\ e.printStackTrace(); }
		 * finally { HibernateUtil.closeSession(session);
		 * HibernateUtil.closeSessionFactory(); }
		 */
		
		//Second Method
		 Query<Employee> query=session.createQuery("FROM in.lalit.model.Employee WHERE eno>=:id1 AND eno<=:id2");

		 query.setParameter("id1",2);
		 query.setParameter("id2",4);
		 
		 List<Employee> emp= query.getResultList();
		// emp.forEach(e -> System.out.println(e)); we can also write
		 emp.forEach(System.out::println);
		
//		//using iterator
//		Query<Employee> query = session.createQuery("FROM in.lalit.model.Employee");
//		Iterator<Employee> itr = query.iterate();
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
		 
	}

}
