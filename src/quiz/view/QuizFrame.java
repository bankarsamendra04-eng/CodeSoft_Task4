package quiz.view;
import quiz.controller.AppController;
import quiz.model.Question;
import quiz.service.*;
import quiz.util.*;
import quiz.components.*;
import javax.swing.*;
import java.awt.*;

public class QuizFrame extends JFrame implements TimerService.TimerListener {
    private AppController controller;
    private QuizService quizService;
    private TimerService timerService;

    private JLabel qNumLabel, timerLabel;
    private JTextArea qTextArea;
    private JRadioButton optA, optB, optC, optD;
    private ButtonGroup bg;
    private RoundedButton nextBtn, prevBtn, submitBtn;

    public QuizFrame(AppController controller, QuizService quizService) {
        this.controller = controller;
        this.quizService = quizService;

        setTitle("Examination in Progress");
        setSize(850, 650); // Slightly larger for better readability
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        initComponents();
        loadQuestionData();

        timerService = new TimerService(Constants.TIME_PER_QUESTION_SEC, this);
        timerService.start();
        new Timer(1000, e -> quizService.incrementTimeTaken()).start();
    }

    private void initComponents() {
        GradientPanel bgPanel = new GradientPanel();
        bgPanel.setLayout(new BorderLayout(20, 20));
        bgPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        // Header Panel (Transparent)
        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);
        qNumLabel = new JLabel("Question 1 / 10");
        qNumLabel.setFont(Theme.FONT_HEADER);
        qNumLabel.setForeground(Theme.TEXT_LIGHT);

        timerLabel = new JLabel("Time: 01:00");
        timerLabel.setFont(Theme.FONT_TITLE);
        timerLabel.setForeground(Theme.TEXT_LIGHT);

        header.add(qNumLabel, BorderLayout.WEST);
        header.add(timerLabel, BorderLayout.EAST);
        bgPanel.add(header, BorderLayout.NORTH);

        // Center Card (The Question Area)
        RoundedPanel card = new RoundedPanel(Theme.CARD_BG);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createEmptyBorder(40, 50, 40, 50));

        qTextArea = new JTextArea();
        qTextArea.setFont(Theme.FONT_HEADER);
        qTextArea.setForeground(Theme.TEXT_DARK);
        qTextArea.setLineWrap(true);
        qTextArea.setWrapStyleWord(true);
        qTextArea.setEditable(false);
        qTextArea.setOpaque(false);
        qTextArea.setFocusable(false);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 10, 15));
        optionsPanel.setOpaque(false);

        optA = new JRadioButton(); optB = new JRadioButton();
        optC = new JRadioButton(); optD = new JRadioButton();

        Font optFont = Theme.FONT_REGULAR;
        JRadioButton[] opts = {optA, optB, optC, optD};
        for (JRadioButton opt : opts) {
            opt.setFont(optFont);
            opt.setOpaque(false);
            opt.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        bg = new ButtonGroup();
        bg.add(optA); bg.add(optB); bg.add(optC); bg.add(optD);

        optionsPanel.add(optA); optionsPanel.add(optB);
        optionsPanel.add(optC); optionsPanel.add(optD);

        card.add(qTextArea);
        card.add(Box.createVerticalStrut(30));
        card.add(optionsPanel);
        bgPanel.add(card, BorderLayout.CENTER);

        // Footer Navigation
        JPanel footer = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        footer.setOpaque(false);

        prevBtn = new RoundedButton("← Previous");
        nextBtn = new RoundedButton("Next →");
        submitBtn = new RoundedButton("Submit Quiz");
        submitBtn.setBackground(Theme.DANGER);

        prevBtn.addActionListener(e -> handleNavigation(false));
        nextBtn.addActionListener(e -> handleNavigation(true));
        submitBtn.addActionListener(e -> finishQuiz());

        footer.add(prevBtn); footer.add(nextBtn); footer.add(submitBtn);
        bgPanel.add(footer, BorderLayout.SOUTH);

        setContentPane(bgPanel);
    }

    private void loadQuestionData() {
        Question q = quizService.getCurrentQuestion();
        qNumLabel.setText("Question " + (quizService.getCurrentIndex() + 1) + " of " + quizService.getTotalQuestions());
        qTextArea.setText(q.getQuestionText());
        optA.setText(q.getOptionA()); optB.setText(q.getOptionB());
        optC.setText(q.getOptionC()); optD.setText(q.getOptionD());

        optA.setActionCommand("A"); optB.setActionCommand("B");
        optC.setActionCommand("C"); optD.setActionCommand("D");

        bg.clearSelection();
        char saved = quizService.getSavedAnswer();
        if(saved == 'A') optA.setSelected(true);
        if(saved == 'B') optB.setSelected(true);
        if(saved == 'C') optC.setSelected(true);
        if(saved == 'D') optD.setSelected(true);

        prevBtn.setEnabled(quizService.getCurrentIndex() > 0);

        // Change "Next" to "Finish" on the last question
        if (quizService.getCurrentIndex() == quizService.getTotalQuestions() - 1) {
            nextBtn.setEnabled(false);
        } else {
            nextBtn.setEnabled(true);
        }
    }

    // ... [saveCurrentAnswer, handleNavigation, finishQuiz, onTick, onTimeUp remain the same as before]

    private void saveCurrentAnswer() {
        ButtonModel sel = bg.getSelection();
        if (sel != null) {
            quizService.saveAnswer(sel.getActionCommand().charAt(0));
        } else {
            quizService.saveAnswer(' ');
        }
    }

    private void handleNavigation(boolean isNext) {
        saveCurrentAnswer();
        if (isNext) quizService.nextQuestion();
        else quizService.previousQuestion();
        loadQuestionData();
        timerService.reset(Constants.TIME_PER_QUESTION_SEC);
    }

    private void finishQuiz() {
        saveCurrentAnswer();
        timerService.stop();
        controller.finishQuiz(this);
    }

    @Override
    public void onTick(int secondsLeft) {
        // Formats the seconds into Minutes:Seconds properly (e.g., 01:00 or 00:59)
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft % 60;

        timerLabel.setText(String.format("Time: %02d:%02d", minutes, seconds));

        if (secondsLeft <= 10) { // Warning color at 10 seconds remaining
            timerLabel.setForeground(Theme.DANGER);
        } else {
            timerLabel.setForeground(Theme.TEXT_LIGHT);
        }
    }

    @Override
    public void onTimeUp() {
        saveCurrentAnswer();
        if (quizService.getCurrentIndex() == quizService.getTotalQuestions() - 1) {
            finishQuiz();
        } else {
            quizService.nextQuestion();
            loadQuestionData();
            timerService.reset(Constants.TIME_PER_QUESTION_SEC);
        }
    }
}