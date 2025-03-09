import java.awt.*;
import javax.swing.*;



public class levels {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Levels");
        
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
        JLabel title = new JLabel("Difficulty Levels");
        title.setFont(new Font("monospaced", Font.ITALIC, 58));
        title.setForeground(Color.white);
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 20)); 
        buttonPanel.setOpaque(false); 
        JButton easyButton = new JButton("Easy");
        JButton mediumButton = new JButton("Medium");
        JButton hardButton = new JButton("Hard");

        // Style buttons
        styleButton(easyButton);
        styleButton(mediumButton);
        styleButton(hardButton);
        space sp=new space();

        // Add action listeners
        easyButton.addActionListener(e -> sp.main(1200));
        easyButton.addActionListener(e -> frame.dispose());

        mediumButton.addActionListener(e -> sp.main(800));
        mediumButton.addActionListener(e -> frame.dispose());

        hardButton.addActionListener(e -> sp.main(600));
        hardButton.addActionListener(e -> frame.dispose());

        buttonPanel.add(easyButton);
        buttonPanel.add(mediumButton);
        buttonPanel.add(hardButton);

        panel.add(title, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);

        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void styleButton(JButton button) {
        button.setFont(new Font("Monospaced", Font.BOLD, 36));
        button.setForeground(Color.WHITE);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false); 
    }
}


