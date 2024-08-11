package in.lalit.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	static Configuration cfg = null;
	static SessionFactory sessionFactory = null;
	static Session session = null;
	
	static {
		try {
			cfg= new Configuration();
			cfg.configure();
			System.out.println(cfg.getProperties());
			
			sessionFactory= cfg.buildSessionFactory();
			session= sessionFactory.openSession();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	
	public static Session getSession() {
		if(sessionFactory==null) {
			session= sessionFactory.openSession();
			
		}return session;
	}
	
	public static void closeSession(Session session) {
		if(session !=null) {
		 session.close();
			
		}
	}	
	
	public static void closeSessionFactory() {
		if(sessionFactory!=null) {
			 sessionFactory.close();
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
