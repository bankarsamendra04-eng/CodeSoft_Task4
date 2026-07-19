package quiz.model;

public class Result {
    public int totalQuestions, correctAnswers, wrongAnswers, skippedQuestions;
    public double percentage;
    public String grade;
    public int timeTaken;

    public Result(int tq, int ca, int wa, int sq, int tt) {
        this.totalQuestions = tq;
        this.correctAnswers = ca;
        this.wrongAnswers = wa;
        this.skippedQuestions = sq;
        this.timeTaken = tt;
        this.percentage = ((double) ca / tq) * 100;
        this.grade = calculateGrade(this.percentage);
    }

    private String calculateGrade(double pct) {
        if (pct >= 90) return "A+";
        if (pct >= 80) return "A";
        if (pct >= 70) return "B";
        if (pct >= 60) return "C";
        if (pct >= 50) return "D";
        return "Fail";
    }
}