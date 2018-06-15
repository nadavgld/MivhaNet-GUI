package Classes;

import Util.Utils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import profile.profileCtrl;

import java.io.IOException;
import java.util.Observable;

public class Model extends Observable {

    private User _user;
    private Stage primaryStage;

    public Model(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void Login(User user) {

        String emp_num = user.userLogin();
        if (emp_num != null) {

            User userInfo = Utils.getUserInfo(emp_num);
            if (userInfo != null) {

                if (Utils.isSecretary(emp_num)) {
                    _user = new Secretary(userInfo);
                } else {
                    _user = new TeachingStaff(userInfo);
                }

                Object[] args = new Object[2];
                args[0] = "login";
                args[1] = _user;
                setChanged();
                notifyObservers(args);

                return;
            }
        }

        Object[] args = new Object[2];
        args[0] = "login";
        args[1] = null;
        setChanged();
        notifyObservers(args);

    }

    public User get_user() {
        return _user;
    }

    public void setScene(String view) throws IOException {

        String fxml = view.equals("profile") ? "../profile/profile.fxml" : "";

        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource(fxml).openStream());

        if (view.equals("profile")) {
            profileCtrl profileCtrl = fxmlLoader.getController();
            profileCtrl.setModel(this);
        }

        primaryStage.setTitle("MivhaNet");
        primaryStage.setScene(new Scene(root, 850, 600));
        primaryStage.show();

    }

    public void addNewUser(User new_user, int empnum) {
        Secretary secretary = new Secretary(_user);
        boolean hasAdded = secretary.createNewUser(new_user, empnum);

        Object[] args = new Object[2];
        args[0] = "addUser";
        args[1] = hasAdded;
        setChanged();
        notifyObservers(args);
    }

    public void openNewCourse(Course course, Semester semester) {
        Secretary secretary = new Secretary(_user);
        boolean hasOpened = secretary.openNewCourse(course, semester);

        Object[] args = new Object[2];
        args[0] = "openCourse";
        args[1] = hasOpened;
        setChanged();
        notifyObservers(args);
    }
}
