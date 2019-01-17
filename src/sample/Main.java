package sample;

import connection.DBConection;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.stage.Stage;

import javax.persistence.EntityManager;

public class Main extends Application {
    public static Task<EntityManager> entityManagerTask;
    public static Scene login;
    public static Scene productView;
    public static Scene signup;
    public static Scene adminView;
    public static Scene searchScene;
    public static Scene warningScene;
    public static Scene passwardReset;





    @Override
    public void start(Stage primaryStage) throws Exception{
        entityManagerTask=createManager();

        Parent root = FXMLLoader.load(getClass().getResource("../layouts/main.fxml"));
        primaryStage.setTitle("stone bookshop");
        Scene scene =new Scene(root,586,264);
        ProgressIndicator indicator= (ProgressIndicator) scene.lookup("#progressIndicator");

        Task<Void> task=new Task<Void>() {
            @Override
            protected Void call() throws Exception {

                login=MakeScenes.createLoginScene();
                updateProgress(10,100);
                productView=MakeScenes.createProductsViewScene();
                updateProgress(20,100);
                signup=MakeScenes.createSignupScene();
                updateProgress(30,100);
                warningScene=MakeScenes.warningScene();
                updateProgress(40,100);
                searchScene=MakeScenes.createSearchScene();
                passwardReset=MakeScenes.createPasswordResetScene();
                updateProgress(50,100);
                adminView=MakeScenes.createAdminViewScene();
                updateProgress(60,100);
                entityManagerTask.run();
                updateProgress(100,100);

                return null;
            }
        };
        task.setOnSucceeded(e->{
            primaryStage.setScene(login);
        });


         indicator.progressProperty().bind(task.progressProperty());
         task.run();



        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
    private Task<EntityManager>createManager(){
        return new Task<EntityManager>() {
            @Override
            protected EntityManager call() throws Exception {
                DBConection conection=new DBConection();
                return  DBConection.manager;
            }
        };
    }



    public static void main(String[] args) {
        launch(args);
    }
}
