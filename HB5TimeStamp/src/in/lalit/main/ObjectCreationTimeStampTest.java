package in.lalit.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.lalit.model.BankAccount;
import in.lalit.util.HibernateUtil;

public class ObjectCreationTimeStampTest {

	public static void main(String[] args) {
		 Session session= null;
		    Transaction transaction = null;
		    Long idValue= null;
		    boolean flag = false;
		    
			
			session =HibernateUtil.getSession();
			BankAccount bankAccount=new BankAccount();
			bankAccount.setHolderName("AMAR");
			bankAccount.setBalance(2000D);
			bankAccount.setType("CURRENT");
			
			
			
			try {
				transaction= session.beginTransaction();
				 idValue = (Long) session.save(bankAccount);
				 
				 System.out.println("The bank account created and account no is:: "+idValue);
					
					flag = true;
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				flag=false;
			}
			finally {
				if(flag) {
					transaction.commit();
					System.out.println("Object is saved");
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
