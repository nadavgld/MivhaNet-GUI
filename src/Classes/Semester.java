package Classes;

import java.util.HashSet;
import java.util.Set;

public class Semester {
    private int _year;
    private Term _term;
    private Set<Course> _courses;

    public Semester(int year, Term term){
        this._year = year;
        this._term = term;
    }

    public void setCourses(Course[] courses){
        _courses = new HashSet<>();

        for(Course c:courses){
            _courses.add(c);
        }
    }

    public void addCourse(Course course){
        _courses.add(course);
    }

    public Course getCourseByName(String courseName){
        return null;
    }

    public int get_year() {
        return _year;
    }

    public Term get_term() {
        return _term;
    }

    public Set<Course> get_courses() {
        return _courses;
    }
}