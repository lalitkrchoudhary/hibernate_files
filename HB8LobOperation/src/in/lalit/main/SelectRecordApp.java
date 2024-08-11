ackage in.lalit.main;

import java.io.FileOutputStream;
import java.io.FileWriter;

import org.hibernate.Session;

import in.lalit.model.JobSeeker;
import in.lalit.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) {
		
		Session session= HibernateUtil.getSession();
		JobSeeker seeker =null;
		FileOutputStream fos = null;
		FileWriter out = null;
		
		
		int id=2;
		try {
			if(session !=null) {
				seeker=session.get(JobSeeker.class, id);
				if(seeker!=null) {
					fos = new FileOutputStream("store/photo.jpeg");
					fos.write(seeker.getPhoto());
					
					out = new FileWriter("store/resume.txt");
					out.write(seeker.getResume());
					
					fos.flush();
					out.flush();
					System.out.println("LOB has reterived");
					System.out.println(seeker);
				}
				
			}else {
				System.out.println("OBject is not found");
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
