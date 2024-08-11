package in.lalit.main;

import org.hibernate.Session;

import in.lalit.model.Emloyee;
import in.lalit.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String args[]) {
		
		Session session= HibernateUtil.getSession();
		Emloyee employee = null;
		
		int id=3;
		try {
			if(session !=null) {
				 employee =session.load(Emloyee.class, id);
				System.out.println(employee);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block\
			System.out.println(employee);
			System.out.println("Employee record is not found for the given id:: "+id);
		}
	}
}
