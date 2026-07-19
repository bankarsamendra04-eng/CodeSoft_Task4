package quiz.view;
import quiz.controller.AppController;
import quiz.util.*;
import quiz.components.GradientPanel;
import javax.swing.*;
import java.awt.*;

public class SplashScreen extends JWindow {
    public SplashScreen(AppController controller) {
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setLocationRelativeTo(null);

        // Uses the new attractive gradient background
        GradientPanel panel = new GradientPanel();
        panel.setLayout(new BorderLayout());

        // Add some padding around the edges
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JLabel title = new JLabel(Constants.APP_TITLE, SwingConstants.CENTER);
        title.setFont(Theme.FONT_TITLE);
        title.setForeground(Theme.TEXT_LIGHT);

        JLabel version = new JLabel(Constants.VERSION + " | " + Constants.DEVELOPER, SwingConstants.CENTER);
        // Changed FONT_SMALL to FONT_REGULAR to match the new Theme
        version.setFont(Theme.FONT_REGULAR);
        version.setForeground(Theme.TEXT_LIGHT);

        JProgressBar progressBar = new JProgressBar();
        progressBar.setForeground(Theme.SUCCESS);
        // Changed BACKGROUND to GRADIENT_END to match the new Theme
        progressBar.setBackground(Theme.GRADIENT_END);
        progressBar.setBorderPainted(false); // Makes the progress bar look flatter and modern
        progressBar.setPreferredSize(new Dimension(100, 10)); // Makes it a sleek thin line

        panel.add(title, BorderLayout.CENTER);
        panel.add(progressBar, BorderLayout.SOUTH);
        panel.add(version, BorderLayout.NORTH);

        add(panel);

        new Timer(30, e -> {
            int val = progressBar.getValue();
            if (val < 100) {
                progressBar.setValue(val + 2); // Slightly faster loading animation
            } else {
                ((Timer)e.getSource()).stop();
                dispose();
                controller.showLogin();
            }
        }).start();
    }
}