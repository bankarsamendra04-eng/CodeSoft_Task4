package quiz.components;
import quiz.util.Theme;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RoundedButton extends JButton {
    private Color hoverBackgroundColor;
    private Color pressedBackgroundColor;

    public RoundedButton(String text) {
        super(text);
        super.setContentAreaFilled(false);
        setFocusPainted(false);
        setFont(Theme.FONT_REGULAR);
        setForeground(Theme.TEXT_LIGHT);
        setBackground(Theme.PRIMARY);
        this.hoverBackgroundColor = Theme.PRIMARY.brighter();
        this.pressedBackgroundColor = Theme.PRIMARY.darker();
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { setBackground(hoverBackgroundColor); }
            @Override
            public void mouseExited(MouseEvent e) { setBackground(Theme.PRIMARY); }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (getModel().isPressed()) {
            g2.setColor(pressedBackgroundColor);
        } else {
            g2.setColor(getBackground());
        }
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponent(g2);
        g2.dispose();
    }
}