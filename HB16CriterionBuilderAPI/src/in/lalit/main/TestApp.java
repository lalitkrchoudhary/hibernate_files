package in.lalit.main;



import java.io.Serializable;
import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
import org.hibernate.query.Query;

import in.lalit.model.Project;
import in.lalit.util.HibernateUtil;



public class TestApp {

	public static void main(String[] args) {
	
		Session session= HibernateUtil.getSession();
		
		
		
		
		try {
			
          //Create criteriaBuilder object
		CriteriaBuilder builder=session.getCriteriaBuilder();
		
		//Creating a criteriaQuery object
	    CriteriaQuery<Project> cQuery= builder.createQuery(Project.class);
	    
	    //Creating a root object to specify the entity class name
	    Root<Project> root= cQuery.from(Project.class);
	    
	    //adding the root object to Criteria Query object
	    cQuery.select(root);
	    
	    //Executing the JPA QBC logic
	    Query<Project> query= session.createQuery(cQuery);
	    
	    //processing the result
        List<Project> list =query.getResultList();
        list.forEach(System.out::println);
        
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
}
