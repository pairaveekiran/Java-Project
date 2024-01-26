
package project.management.system;

import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

public class viewTask extends JFrame implements ActionListener{
    
    JTable table;
    JButton back, update;
   
    viewTask(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("View tasks ");
        searchlbl.setBounds(20, 20, 150, 30);
        add(searchlbl);
        table = new JTable();
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        back = new JButton("Back");
        back.setBounds(300,70 , 80, 20);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        update = new JButton("Update");
        update.setBounds(200,70 , 80, 20);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add( update);
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== back){
            setVisible(false);
            new Main();
        }else{
            setVisible(false);
            
        }
    }
    public static void main(String[] args){
        
        new viewTask();
    }
}