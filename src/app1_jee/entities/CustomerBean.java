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
    private Customer customer;
   private Query query;
   private EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("app1_jeePU");
    EntityManager em = emf.createEntityManager();
    private List<Address> address =new ArrayList()  ;
    /*
     * lister tous les clients
     */
    public List<Customer> getAllCustomers(){
       List<Customer> customers;
       em.getTransaction().begin();
       query = em.createQuery("SELECT  c FROM Customer c");
       customers = query.getResultList();
        return customers;
    }
    
    public Customer createCustomer(String email, String lastname, String firstname, String login, String pass, String tel){
       // if(customer == null )
         //   throw new ValidationException("Customer object is null");
        customer=new Customer();
        customer.setEmail(email);
        customer.setLastname(lastname);
        customer.setFirstname(firstname);
        customer.setLogin(login);
        customer.setPassword(pass);
        customer.setTelephone(tel);
        persist(customer);
        return customer;
    }
    
    /*
     public Customer createCustomer(Address address, Customer customer){
         customer.addAdress(address);
         this.persist(customer);
         return customer;
     }
      */
    
   
        
   
    
     public Customer updateCustomer(Customer customer){
        if(customer == null )
            throw new ValidationException("Customer object is null");
        customer=new Customer();
        merge(customer);
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
    
    
    public void merge(Object object) {
        em.getTransaction().begin();
        try {
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
        em.close();
        }
    }
    
    
  

    
}
