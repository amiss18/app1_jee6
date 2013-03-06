/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app1_jee.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author armel
 */
@Entity
@Table(name="t_address")

public class Address implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id" ,unique=true,nullable=false)
    private Long id;
    
     @Column(name="street", nullable=false, length = 80)
     private String street;
     @Column(name="cp", nullable=false, length = 15)
     private String cp;
     @Column(name="city", nullable=false, length = 50)
     private String city;
     
     public Address(){}
     public Address(String street, String cp, String city ){
         this.street = street;
         this.cp = cp;
         this.city = city;
     }
     
     public String getStreet(){
         return this.street;
     }
     
     public String getCp(){
         return this.cp;
     }
     
     public String getCity(){
         return this.city;
     }
     
     public void setStreet(String _street){
         this.street = _street;
     }
     
      public void setCp(String _cp){
         this.cp = _cp;
     }
      
    public void setCity(String _city){
         this.city = _city;
     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\tAddress : [" +" i="+ id + ", "+ street + ","+ cp + " " + city+ " ]";
    }
    
}
