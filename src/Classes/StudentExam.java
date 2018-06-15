package Classes;

public class StudentExam extends Exam{
    private int _score;
    private String[] _answers;
    private int _studentId;

    private void scoreCalculate(){};
    private String getAnswerByIndex(int idx){return _answers[idx];};
    private void updateAnswer(String answer, int idx){ _answers[idx] = answer;};
    private int getExamScore(){return _score;}
}
