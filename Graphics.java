import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Graphics extends JFrame implements ActionListener {
    private JButton addButton;
    private JPanel mainPanel;
    private JPanel textPanel;
    private JLabel welcomeLabel;
    private String name = "John Doe";
    private JPanel rectPanel1;
    private JPanel rectPanel2;

    public Graphics() {
        // set up main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // set up text panel
        textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(Color.white);
        textPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // set up welcome label
        welcomeLabel = new JLabel("Welcome, \n" + name);
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        textPanel.add(welcomeLabel);

        // set up rectangles
        rectPanel1 = new JPanel();
        rectPanel1.setBackground(Color.gray);
        rectPanel1.setPreferredSize(new Dimension(350, 200));
        textPanel.add(rectPanel1);

        rectPanel2 = new JPanel();
        rectPanel2.setBackground(Color.darkGray);
        rectPanel2.setPreferredSize(new Dimension(350, 200));
        textPanel.add(rectPanel2);

        mainPanel.add(textPanel);

        // set up add button
        addButton = new JButton("+");
        addButton.addActionListener(this);
        addButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(addButton);

        // set up frame
        setTitle("iPhone XR GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // switch to new screen
            JOptionPane.showMessageDialog(this, "Switching to new screen...");
        }
    }

    public static void main(String[] args) {
        new Graphics();
    }
}
