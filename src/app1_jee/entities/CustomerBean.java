/*
 * classe métier permettant d'effectuer des actions crud sur custumer
 */
package app1_jee.entities;
import exception.ValidationException;
import javax.persistence.EntityManagerFactory;
import java.util.*;
import javax.persistence.*;
/**
 *
 * @author armel
 */
public class CustomerBean {
   private Query query;
   private EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("app1_jeePU");
    EntityManager em = emf.createEntityManager();
       
    /*
     * lister tous les clients
     */
    public List<Customer> getAllCustomers(){
       List<Customer> customers;
       
      // EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("app1_jeePU");
       //EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();
       query = em.createQuery("SELECT  c FROM Customer c");
       customers = query.getResultList();
        return customers;
    }
    
    public Customer setCustomer(Customer customer){
        if(customer == null )
            throw new ValidationException("Customer object is null");
        customer=new Customer();
        persist(customer);
        return customer;
    }
        
    public void persist(Object object) {
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
    
    
  

    
}
