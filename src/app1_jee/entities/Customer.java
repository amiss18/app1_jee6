/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app1_jee.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author armel
 */
@Entity
@Table(name="t_customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id" ,unique=true,nullable=false)
    private Long id;
    @Column(name="firstname", nullable=false, length = 55)
    private String firstname;
    @Column(name="lastname", nullable=false, length = 55)
    private String lastname;
    @Column(name="password", nullable=false, length = 55)
    private String password;
    @Column(unique=true, name="email", nullable=false, length = 55)
    private String email;
    @Column(name="telephone", nullable=false, length = 16)
    private String telephone;
    @Column(unique=true, name="login", nullable=false, length = 55)
    private String login;
    
    @OneToMany(fetch= FetchType.EAGER, cascade= CascadeType.ALL)
    @JoinColumn(name="customer_fk")
    private List<Address> address;
    
    @OneToMany(fetch= FetchType.EAGER, cascade= CascadeType.ALL)
    @JoinColumn(name="customer_fk")
    private List<Book> books;
  
    public Customer(){}
    public Customer(String email, String lastname, String firstname, String login, String pass, String tel){
        this.email = email;
        this.lastname = lastname;
        this.firstname = firstname;
        this.login = login;
        this.password = pass;
        this.telephone = tel;
    }
    
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
    
    
    public List<Address> getAddress(){
        return this.address;
    }
     
    public List<Book> getBook(){
        return this.books;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public void setFirstname(String _firstname) {
        this.firstname = _firstname;
    }
    
    public void setLastname(String _lastname) {
        this.lastname = _lastname;
    }
    
    public void setPassword(String _password) {
        this.password = _password;
    }
    
    public void setEmail(String _email) {
        this.email = _email;
    }
    
     public void setTelephone(String _telephone) {
        this.telephone = _telephone;
    }
     
     public void setLogin(String _login) {
        this.login = _login;
    }
     
    public void setAddress( List<Address> _add) {
        this.address = _add;
    }
    
     public void setBook( Book _book) {
         books=new ArrayList<Book>();
         books.add(_book);
    }
     
     public void addAdress(Address add){
         this.address = new ArrayList<Address>();
         address.add(add);
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
        return "app1_jee.entities.Customer[ lastname=" + this.lastname + ", firstname="+ this.firstname +
                "\nphone= "+ this.telephone + "\n login = " + login + " and password = " +password+
                "]";
    }
    
}
