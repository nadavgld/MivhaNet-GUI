package homepage;

import Classes.Secretary;
import Classes.User;
import Util.Utils;

import Classes.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;


public class homepageCtrl implements Observer {
    @FXML
    public TextField login_username;
    public PasswordField login_password;

    private Model model;
    private User user;

    public void setModel(Model model) {
        this.model = model;
        model.addObserver(this);
    }

    public void submitLogin(ActionEvent actionEvent) {
        String username = login_username.getText();
        String password = login_password.getText();

        if(username.length() == 0 || password.length() == 0){
            Utils.showAlert(Alert.AlertType.ERROR,"Login Error","All fields must be filled");
            return;
        }else{
            user = new User(username, password);
            model.Login(user);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        Object[] a = (Object[]) arg;

        String requestType = a[0].toString();

        switch (requestType){
            case "login":
                user = (User) a[1];

                if(user != null){
                    try {
                        this.model.setScene("profile");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    Utils.showAlert(Alert.AlertType.ERROR,"Login Error", "Username and password are not matched");
                    login_password.setText("");
                }
        }
    }
}
