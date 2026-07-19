package quiz.components;
import quiz.util.Theme;
import javax.swing.*;
import java.awt.*;

public class HintTextField extends JTextField {
    private String hint;

    public HintTextField(String hint) {
        super();
        this.hint = hint;
        setFont(Theme.FONT_REGULAR);
        setForeground(Theme.TEXT_DARK);
        // Add some padding inside the text box so text doesn't touch the edges
        setBorder(BorderFactory.createCompoundBorder(
                getBorder(),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the hint text if the text field is completely empty
        if (getText().isEmpty()) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Theme.TEXT_MUTED); // Grey color
            g2.setFont(getFont().deriveFont(Font.ITALIC)); // Make hint italic

            // Vertically center the hint text
            FontMetrics fm = g2.getFontMetrics();
            int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();

            g2.drawString(hint, 12, y); // 12 matches the left padding
            g2.dispose();
        }
    }
}