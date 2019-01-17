package controler;

import entities.CustomerLogin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Main;
import services.CustomerService;

public class SearchController {

    @FXML
    private TextField username_email;

    @FXML
    private ScrollPane scroll;

    @FXML
    private Button searchButton;

    @FXML
    private static Button cancel;

    public static void addActions(Hyperlink hyperlink) {

                hyperlink.setOnAction(event -> {
                    CustomerLogin login = CustomerService.getCustomerLoginbyusername(hyperlink.getText()).get(0);
                    Scene scene = Main.passwardReset;
                    Label username = (Label) scene.lookup("#username");
                    Label fullname = (Label) scene.lookup("#fullname");
                    username.setText(login.getUsername());
                    fullname.setText(login.getCustomer().getFirstname() + "  " + login.getCustomer().getLastname());
                    Stage stage = (Stage) cancel.getScene().getWindow();
                    stage.setScene(scene);

                });
            }




    @FXML
    void cancelAction(ActionEvent event) {
        Scene scene= Main.warningScene;
        Label message = (Label) scene.lookup("#message");
        message.setText("Do you want to cancel?");
        Stage stage=new Stage();
        stage.setScene(scene);

    }

    @FXML
    void searchAction(ActionEvent event) {


    }
}
