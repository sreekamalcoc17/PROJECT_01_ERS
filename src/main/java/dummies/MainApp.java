package dummies;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

//import com.revature.pojo.Address;
import com.revature.pojo.Employee;
import com.revature.pojo.Manager;
import com.revature.utils.HibernateUtil;


public class MainApp {
	

	public static void main(String[] args) {
		
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
       // Address ad = new Address(123,"nellore","AP","india",524002);
        Manager s = new Manager("sree","kamal","sk123@gmail.com", "rsk123", 98989999);
        session.save(s);
        tx.commit();
        session.close();
	}
}