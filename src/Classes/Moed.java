package Classes;

import java.util.Date;
import java.util.Set;

public class Moed {
    private String _moedId;
    private Date _date;
    private MoedType _type;
    private double _difficulty;
    private Set<QuestionInExam> _questions;
    private Set<StudentExam> _studentExams;

    private double calcAvgDifficulty() {
        return Double.parseDouble(null);
    };

    private void insertNewQuestion(QuestionInExam questionInExam) {
    };

    public double getAvgDifficulty() {
        return this._difficulty;
    }

    ;

    public Date getDate() {
        return _date;
    }

    ;

}

enum MoedType {A, B, C};