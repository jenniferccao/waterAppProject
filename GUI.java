import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener{
    User person;
    JButton[] activities;
    public GUI(User p) {
        super("waterAppProject");
        person = p;
    }

    public void home() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 812);

        this.activities();

        JPanel logo = new JPanel();
        JLabel logoIcon = new JLabel(new ImageIcon("images/logo.png"));
        logo.add(logoIcon);
        logo.setBorder(new EmptyBorder(5,5,5,5));
        this.getContentPane().add(BorderLayout.SOUTH, logo);
        this.setVisible(true);
    }

    public void activities() {
        JPanel actPanel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(3,3,5,5);

        double[] data = Projections.getData();
        String[] dataNames = Projections.getDataNames();
        activities = new JButton[Projections.getNumActivities()];

        JLabel desc = new JLabel("Log a new activity");
        desc.setFont(new Font("Arial", Font.PLAIN, 14));
        c.gridx = 0;
        c.gridy = 0;
        actPanel.add(desc);
        for (int i = 0; i < Projections.getNumActivities(); i++) {
            activities[i] = new JButton(dataNames[i]);
            activities[i].addActionListener(this);

            c.gridx = 0;
            c.gridy = i + 1;
            actPanel.add(activities[i], c);
        }

        this.getContentPane().add(actPanel);
        this.setVisible(true);
    }

    public void logActivity(double activity) {
        int mins;
        int secs;
        int freq;

        for (int i = 0; i < Projections.getNumActivities(); i++) {
            if (Projections.getData()[i] == activity) {
                if (i == 0) { //bath
                    String strMins = JOptionPane.showInputDialog(this,
                            "Mins:", null);
                    mins = Integer.parseInt(strMins);

                    String strSecs = JOptionPane.showInputDialog(this,
                            "Secs:", null);
                    secs = Integer.parseInt(strSecs);

                    Projections.calculateShower(mins, secs);
                } else if (i == 1) { //hand wash
                    String strMins = JOptionPane.showInputDialog(this,
                            "Mins:", null);
                    mins = Integer.parseInt(strMins);

                    String strSecs = JOptionPane.showInputDialog(this,
                            "Secs:", null);
                    secs = Integer.parseInt(strSecs);

                    Projections.calculateHandWashing(mins, secs);
                } else if (i == 2) { //dish wash
                    String strMins = JOptionPane.showInputDialog(this,
                            "Mins:", null);
                    mins = Integer.parseInt(strMins);

                    String strSecs = JOptionPane.showInputDialog(this,
                            "Secs:", null);
                    secs = Integer.parseInt(strSecs);

                    Projections.calculateDishWashing(mins, secs);
                } else if (i == 3) { //dish wash
                    String strMins = JOptionPane.showInputDialog(this,
                            "Mins:", null);
                    mins = Integer.parseInt(strMins);

                    String strSecs = JOptionPane.showInputDialog(this,
                            "Secs:", null);
                    secs = Integer.parseInt(strSecs);

                    Projections.calculateToothBrushing(mins, secs);
                } else if (i == 4) { //baths
                    String strFreq = JOptionPane.showInputDialog(this,
                            "Frequency:", null);
                    freq = Integer.parseInt(strFreq);

                    Projections.calculateBath(freq);
                } else if (i == 5) { //dishwasher
                    String strFreq = JOptionPane.showInputDialog(this,
                            "Frequency:", null);
                    freq = Integer.parseInt(strFreq);

                    Projections.calculateDishwasher(freq);
                } else if (i == 7) { //food prep
                    String strFreq = JOptionPane.showInputDialog(this,
                            "Frequency:", null);
                    freq = Integer.parseInt(strFreq);

                    Projections.calculateFoodPrep(freq);
                } else if (i == 6) { //toilet
                    String strFreq = JOptionPane.showInputDialog(this,
                            "Frequency:", null);
                    freq = Integer.parseInt(strFreq);

                    Projections.calculateToilet(freq);
                } else if (i == 8) { //laundry
                    String strFreq = JOptionPane.showInputDialog(this,
                            "Frequency:", null);
                    freq = Integer.parseInt(strFreq);

                    Projections.calculateLaundry(freq);
                }
            }
        }

        total();
    }


    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < Projections.getNumActivities(); i++) {
            if (e.getSource() == activities[i]) {
                logActivity(Projections.getData()[i]);
            }
        }

    }

    public void total () {
        JPanel totalDisplay = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        totalDisplay.setBorder(new EmptyBorder(50, 20, 10, 20));

        JLabel txt = new JLabel("Litres Consumed:");
        JLabel display = new JLabel(String.format("%.2f", Projections.getTotalConsumed()));
        display.setFont(new Font("Arial", Font.BOLD, 30));
        display.setForeground(Color.decode("#213D87"));
        txt.setFont(new Font("Arial", Font.PLAIN, 15));



        c.gridx = 0;
        c.gridy = 0;
        totalDisplay.add(txt, c);
        c.gridy = 1;
        totalDisplay.add(display, c);

        this.getContentPane().add(BorderLayout.NORTH, totalDisplay);
        this.screenRefresh();
    }

    public void screenRefresh() {
        //this.setVisible(false);
        this.setVisible(true);
    }

}
