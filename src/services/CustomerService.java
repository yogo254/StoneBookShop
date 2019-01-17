package services;

import entities.Customer;
import entities.CustomerEmail;
import entities.CustomerLogin;
import sample.Main;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CustomerService {
    private static final EntityManager manager= Main.entityManagerTask.getValue();

    public static void saveCustomer(Customer customer, CustomerEmail customerEmail, CustomerLogin customerLogin){
        EntityTransaction transaction=manager.getTransaction();
        transaction.begin();
        try{
            manager.persist(customer);

            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        EntityTransaction transaction1=manager.getTransaction();
        transaction1.begin();
        Customer c=manager.createNamedQuery("Customer.findByFirstnameandLastname",Customer.class)
                .setParameter("firstname",customer.getFirstname())
                .setParameter("lastname",customer.getLastname()).getSingleResult();
        customerEmail.setCustomerId(c.getCustomerId());
        customerLogin.setCustomerId(c.getCustomerId());

        try{
            manager.persist(customerEmail);
            manager.persist(customerLogin);
            transaction1.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction1.rollback();
        }
    }
    public static List<Customer> getCustomerbyId(int id){
        List<Customer>customerList = manager.createNamedQuery("Customer.findByCustomerId",Customer.class)
                .setParameter("customerId",id).getResultList();
        return customerList;
    }
    public static List<CustomerEmail> getCustomerLoginbyEmail(String email){
        List<CustomerEmail>customerEmailList=manager.createNamedQuery("CustomerEmail.findByEmailAddress",CustomerEmail.class)
                .setParameter("emailAddress",email).getResultList();
        return customerEmailList;
    }
    public static  List<CustomerLogin> getCustomerLoginbyusername(String username){


            List<CustomerLogin>customerLoginList= manager.createNamedQuery("CustomerLogin.findByUsername", CustomerLogin.class)
                    .setParameter("username", username).getResultList();
        return customerLoginList;
    }
    public static List<CustomerLogin> getCustomerloginbyId(int id){

            List<CustomerLogin> customerLoginList= manager.createNamedQuery("CustomerLogin.findByCustomerId", CustomerLogin.class)
                    .setParameter("customerId", id).getResultList();

        return customerLoginList;
    }
    public  static List<CustomerLogin >getloginfromCustomerEmail(CustomerEmail customerEmail){
        Customer customer=customerEmail.getCustomer();
        return CustomerService.getCustomerloginbyId(customer.getCustomerId());
    }


}
