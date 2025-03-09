import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.*;
import javax.swing.*;

public class space {

    public static void main(int x) {
        AimerFrame frame = new AimerFrame(x);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class AimerFrame extends JFrame {
    private JButton button;
    private CounterPanel counterPanel;
    private Random rand;
    private Timer moveButtonTimer;
    private Timer gameTimer; 

    public AimerFrame(int x) {
        setTitle("Alien Clicker");
        setSize(800, 600);
        setLayout(null);

        ImageIcon backgroundImage = new ImageIcon("b2.gif");
        JLabel backgroundLabel = new JLabel();
        backgroundLabel.setIcon(new ImageIcon(backgroundImage.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT)));
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        setContentPane(backgroundLabel);
        backgroundLabel.setLayout(null);

        // Button setup
        ImageIcon imgg = new ImageIcon("ali.png");
        ImageIcon buttonIcon = imgg;
        button = new JButton(buttonIcon);
        button.setBounds(300, 250, buttonIcon.getIconWidth() - 10, buttonIcon.getIconHeight() - 10);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        backgroundLabel.add(button);

        // CounterPanel with timer
        counterPanel = new CounterPanel();
        counterPanel.setBounds(300, 20, 200, 80);
        backgroundLabel.add(counterPanel);

        rand = new Random();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counterPanel.incrementCounter();
                moveButtonRandomly();
                moveButtonTimer.restart();
            }
        });

        moveButtonTimer = new Timer(x, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveButtonRandomly();
            }
        });
        moveButtonTimer.start();

        gameTimer = new Timer(1000, new ActionListener() {
            int count = 30;
            start s = new start();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count > 0) {
                    count--;
                    counterPanel.updateTimer("00:" + (count < 10 ? "0" + count : count));
                } else {
                    ((Timer) e.getSource()).stop();
                    counterPanel.updateTimer("Time's up!");
                    JOptionPane.showMessageDialog(null, "Your Score is " + counterPanel.counter + ",  GG!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    s.main(null);
                    dispose();
                }
            }
        });
        gameTimer.start();
    }

    private void moveButtonRandomly() {
        int x = rand.nextInt(getWidth() - 250);
        int y = rand.nextInt(getHeight() - 100);
        button.setBounds(x, y, 40, 40);
    }
}

class CounterPanel extends JPanel {
    public int counter;
    private JLabel counterLabel;
    private JLabel timerLabel;

    public CounterPanel() {
        counter = 0;
        counterLabel = new JLabel("Counter: " + counter);
        counterLabel.setForeground(Color.WHITE);
        counterLabel.setFont(new Font("Monospaced", Font.BOLD, 20));

        timerLabel = new JLabel("00:30");
        timerLabel.setForeground(Color.WHITE);
        timerLabel.setFont(new Font("Monospaced", Font.BOLD, 20));

        setOpaque(false);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        add(counterLabel, gbc);
        gbc.gridy = 1;
        add(timerLabel, gbc);
    }

    public void incrementCounter() {
        counter++;
        counterLabel.setText("Counter: " + counter);
        try {
            File soundFile = new File("s2.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    public void updateTimer(String time) {
        timerLabel.setText(time);
    }
}

class ImagPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(new ImageIcon("b2.gif").getImage(), 0, 0, getWidth(), getHeight(), this);
    }
}
