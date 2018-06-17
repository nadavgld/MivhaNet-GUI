package profile;

import Classes.*;
import Main.Main;
import Util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import static java.lang.Integer.parseInt;

public class profileCtrl implements Observer {
    private Model model;
    private User user;

    @FXML
    public Label username_label;
    public Button open_course_btn;
    public Button create_user_btn;
    public Pane openCoursePane;
    public Pane newUserPane;

    // Form text-fields
    public TextField new_username;
    public TextField new_firstname;
    public TextField new_lastname;
    public TextField new_phone;
    public TextField new_address;
    public TextField new_email;
    public TextField new_password;
    public TextField new_empnum;

    // Add course Form
    public TextField open_coursename;
    public TextField open_coursenum;
    public TextField open_year;
    public TextField open_semester;


    public void initialize() {
        disablePanes();
    }

    private void initializeScene() {
        username_label.setText("[" + model.get_user().get_username() + "]");

        if (this.user instanceof Secretary) {
            open_course_btn.setVisible(true);
            create_user_btn.setVisible(true);
        }
    }

    public void setModel(Model model) {
        this.model = model;
        this.user = this.model.get_user();

        this.model.addObserver(this);
        initializeScene();
    }

    public void showOpenCourse(ActionEvent actionEvent) {
        disablePanes();
        openCoursePane.setVisible(true);
    }

    public void showCreateUser(ActionEvent actionEvent) {
        disablePanes();
        newUserPane.setVisible(true);
    }

    private void disablePanes() {
        newUserPane.setVisible(false);
        openCoursePane.setVisible(false);

        clearNewUserForm();
        clearOpenCourseForm();
    }

    private void clearOpenCourseForm() {
        open_coursename.setText("");
        open_coursenum.setText("");
        open_year.setText("");
        open_semester.setText("");
    }

    private void clearNewUserForm() {
        new_username.setText("");
        new_firstname.setText("");
        new_lastname.setText("");
        new_phone.setText("");
        new_address.setText("");
        new_email.setText("");
        new_password.setText("");
        new_empnum.setText("");
    }

    public void addNewUser(ActionEvent actionEvent) {
        String username = new_username.getText();
        String firstname = new_firstname.getText();
        String lastname = new_lastname.getText();
        String phone = new_phone.getText();
        String address = new_address.getText();
        String email = new_email.getText();
        String password = new_password.getText();
        String emp = new_empnum.getText();
        int empnum;

        try {
            empnum = parseInt(emp);
        } catch (Exception e) {
            Utils.showAlert(Alert.AlertType.ERROR, "Add User Error", "Employee number must be an Integer");
            return;
        }

        if (username.length() == 0 || firstname.length() == 0 || lastname.length() == 0 || phone.length() == 0 || address.length() == 0
                || email.length() == 0 || password.length() == 0) {
            Utils.showAlert(Alert.AlertType.ERROR, "Add User Error", "All fields must be filled");
        } else {
            User user_to_create = new User(lastname, firstname, username, address, phone, email, password);
            model.addNewUser(user_to_create, empnum);
        }
    }

    public void openCourse(ActionEvent actionEvent) {
        String coursename = open_coursename.getText();
        String coursenum = open_coursenum.getText();
        String year_string = open_year.getText();
        String semester_string = open_semester.getText();
        Term term;
        int year;

        try {
            if (parseInt(semester_string) >= Term.values().length || parseInt(semester_string) <= 0) {
                Utils.showAlert(Alert.AlertType.ERROR, "Open Course Error", "Semester must be a number 1-3");
                return;
            }

            term = Term.values()[parseInt(semester_string)];

        } catch (Exception e) {
            Utils.showAlert(Alert.AlertType.ERROR, "Open Course Error", "Semester must be a number 1-3");
            return;
        }

        try {
            year = Integer.parseInt(year_string);
        } catch (Exception e) {
            Utils.showAlert(Alert.AlertType.ERROR, "Open Course Error", "Year must be a positive number");
            return;
        }

        if (coursename.length() == 0 || coursenum.length() == 0 || year_string.length() == 0) {
            Utils.showAlert(Alert.AlertType.ERROR, "Open Course Error", "All fields must be filled");
        } else {
            Course course = new Course(coursename, coursenum);
            Semester semester = new Semester(year, term);
            model.openNewCourse(course, semester);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        Object[] a = (Object[]) arg;

        String requestType = a[0].toString();

        switch (requestType) {
            case "addUser":
                boolean hasAdded = (Boolean) a[1];

                if (hasAdded) {
                    Utils.showAlert(Alert.AlertType.INFORMATION, "Add User", "New user was added successfully");
                    clearNewUserForm();
                } else {
                    Utils.showAlert(Alert.AlertType.ERROR, "Add User Error", "Error while adding user");
                }

                break;

            case "openCourse":
                boolean hasOpened = (Boolean) a[1];

                if (hasOpened) {
                    Utils.showAlert(Alert.AlertType.INFORMATION, "Open Course", "Course opened successfully");
                    clearOpenCourseForm();
                } else {
                    Utils.showAlert(Alert.AlertType.ERROR, "Open Course Error", "Error while opening course");
                }

                break;
        }
    }
}
