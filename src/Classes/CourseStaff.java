package Classes;

public class CourseStaff {
    private Lecturer[] _lecturers = new Lecturer[5];
    private Practitioner[] _practitioner = new Practitioner[3];
    private CourseManager _courseManager;
    private Boolean _belongsToCurrentCourse;

    private void viewQuestion(String questionID){};
    private void writeQuestion(Question question){};
    private void updateQuestion(Question oldQuestion, Question newQuestion){};
    private void setQuestionDifficulty(String questionID, int difficulty){};
    private void setQuestionDuration(String questionID, double duration){};
    private void addStudentAnswers(Exam exam, StudentExam studentExam){};
    private void updateExam(Exam exam){};
    private void insertQuestionToExam(Exam exam, Question question, MoedType moedType){}
}
