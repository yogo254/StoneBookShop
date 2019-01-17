package controler;

import entities.CustomerLogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Main;
import services.CustomerSearchService;

import java.util.List;
import java.util.Optional;

public class LoginController {

    @FXML
    private Label errorLabel;
    @FXML
    private TextField username_email;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML
    private Button createAccount;

    @FXML
    private Hyperlink forgotPassward;

    @FXML

    void createAccount(ActionEvent event) {
        Stage stage= (Stage) createAccount.getScene().getWindow();
        stage.setScene(Main.signup);

    }

    @FXML
    void forgotpasswordAction(ActionEvent event) {
        Scene scene=Main.searchScene;
        TextField username= (TextField) scene.lookup("#username_email");
        ScrollPane pane= (ScrollPane) scene.lookup("#scroll");
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            List<CustomerLogin>logins=CustomerSearchService.getbyUsername(newValue);
            ListView<Hyperlink>listView=new ListView<>();
            listView.setEditable(false);


            logins.forEach(e->{
                Hyperlink hyperlink=new Hyperlink(e.getUsername());


                listView.getItems().add(hyperlink);
            });

            pane.setContent(listView);

        });
        Stage stage= (Stage) forgotPassward.getScene().getWindow();
        stage.setScene(Main.searchScene);


    }

    @FXML
    void loginAction(ActionEvent event) {
        String usernameorEmail=username_email.getText();
        Optional<CustomerLogin>loginOptional= CustomerSearchService.search(usernameorEmail);
        if(loginOptional.isPresent()){
            CustomerLogin customerLogin=loginOptional.get();
            if(password.getText().equals(customerLogin.getPassward())){
                Scene scene=Main.productView;
                Label username= (Label) scene.lookup("#username");
                Button refresh= (Button) scene.lookup("#refreshButton");
                refresh.fire();
                username.setText(customerLogin.getUsername());
                Stage stage= (Stage) login.getScene().getWindow();
                stage.setScene(scene);
            }
            else errorLabel.setText("invalid passward!");

        }else if(usernameorEmail.equals("admin") && password.getText().equals("admin")){
            Scene scene=Main.adminView;
            Stage stage= (Stage) login.getScene().getWindow();
            Label username = (Label) scene.lookup("#username");
            username.setText("admin");
            stage.setScene(scene);

        }
        else errorLabel.setText("invalid username or email!");



    }


}


