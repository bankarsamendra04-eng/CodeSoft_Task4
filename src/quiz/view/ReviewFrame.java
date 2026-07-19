package quiz.view;
import quiz.controller.AppController;
import quiz.model.Question;
import quiz.service.QuizService;
import quiz.util.*;
import quiz.components.RoundedButton;
import javax.swing.*;
import java.awt.*;

public class ReviewFrame extends JFrame {
    public ReviewFrame(AppController controller, QuizService quizService) {
        setTitle("Review Answers");
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        char[] userAns = quizService.getUserAnswers();
        java.util.List<Question> questions = quizService.getQuestions();

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            JPanel item = new JPanel(new GridLayout(4, 1));
            item.setBorder(BorderFactory.createTitledBorder("Question " + (i+1)));

            JLabel qLbl = new JLabel(q.getQuestionText());
            JLabel yAns = new JLabel("Your Answer: " + (userAns[i] == ' ' ? "Skipped" : userAns[i]));
            JLabel cAns = new JLabel("Correct Answer: " + q.getCorrectAnswer());

            JLabel res = new JLabel();
            if(userAns[i] == ' ') { res.setText("⚪ Skipped"); res.setForeground(Color.GRAY); }
            else if(userAns[i] == q.getCorrectAnswer()) { res.setText("✔ Correct"); res.setForeground(Theme.SUCCESS); }
            else { res.setText("❌ Incorrect"); res.setForeground(Theme.DANGER); }

            item.add(qLbl); item.add(yAns); item.add(cAns); item.add(res);
            listPanel.add(item);
        }

        JScrollPane scroll = new JScrollPane(listPanel);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        add(scroll, BorderLayout.CENTER);

        JPanel footer = new JPanel();
        RoundedButton exitBtn = new RoundedButton("Exit");
        exitBtn.addActionListener(e -> controller.exitApp());
        footer.add(exitBtn);
        add(footer, BorderLayout.SOUTH);
    }
}