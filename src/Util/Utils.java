package Util;

import Classes.Course;
import Classes.Semester;
import Classes.User;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;
import javafx.scene.control.Alert;

import java.io.File;
import java.io.IOException;

public class Utils {

    public static String dbPath = "src\\Util\\DB.accdb";

    public static void showAlert(Alert.AlertType type, String title, String text) {
        Alert alert = new Alert(type, text);
        alert.setTitle(title);

        alert.showAndWait();
    }

    public static String Login(String username, String password) {
        Table table = null;

        try {
            table = DatabaseBuilder.open(new File(dbPath)).getTable("users");
            for (Row row : table) {
                if (row.get("username").toString().equals(username) && row.get("password").toString().equals(password)) {
                    return row.get("emp_num").toString();
                }
            }

            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static Boolean isSecretary(String emp_num) {
        Table table = null;

        try {
            table = DatabaseBuilder.open(new File(dbPath)).getTable("users_roles");
            for (Row row : table) {
                if (row.get("emp_num").toString().equals(emp_num) && row.get("role").toString().equals("Secretary")) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static User getUserInfo(String emp_num) {
        Table table = null;

        try {
            table = DatabaseBuilder.open(new File(dbPath)).getTable("users");
            for (Row row : table) {
                if (row.get("emp_num").toString().equals(emp_num)) {
                    String _lastName = row.get("last_name").toString();
                    String _firstName = row.get("first_name").toString();
                    String _username = row.get("username").toString();
                    String _id = row.get("ID").toString();
                    String _address = row.get("address").toString();
                    String _phoneNumber = row.get("phone_number").toString();
                    String _email = row.get("email").toString();
                    String _password = row.get("password").toString();

                    return new User(_lastName, _firstName, _username, _id, _address, _phoneNumber, _email, _password);
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public static Boolean createNewUser(User user, int empnum) {
        Table table = null;
        try {
            table = DatabaseBuilder.open(new File(dbPath)).getTable("users");
            table.addRow(null, user.get_firstName(), user.get_lastName(), user.get_address(), user.get_password(), user.get_username(), user.get_email(), user.get_password(), empnum);

            return true;
        } catch (IOException e) {
            return false;
        }

    }

    public static Boolean openNewCourse(Course course, Semester semester) {

        String name = course.get_courseName();
        int num = Integer.parseInt(course.get_courseNum());
        int year = semester.get_year();
        int term = semester.get_term().ordinal();
        String id = course.get_courseNum() + "_" + semester.get_term().ordinal() + "_" + semester.get_year();

        Table table = null;
        try {
            table = DatabaseBuilder.open(new File(dbPath)).getTable("courses");
            table.addRow(null, name, num, id, year, term, "");

            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
