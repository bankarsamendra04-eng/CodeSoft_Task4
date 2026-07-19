package quiz.view;
import quiz.controller.AppController;
import quiz.util.*;
import quiz.components.*;
import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    public LoginFrame(AppController controller) {
        setTitle("Login - " + Constants.APP_TITLE);
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        GradientPanel bgPanel = new GradientPanel();
        bgPanel.setLayout(new GridBagLayout()); // Centers the card on the screen

        RoundedPanel card = new RoundedPanel(Theme.CARD_BG);
        card.setPreferredSize(new Dimension(420, 480)); // Perfect card proportions
        card.setLayout(new GridBagLayout()); // Gives absolute control over form alignment

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Force components to stretch horizontally
        gbc.weightx = 1.0;

        // 1. Centered Title
        JLabel title = new JLabel("Student Login", SwingConstants.CENTER);
        title.setFont(Theme.FONT_TITLE);
        title.setForeground(Theme.TEXT_DARK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(40, 40, 40, 40); // Top, Left, Bottom, Right padding
        card.add(title, gbc);

        // 2. Full Name Label
        JLabel nameLbl = new JLabel("Full Name:");
        nameLbl.setFont(Theme.FONT_BOLD);
        nameLbl.setForeground(Theme.TEXT_DARK);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 40, 5, 40); // Space below label
        card.add(nameLbl, gbc);

        // 3. Full Name Field
        HintTextField nameField = new HintTextField("Enter your full name...");
        nameField.setPreferredSize(new Dimension(0, 45)); // Modern, tall text fields
        nameField.setFont(Theme.FONT_REGULAR);
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 40, 20, 40); // Space below text field
        card.add(nameField, gbc);

        // 4. Student ID Label
        JLabel idLbl = new JLabel("Student ID:");
        idLbl.setFont(Theme.FONT_BOLD);
        idLbl.setForeground(Theme.TEXT_DARK);
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 40, 5, 40);
        card.add(idLbl, gbc);

        // 5. Student ID Field
        HintTextField idField = new HintTextField("Enter numeric Student ID...");
        idField.setPreferredSize(new Dimension(0, 45));
        idField.setFont(Theme.FONT_REGULAR);
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 40, 40, 40);
        card.add(idField, gbc);

        // 6. Full-Width Login Button
        RoundedButton loginBtn = new RoundedButton("Login to System");
        loginBtn.setPreferredSize(new Dimension(0, 45)); // Matches text box height
        loginBtn.setFont(Theme.FONT_BOLD);
        gbc.gridy = 5;
        gbc.insets = new Insets(0, 40, 40, 40); // Bottom padding for card

        loginBtn.addActionListener(e -> {
            String name = nameField.getText();
            String id = idField.getText();
            if(Validator.isEmpty(name) || Validator.isEmpty(id)) {
                JOptionPane.showMessageDialog(this, "Fields cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!Validator.isNumeric(id)) {
                JOptionPane.showMessageDialog(this, "Student ID must be numeric!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                controller.loginUser(name, id, this);
            }
        });

        card.add(loginBtn, gbc);

        bgPanel.add(card);
        setContentPane(bgPanel);
    }
}