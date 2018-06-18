package Classes;

import Util.Utils;

import java.util.Date;

public class Secretary extends User {

    public Secretary(User user) {
        super(user);
    }

    public Boolean createNewUser(User user, int empnum){
        return Utils.createNewUser(user, empnum);
    }

    public Boolean openNewCourse(Course course, Semester semester){
        return Utils.openNewCourse(course,semester);
    }

    public void initialLogin(String username, String password){}
    public void viewStudentScore(String coursenum){}
    public void addCourseStaff(Course course){}
    public void addCourseExamDue (Course course, Semester semester, Date date, MoedType moedType){}
    public boolean checkAvailabilityOfDateForExam(Semester semester, Date date){return false;}
}
