package controler;

import entities.Customer;
import entities.CustomerEmail;
import entities.CustomerLogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Main;
import services.CustomerService;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SignupController {
    @FXML
    private TextField firstname;

    @FXML
    private TextField lastname;

    @FXML
    private TextField username;

    @FXML
    private TextField email;

    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton fmale;

    @FXML
    private DatePicker date_of_birth;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirmpassword;

    @FXML
    private Button signup;

    @FXML
    void singupAction(ActionEvent event) {
        Customer customer=new Customer();
        customer.setFirstname(firstname.getText());
        customer.setLastname(lastname.getText());

        LocalDate localDate=date_of_birth.getValue();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        localDate.format(formatter);
        Date date1 = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        customer.setDateofbirth(date1);

        male.setUserData("male");
        fmale.setUserData("female");
       if(gender.getSelectedToggle().getUserData().equals(male.getUserData())
       )
           customer.setSex("male");
       else customer.setSex("female");


        CustomerEmail customerEmail=new CustomerEmail();
        customerEmail.setCustomerId(customer.getCustomerId());
        customerEmail.setCustomer(customer);
        customerEmail.setEmailAddress(email.getText());
        CustomerLogin customerLogin=new CustomerLogin();
        customerLogin.setCustomerId(customer.getCustomerId());
        customerLogin.setUsername(username.getText());
        customerLogin.setCustomer(customer);
        if(confirmpassword.getText().equals(password.getText()))
            customerLogin.setPassward(confirmpassword.getText());

        CustomerService.saveCustomer(customer,customerEmail,customerLogin);

        Scene scene= Main.productView;
        Label label= (Label) scene.lookup("#username");
        label.setText(customerLogin.getUsername());
        Stage stage= (Stage) signup.getScene().getWindow();
        stage.setScene(scene);
    }

}
