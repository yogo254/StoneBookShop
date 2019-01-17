package services;

import entities.CustomerEmail;
import entities.CustomerLogin;
import sample.Main;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class CustomerSearchService {
    public static final EntityManager maneger= Main.entityManagerTask.getValue();

    public static Optional<CustomerLogin> search(String usernameorEmail){
        CustomerLogin customerLogin=null;
        if(!CustomerService.getCustomerLoginbyusername(usernameorEmail).isEmpty())
            customerLogin = CustomerService.getCustomerLoginbyusername(usernameorEmail).get(0);
            Optional<CustomerLogin> loginbyusername = Optional
                    .ofNullable(customerLogin);

        CustomerEmail customerEmail=null;
        if(!CustomerService.getCustomerLoginbyEmail(usernameorEmail).isEmpty())
            customerEmail=CustomerService.getCustomerLoginbyEmail(usernameorEmail)
                    .get(0);

        Optional<CustomerEmail>customerEmailOptional=Optional
                .ofNullable(customerEmail);
        Optional<CustomerLogin>loginbyemail=Optional.empty();
        if(customerEmailOptional.isPresent())loginbyemail=Optional
                .of(CustomerService.getloginfromCustomerEmail(customerEmail).get(0));
        if(loginbyusername.isPresent())
            return loginbyusername;
        else if(loginbyemail.isPresent())
            return loginbyemail;
        else return Optional.empty();


    }
    public static List<CustomerLogin>getbyUsername(String username){
        List<CustomerLogin>logins=maneger.createNamedQuery("CustomerLogin.searchByUsername",
                CustomerLogin.class).setParameter("case1",username+"%")
                .setParameter("case2","%"+username+"%")
                .setParameter("case3","%"+username)
                .getResultList();
        return logins;

    }
}
