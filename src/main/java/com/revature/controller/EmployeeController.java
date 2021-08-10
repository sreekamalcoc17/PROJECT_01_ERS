package com.revature.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.Authentication;
import com.revature.pojo.Employee;
import com.revature.pojo.Login;
import com.revature.pojo.Manager;
import com.revature.pojo.SendRequest;
import com.revature.pojo.SessionEmailManage;
import com.revature.pojo.Sessionidmanage;
import com.revature.utils.*;
import com.revature.controller.CorsFilter;

@Path("employee")
public class EmployeeController {
	
	@POST
    @Path("/submitrequest")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    
        public String formsubmit(String data) throws ClassNotFoundException, JsonProcessingException {
            
            System.out.println(data);
            Session session = null;
            Transaction transaction = null;
            ObjectMapper obj=new ObjectMapper();
            System.out.println(data);
            SendRequest u=obj.readValue(data, SendRequest.class);
            System.out.println(u);
            
       
            Authentication a=new Authentication();
            	 try {
                     session = HibernateUtil.getSessionFactory().openSession();
                     transaction = session.beginTransaction();
                     
                     session.save(u);
                     transaction.commit();
                     a.setStatus("true");
                     session.close();
                 
                     return obj.writeValueAsString(a);

                 } catch (Exception ex) {
                     if (transaction != null) {
                     transaction.rollback();
                     }
                     a.setStatus("false");
                     System.out.println(a);
                     return obj.writeValueAsString(a);       
                     
                 }
    }
	@POST
    @Path("/getcount")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public String numberofreq(String data) throws ClassNotFoundException, JsonProcessingException {
		System.out.println(data);
        Session session = null;
        Transaction transaction = null;
        ObjectMapper obj=new ObjectMapper();
        System.out.println(data);
        SessionEmailManage u=obj.readValue(data, SessionEmailManage.class);
        System.out.println(u);
        String mailid = u.getEmail();
        String pending = "pending";
        String sucess = "sucess";
        String denied = "denied";
        
        
   
        Authentication a=new Authentication();
        	 try {
                 session = HibernateUtil.getSessionFactory().openSession();
                 transaction = session.beginTransaction();
                 Query query1 = session.createQuery("select count(sr.reqid) FROM SendRequest sr WHERE sr.email = :email1 AND sr.statusOfReq = :pending1")
                		 		.setParameter("email1", mailid)
                		 		.setParameter("pending1", pending);
                 
                 Query query2 = session.createQuery("select count(sr.reqid) FROM SendRequest sr WHERE sr.email = :email1 AND sr.statusOfReq = :sucess1")
         		 		.setParameter("email1", mailid)
         		 		.setParameter("sucess1", sucess);
                 
                 Query query3 = session.createQuery("select count(sr.reqid) FROM SendRequest sr WHERE sr.email = :email1")
          		 		.setParameter("email1", mailid);
                 
                 Query query4 = session.createQuery("select count(sr.reqid) FROM SendRequest sr WHERE sr.email = :email1 AND sr.statusOfReq = :sucess1")
          		 		.setParameter("email1", mailid)
          		 		.setParameter("sucess1", denied);
                 long pendingcount = 0;
                 long sucesscount = 0;
                 long totalcount = 0;
                 long deniedcount = 0;
                 for(Iterator it=query1.iterate();it.hasNext();)
                 {
                	 pendingcount = (Long) it.next();
                  System.out.println("pending Count: " + pendingcount);
                 }
                 
                 for(Iterator it=query2.iterate();it.hasNext();)
                 {
                	 sucesscount = (Long) it.next();
                  System.out.println("success Count: " + sucesscount);
                 }
                 
                 for(Iterator it=query3.iterate();it.hasNext();)
                 {
                	 totalcount = (Long) it.next();
                  System.out.println("total Count: " + totalcount);
                 }
                 for(Iterator it=query4.iterate();it.hasNext();)
                 {
                	 deniedcount = (Long) it.next();
                  System.out.println("total Count: " + deniedcount);
                 }
                 
                 String res1 = "{\"totalcount\":"+totalcount+","+"\"sucesscount\":"+sucesscount+","+"\"pendingcount\":"+pendingcount+","+"\"deniedcount\":"+deniedcount+"}";            
                 System.out.println(res1);
                 transaction.commit();
                 a.setStatus("true");
                 session.close();
                 return res1;
             } catch (Exception ex) {
                 if (transaction != null) {
                 transaction.rollback();
                 }
                 a.setStatus("false");
                 System.out.println(a);
                 return obj.writeValueAsString(a);       
                 
             }
	}
	@POST
    @Path("/gettable")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public String gettable(String data) throws ClassNotFoundException, JsonProcessingException {
		System.out.println(data);
        Session session = null;
        Transaction transaction = null;
        ObjectMapper obj=new ObjectMapper();
        System.out.println(data);
        SessionEmailManage u=obj.readValue(data, SessionEmailManage.class);
        System.out.println(u);
        String mailid = u.getEmail();
        
        Authentication a=new Authentication();
        	 try {
                 session = HibernateUtil.getSessionFactory().openSession();
                 transaction = session.beginTransaction();
                 List<SendRequest> stulis = session.createQuery("from SendRequest sr WHERE sr.email= :email1", SendRequest.class).setParameter("email1", mailid).list();
                 stulis.forEach(s->System.out.println(s));
                 transaction.commit();
                 a.setStatus("true");
                 session.close();
                 return obj.writeValueAsString(stulis);
             } catch (Exception ex) {
                 if (transaction != null) {
                 transaction.rollback();
                 }
                 a.setStatus("false");
                 System.out.println(a);
                 return obj.writeValueAsString(a);       
                 
             }
	}
//	@POST
//    @Path("/get")
//	@Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//	public String numberofreq(String data) throws ClassNotFoundException, JsonProcessingException {
//		System.out.println(data);
//        Session session = null;
//        Transaction transaction = null;
//        ObjectMapper obj=new ObjectMapper();
//        System.out.println(data);
//        SessionEmailManage u=obj.readValue(data, SessionEmailManage.class);
//        System.out.println(u);
//        String mailid = u.getEmail();
//        String pending = "pending";
//        
//   
//        Authentication a=new Authentication();
//        	 try {
//                 session = HibernateUtil.getSessionFactory().openSession();
//                 transaction = session.beginTransaction();
//                 Query query1 = session.createQuery("select count(sr.reqid) FROM SendRequest sr WHERE sr.email = :userid")
//                		 		.setParameter("userid", mailid);
//                
//                 Iterator count = query1.iterate();
//                 
//                 System.out.println(count.next());
//                 
//                 transaction.commit();
//                 a.setStatus("true");
//                 session.close();
//                 return obj.writeValueAsString(count.next());
//             } catch (Exception ex) {
//                 if (transaction != null) {
//                 transaction.rollback();
//                 }
//                 a.setStatus("false");
//                 System.out.println(a);
//                 return obj.writeValueAsString(a);       
//                 
//             }
//	}
//	@POST
//    @Path("/getcount")
//	@Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//	public String numberofreq(String data) throws ClassNotFoundException, JsonProcessingException {
//		System.out.println(data);
//        Session session = null;
//        Transaction transaction = null;
//        Criteria cr = session.createCriteria(SendRequest.class);
//        ObjectMapper obj=new ObjectMapper();
//        System.out.println(data);
//        SessionEmailManage u=obj.readValue(data, SessionEmailManage.class);
//        System.out.println(u);
//        String mailid = u.getEmail();
//        String pending = "pending";
//        
//   
//        Authentication a=new Authentication();
//        	 try {
//                 session = HibernateUtil.getSessionFactory().openSession();
//                 transaction = session.beginTransaction();
//                 Query query1 = session.createQuery("select count(sr.reqid) FROM SendRequest sr WHERE sr.email = :userid")
//                		 		.setParameter("userid", mailid);
//                 Criterion email = Restrictions.like("email",mailid);
//                 Criterion status = Restrictions.like("status","pending");
//                
//                 LogicalExpression andExp = Restrictions.and(email, status);
//                 cr.add( andExp );
//                 List results = cr.list();
//
//
//                 Iterator count = query1.iterate();
//                 
//                 System.out.println(count.next());
//                 
//                 
//                 transaction.commit();
//                 a.setStatus("true");
//                 session.close();
//                 return obj.writeValueAsString(results);
//             } catch (Exception ex) {
//                 if (transaction != null) {
//                 transaction.rollback();
//                 }
//                 a.setStatus("false");
//                 System.out.println(a);
//                 return obj.writeValueAsString(a);       
//                 
//             }
//	}
	
	
}
