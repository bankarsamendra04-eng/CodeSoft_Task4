package quiz.components;
import quiz.util.Theme;
import javax.swing.*;
import java.awt.*;

public class GradientPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        GradientPaint gp = new GradientPaint(0, 0, Theme.GRADIENT_START, 0, getHeight(), Theme.GRADIENT_END);
        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}