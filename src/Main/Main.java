package Main;

import Classes.Model;
import homepage.homepageCtrl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import profile.profileCtrl;

public class Main extends Application {

    public static Model model;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Model model = new Model(primaryStage);

        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource("../homepage/homepage.fxml").openStream());

        homepageCtrl homepageCtrl = fxmlLoader.getController();
        homepageCtrl.setModel(model);

        primaryStage.setTitle("MivhaNet");
        primaryStage.setScene(new Scene(root, 850, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static Model getModel() {
        return model;
    }
}
