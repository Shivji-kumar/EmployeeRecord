package employeedetails;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;



public class RemoveEmployee extends JFrame implements ActionListener{
    Choice cempid;
    JButton delete,back;
    RemoveEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelempid=new JLabel("Employee id");
        labelempid.setBounds(50,50,100,30);
        
        add(labelempid);
        
        cempid=new Choice();
        cempid.setBounds(200,50,150,30);
        add(cempid);
        
        try{
            Conn c=new Conn();
            String query="select *from employee";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                cempid.add(rs.getString("empid"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        add(labelname);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(200,100,100,30);
        add(lblname);
        
        JLabel labelphone=new JLabel("Phonde No");
        labelphone.setBounds(50,150,100,30);
        add(labelphone);
        
        JLabel lblphone=new JLabel();
        lblphone.setBounds(50,150,100,30);
        add(lblphone);
        
        JLabel labelemail=new JLabel("Email Id");
        labelemail.setBounds(50,200,100,30);
        add(labelemail);
        
        JLabel lblemail=new JLabel();
        lblemail.setBounds(200,200,100,30);
        add(lblemail);
        
         try{
            Conn c=new Conn();
            String query="select *from employee where empid=cempid.getSelectItem()";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                cempid.add(rs.getString("empid"));
                lblname.setText(rs.getString("name"));
                lblname.setText(rs.getString("phone"));
                lblname.setText(rs.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
         cempid.addItemListener(new ItemListener(){
        public void itemStateChanged(itemEvent ie){
            try{
            Conn c=new Conn();
            String query="select *from employee where empid=cempid.getSelectItem()";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                cempid.add(rs.getString("empid"));
                lblname.setText(rs.getString("name"));
                lblname.setText(rs.getString("phone"));
                lblname.setText(rs.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        }
         });
         
        delete =new JButton("Delete");
        delete.setBounds(220,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back =new JButton("Delete");
        back.setBounds(240,300,100,30);
        back.setBackground(Color.BLUE);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2=i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,0,600,400);
        
        add(image);
        
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try{
                Conn c=new Conn();
                String query="delete from Employee where empid=empid.getSelectedItem()";
                c.s.executeQuery(query);
                JOptionPane.showMessageDialog(null,"Employee Information Deleted Sucessfully");
                setVisible(false);
                new Home();f
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Home();
            
        }
    }
    public static void main(String [] args){
        new RemoveEmployee();
    }
    
}
