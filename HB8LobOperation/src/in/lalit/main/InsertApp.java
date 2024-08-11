package in.lalit.main;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.lalit.model.JobSeeker;
import in.lalit.util.HibernateUtil;



public class InsertApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		boolean flag=false;
		Integer idValue= null;
		byte[] imageContent= null;
		char[] resumeContent= null;
		
		
		// insert image process
		//using try with resource
		try(FileInputStream fis= new FileInputStream("csm22045.jpeg")) {
			imageContent= new byte[(int)fis.available()];
			fis.read(imageContent);
			
			File f = new File("sample3.txt");
			try(FileReader fr = new FileReader(f)) {
					resumeContent= new char[(int) f.length()];
					fr.read(resumeContent);
				
			} catch (IOException e) {
				e.printStackTrace();			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		 try {
			session =HibernateUtil.getSession();
			JobSeeker seeker = new JobSeeker();
			seeker.setJsName("Aman");
			seeker.setActive(true);
			seeker.setPhoto(imageContent);
			seeker.setResume(resumeContent);
			
			
			if(session!=null) {
				transaction=session.beginTransaction();
				
			}
			
			if(transaction!=null) {
				idValue =(Integer)session.save(seeker);
				System.out.println("Record with id value :: "+idValue);
				flag= true;
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			 if(flag==true) {
				 transaction.commit();
				 System.out.println("Object datta i ssaved");
			 }else {
				 transaction.rollback();
				 System.out.println("Object data is falied to saved");
			 }
			 
			 HibernateUtil.closeSession(session);
		 }
		
		
	
		 
	}
}
