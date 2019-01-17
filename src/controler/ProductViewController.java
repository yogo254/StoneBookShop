package controler;

import entities.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Main;
import services.ProductService;

import java.util.List;

public class ProductViewController {
    @FXML
    private Label username;

    @FXML
    private Button signout;
    @FXML
    private ScrollPane scrollPane;
    private Button refreshButton;


    @FXML
    void logout(ActionEvent event) {
        Stage stage= (Stage) signout.getScene().getWindow();
        stage.setScene(Main.login);

    }

    @FXML
    void refresh(ActionEvent event) {

        VBox vBox=new VBox();
        vBox.setSpacing(15);
        vBox.setPrefSize(737,419);



        List<Product>allProducts= ProductService.getAllProducts();
        for(Product p:allProducts){
            Label productName= new Label("Name: "+p.getProductName());
            productName.setPrefSize(150,16);
            VBox.setMargin(productName,new Insets(0,0,0,130));


            Label category=new Label("Category: "+p.getProductCategory());
            category.setPrefSize(150,16);
            VBox.setMargin(category,new Insets(0,0,0,130));

            Label cost=new Label("UnitCost: "+p.getUnitCost());
            cost.setPrefSize(150,16);
            VBox.setMargin(cost,new Insets(0,0,0,130));




            ImageView imageView=new ImageView();
            Image image=new Image(p.getProductimage());
            imageView.setImage(image);
            imageView.setFitHeight(200);
            imageView.setFitWidth(200);
            VBox.setMargin(imageView,new Insets(0,0,0,250));

            TextArea description=new TextArea();
            description.setText(p.getProductDescription());
            description.setPrefWidth(200);
            description.setPrefHeight(100);
            description.setEditable(false);




            Separator separator=new Separator();
            separator.setOrientation(Orientation.HORIZONTAL);


            vBox.getChildren().addAll(imageView,productName,category,cost,description,separator);


        }
        scrollPane.setContent(vBox);


    }

}


