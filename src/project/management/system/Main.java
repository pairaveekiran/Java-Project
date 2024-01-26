
package project.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Main extends JFrame implements ActionListener{
    JButton add,view,update,remove;
    Main(){
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/download.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 630);
        add(image);
        
    
        JLabel heading = new JLabel("PROJECT MANAGEMENT SYSTEM");
        heading.setBounds(650, 20, 400,40 );
        heading.setFont(new Font("Raleway", Font.BOLD, 30));
        image.add(heading);
       
        add = new JButton("add task");
        add.setBounds(650,80 , 150, 40);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("view tasks");
        view.setBounds(820,80 , 150, 40);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("update task");
        update.setBounds(650,140 , 150, 40);
        update.addActionListener(this);
        image.add(update);
        
        remove = new JButton("remove task");
        remove.setBounds(820,140 , 150, 40);
        remove.addActionListener(this);
        image.add(remove);
        
        setSize(1120, 630);
        setLocation(250,100);
        setVisible(true);
    }
     @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            setVisible(false);
            new addTask();
        }
        else if(ae.getSource()== view){
        setVisible(false);
            new viewTask();
        }
        else if(ae.getSource()== update){
            setVisible(false);
        new viewTask();
        }
        else{
            setVisible(false);
        new removeTask();
        }

    }
    
    public static void main(String[] args){
        new Main();
    }
    
}
