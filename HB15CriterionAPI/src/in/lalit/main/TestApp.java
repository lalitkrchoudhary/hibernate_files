package in.lalit.main;



import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;

import in.lalit.model.Project;
import in.lalit.util.HibernateUtil;



public class TestApp {

	public static void main(String[] args) {
	
		Session session= HibernateUtil.getSession();
		
		
		/*
		try {
			Criteria criteria =session.createCriteria(Project.class);
			List<Project> list= criteria.list();
			list.forEach(System.out::println);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		try {
			Criteria criteria =session.createCriteria(Project.class);

           Criterion cond1= Restrictions.ge("teamSize", 10);
           Criterion cond2= Restrictions.le("teamSize", 20);
           criteria.add(cond1);
           criteria.add(cond2);
           
          Order order1= Order.asc("location");
          Order order2= Order.desc("projName");
          criteria.addOrder(order1);
          criteria.addOrder(order2);
          
          
          List<Project> list= criteria.list();
           
			list.forEach(System.out::println);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
}
