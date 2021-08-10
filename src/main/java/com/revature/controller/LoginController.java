package com.revature.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.Authentication;
import com.revature.pojo.Employee;
import com.revature.pojo.EmployeeSessionManager;
import com.revature.pojo.Login;
import com.revature.pojo.Manager;
import com.revature.pojo.Sessionidmanage;
import com.revature.utils.*;
import com.revature.controller.CorsFilter;

@Path("index")
public class LoginController {
	
	Sessionidmanage lc = new Sessionidmanage();
	Employee e = new Employee();
	public int qwe;
	@GET
	@Path("/hi")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
	
	@POST
    @Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    
        public String empLogin(String data) throws ClassNotFoundException, JsonProcessingException {
            
            System.out.println(data);
            Session session = null;
            Transaction transaction = null;
            ObjectMapper obj=new ObjectMapper();
            System.out.println(data);
            Login u=obj.readValue(data, Login.class);
            System.out.println(u);
            String uid=u.getEmail();
            String pwd=u.getPassword();
            String des=u.getDesignation();
            System.out.println(des);
            System.out.println(des.length());
            EmployeeSessionManager a=new EmployeeSessionManager();
            
            	 try {
                     session = HibernateUtil.getSessionFactory().openSession();
                     transaction = session.beginTransaction();
                    
                     e = (Employee) session.createQuery("FROM Employee E WHERE E.email = :userId")
                     		.setParameter("userId", uid).uniqueResult();
                     if (e != null && e.getPassword().equals(pwd)) {
                    	 lc.setSessid(e.getId());
                    	 qwe = e.getId();
                    	 System.out.println(e.getId());
                         a.setStatus("true");
                         a.setId(e.getId());
                         a.setFirstName(e.getFirstName());
                         a.setLastName(e.getLastName());
                         a.setEmail(e.getEmail());
                         a.setPhno(e.getPhno());
                         a.setHouseNo(e.getHouseNo());
                         a.setCity(e.getCity());
                         a.setState(e.getState());
                         a.setCountry(e.getCountry());
                         a.setPin(e.getPin());
                         System.out.println(a);
                         
                         return obj.writeValueAsString(a);
                     }else if(e != null && e.getPassword()!=pwd) {
                     	a.setStatus("false");
                     	a.setId(0);
                     	return obj.writeValueAsString(a);
                     }
                     transaction.commit();
                 } catch (Exception ex) {
                     if (transaction != null) {
                     transaction.rollback();
                     }
                     a.setStatus("false");
                     a.setId(0);
                     System.out.println(a);
                     return obj.writeValueAsString(a);
                     
                     
                 }
            
           
            return null;
        
        
    }
	
	@POST
    @Path("/adlogin")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    
        public String adminLogin(String data) throws ClassNotFoundException, JsonProcessingException {
            
            System.out.println(data);
            Session session = null;
            Transaction transaction = null;
            ObjectMapper obj=new ObjectMapper();
            System.out.println(data);
            Login u=obj.readValue(data, Login.class);
            System.out.println(u);
            String uid=u.getEmail();
            String pwd=u.getPassword();
            String des=u.getDesignation();
            System.out.println(des);
            System.out.println(des.length());
            EmployeeSessionManager a=new EmployeeSessionManager();
            	 try {
                     session = HibernateUtil.getSessionFactory().openSession();
                     transaction = session.beginTransaction();
                    
                     Manager e = (Manager) session.createQuery("FROM Manager E WHERE E.email = :userId")
                     		.setParameter("userId", uid).uniqueResult();
                     if (e != null && e.getPassword().equals(pwd)) {
                    	 lc.setSessid(e.getAdId());
                    	 qwe = e.getAdId();
                    	 System.out.println(e.getAdId());
                         a.setStatus("true");
                         a.setId(e.getAdId());
                         a.setFirstName(e.getFirstName());
                         a.setLastName(e.getLastName());
                         a.setEmail(e.getEmail());
                         a.setPhno(e.getPhno());
                         System.out.println(a);
                         System.out.println(a);
                         return obj.writeValueAsString(a);
                     }else if(e != null && e.getPassword()!=pwd) {
                     	a.setStatus("false");
                     	return obj.writeValueAsString(a);
                     }
                     transaction.commit();
                 } catch (Exception ex) {
                     if (transaction != null) {
                     transaction.rollback();
                     }
                     a.setStatus("false");
                     System.out.println(a);
                     return obj.writeValueAsString(a);
                     
                     
                 }
            
           
            return null;
        
        
    }
	
//	@POST
//    @Path("/idsess")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public String sessionid(String data) throws ClassNotFoundException, JsonProcessingException{
//        System.out.println(data);
//		 Session session = null;
//         Transaction transaction = null;
//         ObjectMapper obj=new ObjectMapper();
//         Sessionidmanage u=obj.readValue(data, Sessionidmanage.class);
//    	 System.out.println(u);
//         int uid=u.getSessid();
//        
//         try {
//        	 
//             session = HibernateUtil.getSessionFactory().openSession();
//             transaction = session.beginTransaction();
//            
//             e = (Employee) session.createQuery("FROM Employee E WHERE E.id = :userId")
//             		.setParameter("userId", uid).uniqueResult();
//             transaction.commit();
//             return obj.writeValueAsString(e);
//             
//         } catch (Exception ex) {
//             if (transaction != null) {
//             transaction.rollback();
//             }
//             
//             
//             
//             
//         }
//		return null;
//    
//             
//		
//		
//	}

}
