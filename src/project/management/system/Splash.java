
package project.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 
public class Splash extends JFrame implements ActionListener{
    Splash(){
        getContentPane().setBackground(Color.white);
        getContentPane().setForeground(Color.DARK_GRAY);
        setLayout(null);
        
        
         setLayout(null);
         JLabel heading = new JLabel("PROJECT MANAGEMENT SYSTEM");
         heading.setBounds(80, 30, 1200, 80);
         heading.setFont(new Font("serif", Font.PLAIN, 60));
         add(heading);
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 100, 1200, 630);
        add(image);
        
        
        setVisible(true);
        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(60,100,200,50);
        
        clickhere.setBackground(Color.black);
        clickhere.setForeground(Color.white);
        clickhere.addActionListener(this);
        
        image.add(clickhere);
         setSize(1170,650);
         setLocation(200,50);
         setVisible(true);

    
}
    @Override
    public void actionPerformed(ActionEvent ae){
     setVisible(false);
      new Login();
    }
    public static void main(String[]args){
        new Splash();
    }
        
}