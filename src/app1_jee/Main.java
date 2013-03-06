
package app1_jee;

import app1_jee.entities.Address;
import app1_jee.entities.Book;
import app1_jee.entities.Customer;
import app1_jee.entities.CustomerBean;
import javax.persistence.*;
import java.util.*;
/**
 *
 * @author armel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Main app=new Main();
         CustomerBean c, c1, c3;
         c =new CustomerBean();
         
        
         
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("app1_jeePU");   
         EntityManager em = emf.createEntityManager();   
         EntityTransaction transac = em.getTransaction();
        transac.begin();
        
        /*
         * client N°1
         */
         Customer co=new Customer();
        
         Book book=new Book();
         book.setDescription("ce cahier détaille la conception d'un site de commerce électronique avec UML et Java EE 5.");
         book.setIllustrations(Boolean.TRUE);
         book.setIsbn("13: 978-2-2-212-1245566");
         book.setNbOfPage(300);
         book.setPrice(new Float(36.00));
         book.setTitle("Java EE 5: Les cahiers du programmeur");
         em.persist(book);
         
         Address add1=new Address("00 bd de la mezière","35000", "Rennes");
         Address add2=new Address("33 rue de la chalotais","35510", "Cesson-Sévigné");
        

         co.setFirstname("rose11");
         co.setLastname("miss rose");
         co.setLogin("roro11");
         co.setPassword("passRO11");
         co.setEmail("rose11@yahoo.fr");
         co.setTelephone("136756000");
         co.addAdress(add1);
         co.setBook(book);
          em.persist(co);
           
          
          /**
           * client n°2
           */
          
          Book book1=new Book();
         book1.setDescription("ce cahier détaille la conception d'un site de commerce électronique avec UML et Java EE 5(1).");
         book1.setIllustrations(Boolean.FALSE);
         book1.setIsbn("14: 978-2-2-212-1245566");
         book1.setNbOfPage(305);
         book1.setPrice(new Float(76.00));
         book1.setTitle("Java EE 5: Les cahiers du programmeur (1)");
         em.persist(book1);
         
          Customer co1=new Customer();
          
          co1.setFirstname("rose22");
         co1.setLastname("mav rose2");
         co1.setLogin("roro22");
         co1.setPassword("passRO22");
         co1.setEmail("rose22@yahoo.fr");
         co1.setTelephone("7926756365");
         co1.addAdress(add2);
         co1.setBook(book1);
         
          em.persist(co1);
      
        transac.commit();
        em.close();   
        emf.close();  
         
          
        // Customer co=new Customer("ammmoss"+"@domain.com", "toto", "armel", "loginToto", "pass", "00 66 00 00 0");
         //Address add=new Address("999 rue de la chalotais","Cesson-Sévigné","35510");
         // c.createCustomer(add, co);
      /* for(int i=0; i<10; i++){
        c1=new CustomerBean();
     //  c1.createCustomer("ammmoss"+i+"@domain.com", "toto"+i, "armel"+i, "loginToto"+i, "pass"+i, "00 66 00 00 0"+i);
       
        }*/
        
         
       
        
        
         System.out.println("*******lister les enregistrements de la table jee_customer *********");
         
       
        List<Customer> customers=c.getAllCustomers();
        int i=0;
         System.out.println("");
       for(Customer cu : customers ){
           i++;
           System.out.println("-> customer n° "+i+"= "+cu.getLastname() +",  email= " + cu.getEmail()+", phone :" +cu.getTelephone()+ "adresse = " + cu.getAddress()+" "+cu.getBook());
       }
       
    }
    
    
   
    
    
   
}//endclass
