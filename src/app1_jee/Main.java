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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Main app=new Main();
         CustomerBean c, c1, c3;
         c =new CustomerBean();
          
          
        for(int i=0; i<10; i++){
        c1=new CustomerBean();
     //  c1.createCustomer("ammmoss"+i+"@domain.com", "toto"+i, "armel"+i, "loginToto"+i, "pass"+i, "00 66 00 00 0"+i);
       
        }
        
         
       
        
        
         System.out.println("*******lister les enregistrements de la table jee_customer *********");
         
       /* 
        List<Customer> customers=c.getAllCustomers();
        int i=0;
         System.out.println("");
       for(Customer cu : customers ){
           i++;
           System.out.println("-> customer n° "+i+"= "+cu.getLastname() +",  email= " + cu.getEmail()+", phone :" +cu.getTelephone());
       }
       */
    }
    
    
    
    
   
    
    
   
}//endclass
