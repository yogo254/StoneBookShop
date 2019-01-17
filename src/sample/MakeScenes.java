package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class MakeScenes {
    public static Scene createLoginScene(){

        Parent root = null;
        try {
            root = FXMLLoader.load(MakeScenes.class.getResource("../layouts/login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Scene(root,642,488);
    }
    public static Scene createProductsViewScene(){

        Parent root = null;
        try {
            root = FXMLLoader.load(MakeScenes.class.getResource("../layouts/productsview.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Scene(root,997,533);
    }
    public static Scene createSignupScene(){

        Parent root = null;
        try {
            root = FXMLLoader.load(MakeScenes.class.getResource("../layouts/signup.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Scene(root,656,484);
    }
    public static Scene createAdminViewScene(){
        Parent root = null;
        try {
            root = FXMLLoader.load(MakeScenes.class.getResource("../layouts/adminView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Scene(root,669,516);
    }
    public static Scene warningScene(){
        Parent root = null;
        try {
            root = FXMLLoader.load(MakeScenes.class.getResource("../layouts/warning.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Scene(root,544,133);
    }
    public static Scene createSearchScene(){
        Parent root = null;
        try {
            root = FXMLLoader.load(MakeScenes.class.getResource("../layouts/searchAccount.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Scene(root,600,444);
    }
    public static Scene createPasswordResetScene(){
        Parent root = null;
        try {
            root = FXMLLoader.load(MakeScenes.class.getResource("../layouts/passwordReset.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Scene(root,633,413);
    }

}
