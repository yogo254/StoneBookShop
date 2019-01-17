/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author hunky
 */
@Entity
@Table(name = "customer_login", catalog = "stonebookshop", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerLogin.findAll", query = "SELECT c FROM CustomerLogin c")
    , @NamedQuery(name = "CustomerLogin.findByCustomerId", query = "SELECT c FROM CustomerLogin c WHERE c.customerId = :customerId")
    , @NamedQuery(name = "CustomerLogin.findByUsername", query = "SELECT c FROM CustomerLogin c WHERE c.username = :username")
    , @NamedQuery(name = "CustomerLogin.findByPassward", query = "SELECT c FROM CustomerLogin c WHERE c.passward = :passward")
    ,@NamedQuery(name = "CustomerLogin.searchByUsername",query = "select c from CustomerLogin" +
        " c where c.username " +
        "like :case1 or c.username like :case2 or c.username like :case3")})
public class CustomerLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "username")
    private String username;
    @Column(name = "passward")
    private String passward;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Customer customer;

    public CustomerLogin() {
    }

    public CustomerLogin(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerLogin)) {
            return false;
        }
        CustomerLogin other = (CustomerLogin) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CustomerLogin[ customerId=" + customerId + " ]";
    }
    
}
