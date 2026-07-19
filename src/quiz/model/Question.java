package quiz.model;

public class Question {
    private String questionText, optionA, optionB, optionC, optionD;
    private char correctAnswer;

    public Question(String q, String a, String b, String c, String d, char correct) {
        this.questionText = q; this.optionA = a; this.optionB = b;
        this.optionC = c; this.optionD = d; this.correctAnswer = correct;
    }

    public String getQuestionText() { return questionText; }
    public String getOptionA() { return optionA; }
    public String getOptionB() { return optionB; }
    public String getOptionC() { return optionC; }
    public String getOptionD() { return optionD; }
    public char getCorrectAnswer() { return correctAnswer; }
}