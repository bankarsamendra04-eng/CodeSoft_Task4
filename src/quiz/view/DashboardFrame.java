package quiz.view;
import quiz.controller.AppController;
import quiz.util.*;
import quiz.components.*;
import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {
    public DashboardFrame(AppController controller) {
        setTitle("Dashboard - " + Constants.APP_TITLE);
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GradientPanel bgPanel = new GradientPanel();
        bgPanel.setLayout(new GridBagLayout());

        RoundedPanel card = new RoundedPanel(Theme.CARD_BG);
        card.setPreferredSize(new Dimension(500, 450));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));

        JLabel welcome = new JLabel("Welcome to the Quiz");
        welcome.setFont(Theme.FONT_TITLE);
        welcome.setForeground(Theme.TEXT_DARK);
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        // CHANGED: Instructions now say 1 minute
        JLabel instructions = new JLabel("<html><center><br><b>Instructions:</b><br><br>• You have 1 minute per question.<br>• Unanswered questions are marked skipped.<br>• Results are calculated immediately.<br></center></html>");
        instructions.setFont(Theme.FONT_REGULAR);
        instructions.setForeground(Theme.TEXT_MUTED);
        instructions.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel selectPanel = new JPanel(new FlowLayout());
        selectPanel.setOpaque(false);
        JLabel selectLbl = new JLabel("Select Questions: ");
        selectLbl.setFont(Theme.FONT_BOLD);

        Integer[] options = {5, 10, 15, 30, 50};
        JComboBox<Integer> questionCountBox = new JComboBox<>(options);
        questionCountBox.setFont(Theme.FONT_REGULAR);
        questionCountBox.setFocusable(false); // Fixes the ugly dotted selection box
        questionCountBox.setBackground(Color.WHITE);

        selectPanel.add(selectLbl);
        selectPanel.add(questionCountBox);

        RoundedButton startBtn = new RoundedButton("Start Assessment");
        startBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        startBtn.addActionListener(e -> {
            int selectedCount = (Integer) questionCountBox.getSelectedItem();
            controller.startQuiz(this, selectedCount);
        });

        card.add(welcome);
        card.add(instructions);
        card.add(Box.createVerticalStrut(20));
        card.add(selectPanel);
        card.add(Box.createVerticalStrut(30));
        card.add(startBtn);

        bgPanel.add(card);
        setContentPane(bgPanel);
    }
}