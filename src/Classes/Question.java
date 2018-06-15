package Classes;

public abstract class Question {
    protected  int _questionId;
    protected String _body;
    protected QuestionOption[] _options;
    protected int _difficulty;
    protected double _estimatedDuration;
    protected int rightAnswerIndex;
    protected Comment[] _comments = new Comment[10];
    private User _author;

    private void saveComment(Comment c){};
    private int getNumOfComments(){return _comments.length;}

}
