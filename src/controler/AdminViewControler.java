package controler;

import entities.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import services.ProductService;

import java.io.File;

public class AdminViewControler {
    private File file;
    @FXML
    private Label username;

    @FXML
    private TextField productName;

    @FXML
    private TextField category;

    @FXML
    private TextField cost;

    @FXML
    private TextArea description;

    @FXML
    private Button imageButton;

    @FXML
    private Button addbutton;

    @FXML
    void addProduct(ActionEvent event) {
        Product product=new Product();
        product.setProductCategory(category.getText());
        product.setProductName(productName.getText());
        product.setUnitCost(cost.getText());
        product.setProductDescription(description.getText());
        if(file!=null)
            product.setProductimage(file.toURI().toString());
        ProductService.addProduct(product);
        category.clear();
        productName.clear();
        cost.clear();
        description.clear();
        file=null;



    }

    @FXML
    void chooseImage(ActionEvent event) {
        FileChooser fileChooser =new FileChooser();
        fileChooser.setTitle("choose a product  image");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        Stage stage= (Stage) imageButton.getScene().getWindow();
        file=fileChooser.showOpenDialog(stage);

    }
}
