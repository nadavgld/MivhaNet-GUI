package Classes;

import java.util.List;
import java.util.Set;

public class Course {
    private String _courseName;
    private String _courseNum;
    private String _syllabus;
    private List<Exam> _exams;
    private CourseStaff _staff;
    private Set<Student> _students;

    public Course(String _courseName, String _courseNum) {
        this._courseName = _courseName;
        this._courseNum = _courseNum;
    }

    public Course(String _courseName, String _courseNum, String _syllabus, List<Exam> _exams, CourseStaff _staff, Set<Student> _students) {
        this._courseName = _courseName;
        this._courseNum = _courseNum;
        this._syllabus = _syllabus;
        this._exams = _exams;
        this._staff = _staff;
        this._students = _students;
    }

    public Course(String _courseName, String _courseNum, String _syllabus) {
        this._courseName = _courseName;
        this._courseNum = _courseNum;
        this._syllabus = _syllabus;
    }

    public void addExam(Exam exam){
        _exams.add(exam);
    }

    public void addStudent(Student student){
        _students.add(student);
    }

    public String get_courseName() {
        return _courseName;
    }

    public void set_courseName(String _courseName) {
        this._courseName = _courseName;
    }

    public String get_courseNum() {
        return _courseNum;
    }

    public void set_courseNum(String _courseNum) {
        this._courseNum = _courseNum;
    }

    public String get_syllabus() {
        return _syllabus;
    }

    public void set_syllabus(String _syllabus) {
        this._syllabus = _syllabus;
    }

    public List<Exam> get_exams() {
        return _exams;
    }

    public void set_exams(List<Exam> _exams) {
        this._exams = _exams;
    }

    public CourseStaff get_staff() {
        return _staff;
    }

    public void set_staff(CourseStaff _staff) {
        this._staff = _staff;
    }

    public Set<Student> get_students() {
        return _students;
    }

    public void set_students(Set<Student> _students) {
        this._students = _students;
    }
}
