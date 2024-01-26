
package project.management.system;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class removeTask extends JFrame implements ActionListener{
    
    Choice clabel_id;
    JButton delete,back;
    removeTask(){
        getContentPane().setBackground(Color.white);
       setLayout(null);
        
        JLabel label_id = new JLabel("ID:");
       label_id.setBounds(50, 50, 100, 30);
       label_id.setFont(new Font("serif", Font.PLAIN,20));
       add(label_id);
       
       
        clabel_id = new Choice();
        clabel_id.setBounds(200, 150, 100, 30);
          add(clabel_id);     
          
          try{
              Conn c = new Conn();
              String query ="select *from employee";
              ResultSet rs = c.s.executeQuery(query);
              while(rs.next()){
                  clabel_id.add(rs.getString("label_id"));
              }
              
              
          }catch(Exception e){
              e.printStackTrace();
          }
          
                JLabel labeltitle = new JLabel("Title:");
                label_id.setBounds(50, 150, 100, 30);
                add(label_id);
                
                JLabel lblid = new JLabel();
                lblid.setBounds(200, 100, 100, 30);
                add(lblid);
       
                 JLabel labeldescription = new JLabel("Description:");
                labeldescription.setBounds(50, 250, 100, 30);
                add(labeldescription);
                
                JLabel lbldescription = new JLabel();
                lbldescription.setBounds(200, 150, 100, 30);
                add(lbldescription);
                
                 JLabel labelasignee = new JLabel("Asignee:");
                labelasignee.setBounds(50, 200, 100, 30);
                add(labelasignee);
                
                JLabel lblasignee = new JLabel();
                lblasignee.setBounds(200, 200, 100, 30);
                add(lblasignee);
                
                 JLabel labelstatus = new JLabel("Status:");
                labelstatus.setBounds(50, 100, 100, 30);
                add(labelstatus);
                
                JLabel lblstatus = new JLabel();
                lblstatus.setBounds(200, 250, 100, 30);
                add(lblstatus);
                
                try{
              Conn c = new Conn();
              String query ="select *from employee where id ='"+clabel_id.getSelectedItem()+"'";
              
              ResultSet rs = c.s.executeQuery(query);
              while(rs.next()){
                  labeltitle.setText(rs.getString("title"));
                  labeltitle.setText(rs.getString("description"));
                  labeltitle.setText(rs.getString("asignee"));
                  labeltitle.setText(rs.getString("status"));
              }
              
              
          }catch(Exception e){
              e.printStackTrace();
          }
                clabel_id.addItemListener(new ItemListener(){
                    @Override
                    public void itemStateChanged(ItemEvent ie){
                        try{
              Conn c = new Conn();
              String query ="select *from employee where id ='"+clabel_id.getSelectedItem()+"'";
              
              ResultSet rs = c.s.executeQuery(query);
              while(rs.next()){
                  labeltitle.setText(rs.getString("title"));
                  labeltitle.setText(rs.getString("description"));
                  labeltitle.setText(rs.getString("asignee"));
                  labeltitle.setText(rs.getString("status"));
              }
              
              
          }catch(Exception e){
              e.printStackTrace();
          }
                    };
                });
       
        delete= new JButton(" Delete");
       delete.setBounds(220,300 , 100, 30);
       delete.addActionListener(this);
       delete.setBackground(Color.black);
        delete.setForeground(Color.white);
       add(delete);
        
        back = new JButton("Back");
        back.setBounds(80,300 , 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 600, 400);
        add(image);
        
        add(back);
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== delete){
            
           try{
              Conn c = new Conn();
              String query ="delete from task where id= '"+clabel_id.getSelectedItem()+"'";
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null, "detail deleted successfully");
              setVisible(false);
              }
              
              
          catch(Exception e){
              e.printStackTrace();
          } 
            
        }else{
            setVisible(false);
            new Main();
        }
    }
    
    public static void main(String[]args){
        new removeTask();
    }
}
