import java.awt.*;
import javax.swing.*;

public class start {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Start Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(new ImageIcon("b1.gif").getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(new BorderLayout());

        JLabel title = new JLabel("Alien Clicker");
        title.setFont(new Font("monospaced", Font.ROMAN_BASELINE, 68));
        title.setForeground(Color.white);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); 
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton startButton = new JButton("Start");
        styleButton(startButton);

        JButton quitButton = new JButton("Exit game");
        styleButton(quitButton);

        startButton.addActionListener(e -> {
            new levels().main(args);
            frame.dispose();

        });

        quitButton.addActionListener(e -> {
            System.exit(0);
        });

        buttonPanel.add(Box.createVerticalGlue()); 
        buttonPanel.add(startButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20))); 
        buttonPanel.add(quitButton);
        buttonPanel.add(Box.createVerticalGlue()); 

        panel.add(title, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 24));
        button.setForeground(Color.WHITE);
        button.setContentAreaFilled(false); 
        button.setBorderPainted(false); 
        button.setFocusPainted(false); 
        button.setAlignmentX(Component.CENTER_ALIGNMENT); 
    }
}
