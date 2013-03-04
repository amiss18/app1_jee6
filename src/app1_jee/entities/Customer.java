/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app1_jee.entities;

import java.io.Serializable;
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
@Table(name="jee_customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private String telephone;
    private String login;
    
    
    
    public String getFirstname(){
        return this.firstname;
    }
    
    public String getLastname(){
        return this.lastname;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    
    public String getEmail(){
        return this.email;
    }
    public Long getId() {
        return id;
    }
    
    public String getTelephone(){
        return this.telephone;
    }
    
    public String getLogin(){
        return this.login;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app1_jee.entities.Customer[ id=" + id + " ]";
    }
    
}
