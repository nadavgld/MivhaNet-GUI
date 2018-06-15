package Classes;

import Util.Utils;

public class User {
    private String _lastName;
    private String _firstName;
    private String _username;
    private String _id;
    private String _address;
    private String _phoneNumber;
    private String _email;
    private String _password;

    public User(){ }

    public User(String _lastName, String _firstName, String _username, String _id, String _address, String _phoneNumber, String _email, String _password) {
        this._lastName = _lastName;
        this._firstName = _firstName;
        this._username = _username;
        this._id = _id;
        this._address = _address;
        this._phoneNumber = _phoneNumber;
        this._email = _email;
        this._password = _password;
    }

    public User(String _lastName, String _firstName, String _username, String _address, String _phoneNumber, String _email, String _password) {
        this._lastName = _lastName;
        this._firstName = _firstName;
        this._username = _username;
        this._address = _address;
        this._phoneNumber = _phoneNumber;
        this._email = _email;
        this._password = _password;
    }

    public User(String username, String password){
        this._username = username;
        this._password = password;
    }

    public User(User user){
        this._lastName = user.get_lastName();
        this._firstName = user.get_firstName();
        this._username = user.get_username();
        this._id = user.get_id();
        this._address = user.get_address();
        this._phoneNumber = user.get_phoneNumber();
        this._email = user.get_email();
        this._password = user.get_password();
    }

    protected String userLogin(){

        String emp_num = Utils.Login(this._username,this._password);
        if(emp_num != null){
            return emp_num;
        }
        return null;

    }

    protected void passwordChange(String newPassword){};

    public String get_lastName() {
        return _lastName;
    }

    public void set_lastName(String _lastName) {
        this._lastName = _lastName;
    }

    public String get_firstName() {
        return _firstName;
    }

    public void set_firstName(String _firstName) {
        this._firstName = _firstName;
    }

    public String get_username() {
        return _username;
    }

    public void set_username(String _username) {
        this._username = _username;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_address() {
        return _address;
    }

    public void set_address(String _address) {
        this._address = _address;
    }

    public String get_phoneNumber() {
        return _phoneNumber;
    }

    public void set_phoneNumber(String _phoneNumber) {
        this._phoneNumber = _phoneNumber;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    public String get_password() {
        return _password;
    }

    public void set_password(String _password) {
        this._password = _password;
    }
}
