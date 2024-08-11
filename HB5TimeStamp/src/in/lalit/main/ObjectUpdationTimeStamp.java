package in.lalit.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.lalit.model.BankAccount;
import in.lalit.util.HibernateUtil;

public class ObjectUpdationTimeStamp {

	public static void main(String[] args) {
		 Session session= null;
		    Transaction transaction = null;
		    BankAccount bankAccount= null;
		    Long idValue= null;
		    boolean flag = false;
		    
			
			session =HibernateUtil.getSession();
			
			
			
			try {
				transaction= session.beginTransaction();
				
				bankAccount=session.get(BankAccount.class, 1l);
				if(bankAccount != null) {
					bankAccount.setBalance(bankAccount.getBalance()+500);
					flag=true;
				}else {
					System.out.println("Record is not availale for update");
					System.exit(0);
				}
				
				
					
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				flag=false;
			}
			finally {
				if(flag) {
					transaction.commit();
					System.out.println("Object is updated");
					System.out.println("Account is opened at :: "+bankAccount.getOpeningDate());
					System.out.println("Account is udated at :: "+ bankAccount.getLastUpdated());
					System.out.println("Account version is :: "+bankAccount.getVersion());
				}else{
					transaction.rollback();
					System.out.println("Object is not saved");
				}
				HibernateUtil.closeSession(session);
				
			}
			
	}
}
