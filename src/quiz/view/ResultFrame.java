package quiz.view;
import quiz.controller.AppController;
import quiz.model.Result;
import quiz.service.QuizService;
import quiz.util.*;
import quiz.components.*;
import javax.swing.*;
import java.awt.*;

public class ResultFrame extends JFrame {

    public ResultFrame(AppController controller, QuizService quizService, Result result) {
        setTitle("Quiz Results - " + Constants.APP_TITLE);
        setSize(850, 650); // Match the quiz frame size
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 1. Base Gradient Background
        GradientPanel bgPanel = new GradientPanel();
        bgPanel.setLayout(new GridBagLayout()); // Used to center the card perfectly

        // 2. Floating White Card
        RoundedPanel card = new RoundedPanel(Theme.CARD_BG);
        card.setPreferredSize(new Dimension(550, 500));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        // 3. Title & Student Info
        JLabel title = new JLabel("Examination Results");
        title.setFont(Theme.FONT_TITLE);
        title.setForeground(Theme.TEXT_DARK);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel studentInfo = new JLabel("Student: " + quizService.getStudent().getName() + " (" + quizService.getStudent().getStudentId() + ")");
        studentInfo.setFont(Theme.FONT_REGULAR);
        studentInfo.setForeground(Theme.TEXT_MUTED);
        studentInfo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // 4. Huge Percentage Display (Color Coded)
        JLabel percentageLabel = new JLabel(String.format("%.2f%%", result.percentage));
        percentageLabel.setFont(new Font("Segoe UI", Font.BOLD, 54));
        percentageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Change color based on pass/fail
        if (result.percentage >= 50) {
            percentageLabel.setForeground(Theme.SUCCESS); // Green
        } else {
            percentageLabel.setForeground(Theme.DANGER);  // Red
        }

        // 5. Statistics Grid (Score, Grade, Correct, Wrong, etc.)
        JPanel statsPanel = new JPanel(new GridLayout(3, 2, 20, 20));
        statsPanel.setOpaque(false); // Make transparent to show card background
        statsPanel.setMaximumSize(new Dimension(450, 150));

        // Add formatted stats using a helper method (HTML formatting for styling)
        statsPanel.add(createStatLabel("Total Score:", result.correctAnswers + " / " + result.totalQuestions, "#333333"));
        statsPanel.add(createStatLabel("Final Grade:", result.grade, (result.percentage >= 50) ? "#28a745" : "#dc3545"));
        statsPanel.add(createStatLabel("✔ Correct:", String.valueOf(result.correctAnswers), "#28a745"));
        statsPanel.add(createStatLabel("❌ Wrong:", String.valueOf(result.wrongAnswers), "#dc3545"));
        statsPanel.add(createStatLabel("⚪ Skipped:", String.valueOf(result.skippedQuestions), "#6c757d"));
        statsPanel.add(createStatLabel("⏱ Time Taken:", result.timeTaken + " Sec", "#17a2b8"));

        // 6. Action Buttons
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        btnPanel.setOpaque(false);

        RoundedButton reviewBtn = new RoundedButton("Review Answers");
        RoundedButton exitBtn = new RoundedButton("Exit Application");
        exitBtn.setBackground(Theme.DANGER);

        reviewBtn.addActionListener(e -> controller.showReview(this));
        exitBtn.addActionListener(e -> controller.exitApp());

        btnPanel.add(reviewBtn);
        btnPanel.add(exitBtn);

        // 7. Assemble the Card
        card.add(title);
        card.add(Box.createVerticalStrut(5));
        card.add(studentInfo);
        card.add(Box.createVerticalStrut(25));
        card.add(percentageLabel);
        card.add(Box.createVerticalStrut(30));
        card.add(statsPanel);
        card.add(Box.createVerticalStrut(30));
        card.add(btnPanel);

        // 8. Add to Frame
        bgPanel.add(card);
        setContentPane(bgPanel);
    }

    // Helper method to create beautiful two-tone labels using HTML
    private JLabel createStatLabel(String title, String value, String hexColor) {
        String htmlText = "<html><span style='font-family: Segoe UI; font-size: 14px; color: #6c757d;'>" + title
                + "</span> <b style='font-family: Segoe UI; font-size: 16px; color: " + hexColor + ";'>"
                + value + "</b></html>";
        JLabel label = new JLabel(htmlText);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // Add a subtle border to each stat box
        label.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(230, 230, 230), 1, true),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        return label;
    }
}