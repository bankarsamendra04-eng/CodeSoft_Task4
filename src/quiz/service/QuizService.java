package quiz.service;
import quiz.model.*;
import quiz.repository.QuestionRepository;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class QuizService {
    private List<Question> questions;
    private char[] userAnswers;
    private int currentQuestionIndex = 0;
    private Student student;
    private int totalTimeTaken = 0;

    // Call this before starting the quiz
    public void initializeQuiz(int numQuestions) {
        List<Question> allQuestions = new QuestionRepository().loadQuestions();
        Collections.shuffle(allQuestions); // Randomize questions

        // Prevent array out of bounds if user asks for more questions than we have
        int limit = Math.min(numQuestions, allQuestions.size());
        this.questions = new ArrayList<>(allQuestions.subList(0, limit));

        this.userAnswers = new char[this.questions.size()];
        for (int i = 0; i < userAnswers.length; i++) {
            userAnswers[i] = ' '; // Empty = skipped
        }
        this.currentQuestionIndex = 0;
        this.totalTimeTaken = 0;
    }

    public void setStudent(Student s) { this.student = s; }
    public Student getStudent() { return student; }
    public List<Question> getQuestions() { return questions; }
    public Question getCurrentQuestion() { return questions.get(currentQuestionIndex); }
    public int getCurrentIndex() { return currentQuestionIndex; }
    public int getTotalQuestions() { return questions != null ? questions.size() : 0; }
    public void incrementTimeTaken() { totalTimeTaken++; }

    public void saveAnswer(char ans) { userAnswers[currentQuestionIndex] = ans; }
    public char getSavedAnswer() { return userAnswers[currentQuestionIndex]; }

    public boolean nextQuestion() {
        if (currentQuestionIndex < questions.size() - 1) {
            currentQuestionIndex++;
            return true;
        }
        return false;
    }

    public boolean previousQuestion() {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            return true;
        }
        return false;
    }

    public Result calculateResult() {
        int correct = 0, wrong = 0, skipped = 0;
        for (int i = 0; i < questions.size(); i++) {
            if (userAnswers[i] == ' ') skipped++;
            else if (userAnswers[i] == questions.get(i).getCorrectAnswer()) correct++;
            else wrong++;
        }
        return new Result(questions.size(), correct, wrong, skipped, totalTimeTaken);
    }

    public char[] getUserAnswers() { return userAnswers; }
}