/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hunky
 */
@Entity
@Table(name = "customer_email", catalog = "stonebookshop", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerEmail.findAll", query = "SELECT c FROM CustomerEmail c")
    , @NamedQuery(name = "CustomerEmail.findByCustomerId", query = "SELECT c FROM CustomerEmail c WHERE c.customerId = :customerId")
    , @NamedQuery(name = "CustomerEmail.findByEmailAddress", query = "SELECT c FROM CustomerEmail c WHERE c.emailAddress = :emailAddress")})
public class CustomerEmail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "email_address")
    private String emailAddress;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Customer customer;

    public CustomerEmail() {
    }

    public CustomerEmail(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
        if (!(object instanceof CustomerEmail)) {
            return false;
        }
        CustomerEmail other = (CustomerEmail) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CustomerEmail[ customerId=" + customerId + " ]";
    }
    
}
