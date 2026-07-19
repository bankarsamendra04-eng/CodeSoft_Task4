package quiz.controller;
import quiz.view.*;
import quiz.model.*;
import quiz.service.QuizService;
import javax.swing.*;

public class AppController {
    private QuizService quizService;

    public AppController() {
        quizService = new QuizService();
    }

    public void startApp() { new SplashScreen(this).setVisible(true); }

    public void showLogin() { new LoginFrame(this).setVisible(true); }

    public void loginUser(String name, String id, JFrame currentFrame) {
        quizService.setStudent(new Student(name, id));
        currentFrame.dispose();
        new DashboardFrame(this).setVisible(true);
    }

    // UPDATED: Now takes numberOfQuestions
    public void startQuiz(JFrame currentFrame, int numberOfQuestions) {
        quizService.initializeQuiz(numberOfQuestions);
        currentFrame.dispose();
        new QuizFrame(this, quizService).setVisible(true);
    }

    public void finishQuiz(JFrame currentFrame) {
        currentFrame.dispose();
        Result result = quizService.calculateResult();
        new ResultFrame(this, quizService, result).setVisible(true);
    }

    public void showReview(JFrame currentFrame) {
        currentFrame.dispose();
        new ReviewFrame(this, quizService).setVisible(true);
    }

    public void exitApp() { System.exit(0); }
}