/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app1_jee;

import app1_jee.entities.Customer;
import app1_jee.entities.CustomerBean;
import javax.persistence.*;
import java.util.*;
/**
 *
 * @author armel
 */
public class App1_jee {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        Customer customer=new Customer();
       /* customer.setFirstname("armel");
        customer.setLastname("toto");
        customer.setEmail("ammmoss_AT_domain.com");
        customer.setLogin("amiss");
        customer.setPassword("pass");
        customer.setTelephone("00 00 00 00 00");
        App1_jee app=new App1_jee();
        app.persist(customer);
        
         Customer customer1=new Customer();
        customer1.setFirstname("titi 1");
        customer1.setLastname("dupond");
        customer1.setEmail("titi_AT_domain.com");
        customer1.setLogin("titi1");
        customer1.setPassword("pass2");
        customer1.setTelephone("09 00 00 00 00");
       app.persist(customer1);
        */
        
         System.out.println("*******lister les enregistrements de la table jee_customer *********");
         
        CustomerBean c =new CustomerBean();
        List<Customer> customers=c.getAllCustomers();
        int i=0;
         System.out.println("");
       for(Customer cu : customers ){
           i++;
           System.out.println("-> customer n° "+i+"= "+cu.getLastname() +",  email= " + cu.getEmail()+", phone :" +cu.getTelephone());
       }
    }
   
    
    public void persist(Object object) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("app1_jeePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
        em.close();
        }
    }
    
   
}//endclass
