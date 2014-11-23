import javax.swing.ImageIcon;
import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NickCageGame {
    
    private String name;
    private int health;
    
    private int strength;
    private int intel;
    private int ballistics;
    private int melee;
    private int diplomacy;
    
    public JButton optionA;
    public JButton optionB;
    public JButton optionC;
    public JFrame mainFrame = new JFrame();
    
    private String choice;
    
    
    //inital dialog to start game and choose character
    public void gameSetup() {
        String[] option = {"Start"};
        ImageIcon icon = new ImageIcon("nickcage.jpeg");
        String m = "Nicolas Cage woke up and he knew the world had changed. He carefully climbed out "
            + "of bed and pulled the curtains away from the windows. Outside was Chaos. Reality an"
            + "d DisReality swirled into one.\n Things from his past clashed with things from his futur"
            + "e. But Cage was not scared.\n\n You See, Nicolas Cage isn�t just an Academy Award winning actor, " 
            +"He is also a Golden Globes winning actor.\n But more importantly he is from the Alien planet Cage. And being a Cagen, he holds the ability to become who he acts."
            + " Every Since acting in Knowing, he has known about this day, and after acting in various and extreme roles.... \n\n\n Nick Cage is prepared. "
            + "\nGet Nick Cage back to his home Planet, by getting him to his Ship";
        
        int result = JOptionPane.showOptionDialog(null, m, "Nick Of Cage", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, icon, option, option[0]);
        
        if (result >= 0 ) {
            String[] characters = {"Ghost Rider (Ghost Rider)", "Big Daddy (Kick-Ass)", "Gates (National Treasure)", "Castor (FaceOff)", "Poe (Con-Air)"};
            int c = JOptionPane.showOptionDialog(null, "Pick your character.", "Nick Of Cage", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, characters, characters[0]);
            
            if (c == 0) {
                name = "Ghost Rider";
                strength = 9;
                intel = 3;
                ballistics = 4;
                melee =8;
                diplomacy = 1;
            }
            if (c == 1) {
                name = "Big Daddy";
                strength = 4;
                intel = 9;
                ballistics = 2;
                melee =7;
                diplomacy = 3;
            }
            if (c == 2) {
                name = "Gates";
                strength = 2;
                intel = 8;
                ballistics = 3;
                melee = 3;
                diplomacy = 9;
            }
            if (c == 3) {
                name = "Castor";
                strength = 6;
                intel = 2;
                ballistics = 9;
                melee = 5 ;
                diplomacy = 4;
            }
            if (c == 4) {
                name = "Poe";
                strength = 5;
                intel = 2;
                ballistics = 2;
                melee = 9;
                diplomacy = 7;
            }
        }
        
    }
    
    //call method everytime to print gui and just pass step specific text as arguments
    @SuppressWarnings("deprecation")
    public void printGUI(String buttonAMessage, String buttonBMessage, String buttonCMessage, String textMessage) {
        
        mainFrame.setSize(700, 400);
        mainFrame.setTitle("Nick Of Cage");
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        
        String label = String.format("Role: %s \t\t         Health: %d", name, health);
        JLabel status = new JLabel(label);
        
        JButton optionA = new JButton(buttonAMessage);
        JButton optionB = new JButton(buttonBMessage);
        JButton optionC = new JButton(buttonCMessage);
        JLabel message = new JLabel(textMessage);
        
        
        
        optionA.addActionListener (
                                   new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = "A";
            }  
        }
        );
        optionB.addActionListener (
                                   new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = "B";
            }
        }
        );
        optionC.addActionListener (
                                   new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = "C";
            }
        }
        );
        
        
        //Text Panel;
        JPanel panel1 = new JPanel(new SpringLayout());
        panel1.setPreferredSize(new Dimension(305,20));
        panel1.setBackground(Color.GRAY);
        panel1.add(message);
        mainFrame.add(panel1, BorderLayout.WEST);
        
        //Options Panel;
        JPanel panel2 = new JPanel(new GridLayout(3,0,5,5));
        panel2.setPreferredSize(new Dimension(380, 50));
        panel2.setBackground(Color.darkGray);
        panel2.add(optionA);
        panel2.add(optionB);
        panel2.add(optionC);
        mainFrame.add(panel2, BorderLayout.EAST);
        
        //Health and Info
        JPanel panel3 = new JPanel();
        panel3.setPreferredSize(new Dimension(30,50));
        panel3.setBackground(Color.LIGHT_GRAY);
        panel3.add(status);
        mainFrame.add(panel3, BorderLayout.NORTH);
        

        mainFrame.show();
        
    }
    public static void main(String[] args) {
        NickCageGame ncg = new NickCageGame();
        ncg.gameSetup();
        ncg.printGUI("I", "Am", "Awesome", "Look at this");
    }
}