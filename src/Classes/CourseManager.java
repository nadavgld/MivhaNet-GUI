package Classes;

public class CourseManager extends Lecturer {
    public CourseManager(User user) {
        super(user);
    }

    private void setSyllabus(Course course, String newSyllabus) {}
    private void addExam(Exam exam) { }
    private boolean approveExam(Exam exam) {
        return Boolean.parseBoolean(null);
    }
    private void updateGrade(Exam exam, int score, StudentExam studentExam) { }
    private void sendToFix(CourseStaff courseStaff, Exam exam) { }
}
