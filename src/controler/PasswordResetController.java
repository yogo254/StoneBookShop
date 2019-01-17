package controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PasswordResetController {
    @FXML
    private Label username;

    @FXML
    private Label fullname;

    @FXML
    private Label question;

    @FXML
    private TextField answer;

    @FXML
    private PasswordField newpassward;

    @FXML
    private PasswordField confirmpassward;

    @FXML
    private Button submit;

    @FXML
    private Button cancel;

    @FXML
    void onCancel(ActionEvent event) {

    }

    @FXML
    void onSubmit(ActionEvent event) {

    }
}
