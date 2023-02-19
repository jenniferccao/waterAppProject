import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Display extends JFrame implements ActionListener {
    //declare instance variables
    User person;
    JButton addButton;
    JButton activity1;
    JPanel panelT;
    JPanel panelB;
    JPanel panelC1;
    JPanel addPanel;
    JPanel minBackground;

    private int screen;
    public Display(User p) {
        super("waterAppProject");
        person = p;
        screen = 1;
    }

    public void home() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 812);

        //TOP
        panelT = new JPanel(new BorderLayout());
        panelT.setSize(375, 300);

        //create new labels
        JLabel welcome1 = new JLabel("Welcome,");
        JLabel welcome2 = new JLabel(person.getName() + "            ");
        JLabel welcome3 = new JLabel("How can I lose if I'm already chose?");
        welcome1.setFont(new Font("Arial", Font.PLAIN, 40));
        welcome2.setFont(new Font("Arial", Font.BOLD, 40));
        welcome3.setFont(new Font("Arial", Font.PLAIN, 12));

        panelT.add(welcome1, BorderLayout.NORTH);
        panelT.add(welcome2, BorderLayout.CENTER);
        panelT.add(welcome3, BorderLayout.SOUTH);



        panelT.setBorder(new EmptyBorder(50, 20, 10, 20));

        //CENTER
        panelC1 = new JPanel();
        JLabel consumption = new JLabel("Daily Consumption " + Projections.getTotalConsumed(), JLabel.LEFT);
        JLabel weekHighlight = new JLabel("Your week", JLabel.LEFT);
        consumption.setIcon(new ImageIcon("images/rect1.png"));
        weekHighlight.setIcon(new ImageIcon("images/rect2.png"));


        panelC1.add(consumption);
        panelC1.add(weekHighlight);


        //BOTTOM
        panelB = new JPanel();
        addButton = new JButton("+");
        addButton.addActionListener(this);
        panelB.add(addButton); // Components Added using Flow Layout

        //ADD TO JFRAME
        this.getContentPane().add(BorderLayout.NORTH, panelT);
        this.getContentPane().add(BorderLayout.CENTER, panelC1);
        this.getContentPane().add(BorderLayout.SOUTH, panelB);

        this.setVisible(true);
    }

    public void addScreen() {
        addPanel = new JPanel(new GridBagLayout());
        addPanel.setPreferredSize(new Dimension(375, 812));
        addPanel.setBackground(Color.getColor("#FFFFFF"));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(3,3,5,5);

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        JLabel title = new JLabel("Log water");
        addPanel.add(title, c);

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 1;
        activity1 = new JButton("Act1");
        activity1.addActionListener(this);
        addPanel.add(activity1, c);


        this.getContentPane().add(BorderLayout.CENTER, addPanel);
        this.screenRefresh();

    }

    public void minuteInput() {
        minBackground = new JPanel(new GridBagLayout());
        minBackground.setPreferredSize(new Dimension(375, 812));
        minBackground.setBackground(Color.getColor("#FFFFFF"));
        System.out.print("working");
        this.getContentPane().add(BorderLayout.CENTER, minBackground);
        this.screenRefresh();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            screen = 2;
            this.remove(panelT);
            this.remove(panelC1);
            this.remove(panelB);
            this.addScreen();
        }

        if (e.getSource() == activity1) {
            this.remove(addPanel);
            minuteInput();
        }
    }

    public void screenRefresh() {
        this.setVisible(false);
        this.setVisible(true);
    }

}
