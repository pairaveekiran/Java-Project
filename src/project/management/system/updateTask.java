
package project.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class updateTask extends JFrame implements ActionListener{

    
    JTextField  tfstatus,tftitle,tfdescription, tfasignee;
    JButton add, back;
    String id;
    JLabel lblid;
    
    updateTask(String id){
        this.id = id;
       getContentPane().setBackground(Color.white);
       setLayout(null);
       
       JLabel heading = new JLabel("Update Detail");
       heading.setBounds(320, 30, 500, 50);
       heading.setFont(new Font("Raleway", Font.BOLD, 30));
       add(heading);
       
       JLabel label_id = new JLabel("ID:");
       label_id.setBounds(50, 150, 150, 30);
       label_id.setFont(new Font("serif", Font.PLAIN,20));
       add(label_id);
       
       lblid = new JLabel();
       lblid.setBounds(200, 150, 150, 30);
       lblid.setFont(new Font("serif", Font.PLAIN,20));
       add(lblid);
       
       JLabel label_title = new JLabel("Title:");
       label_title.setBounds(50, 200, 150, 30);
       label_title.setFont(new Font("serif", Font.PLAIN,20));
       add(label_title);
       
       tftitle = new JTextField();
       tftitle.setBounds(200, 200, 150, 30);
       add(tftitle);
       
       JLabel label_description = new JLabel("Description:");
       label_description.setBounds(50, 250, 150, 30);
       label_description.setFont(new Font("serif", Font.PLAIN,20));
       add(label_description);
       
       tfdescription = new JTextField();
       tfdescription.setBounds(200, 250, 350, 30);
       add(tfdescription);
       
       JLabel label_asignee = new JLabel("Assignee:");
       label_asignee.setBounds(50, 300, 150, 30);
       label_asignee.setFont(new Font("serif", Font.PLAIN,20));
       add(label_asignee);
       
       tfasignee = new JTextField();
       tfasignee.setBounds(200, 300, 150, 30);
       add(tfasignee);
       
       JLabel label_status = new JLabel("Status:");
       label_status.setBounds(50, 350, 150, 30);
       label_status.setFont(new Font("serif", Font.PLAIN,20));
       add(label_status);
       
       String status[]= {"Pending","completed","rejected"};
       tfstatus = new JTextField();
       tfstatus.setBackground(Color.WHITE);
       tfstatus.setBounds(200,350,150,30);
       add(tfstatus);
       
       try{
           Conn c = new Conn();
           String query = "select * from task where id ='"+id+"'";
           ResultSet rs = c.s.executeQuery(query);
           while(rs.next()){
            lblid.setText(rs.getString("id"));
            tftitle.setText(rs.getString("title"));
            tfdescription.setText(rs.getString("description"));
            tfasignee.setText(rs.getString("asignee"));
            tfstatus.setText(rs.getString("status"));
           }
           
                   
       }catch(Exception e){
           e.printStackTrace();
       }
       
       add = new JButton(" Submit");
       add.setBounds(100,450 , 150, 40);
       add.addActionListener(this);
       add.setBackground(Color.black);
       add.setForeground(Color.white);
       add(add);
        
        back = new JButton("Back");
        back.setBounds(300,450 , 150, 40);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
       
       
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
        
    
        
    }

     
    
    @Override
    public void actionPerformed(ActionEvent ae){
       
        
           if(ae.getSource()== add){
            
            String title = tftitle.getText();
            String description = tftitle.getText();
            String asignee = tfasignee.getText();
            String status = tfstatus.getText();
              try{
                Conn conn = new Conn();
                String query ="update employee set id='"+id+"',title='"+title+"',description'"+description+"',asignee='"+asignee+"',status='"+status+"' where id ='"+id+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "detail updated successfully");
                setVisible(false);
                new Main();
              }
        catch (Exception e){
            e.printStackTrace();
        }}
        else{
            setVisible(false);
           new Main();
        }
           
    }  
    
    public static void main(String[] args){
        new updateTask("");
       
    }
    
}
