package Classes;

public class Lecturer extends TeachingStaff {
    public Lecturer(User user) {
        super(user);
    }

    private void removeQuestion(Course course, String questionID){};
    private void addQuestionOption(Course course, String questionID, QuestionOption option){};
    private void updateQuestionOption(Course course, String questionID, int optionNumber, QuestionOption option){};
}
