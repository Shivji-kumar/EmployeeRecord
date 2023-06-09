
package employeedetails;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.sql.*;

import java.awt.event.*;

public class UpdateEmployee extends JFrame implements ActionListener{
    
    JTextField tfeducation,tname,tfname,tdob,tsalary,taddress,tphone,temail,tdest,lblaadhar;
    
    JLabel labelempid;
    JButton add,back;
    String empid;
  
    
    UpdateEmployee(String empid){
        this.empid=empid;
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Update Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("San_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname=new JLabel("Employee Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
        
        JLabel tname=new JLabel();
        tname.setBounds(200,150,150,30);
        add(tname);
        
        JLabel labelfname=new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);
        
         tfname=new JTextField();
        tfname.setBounds(600,150,150,30);
        add(tfname);
        
        JLabel labeldob=new JLabel("Date of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);
        
         JLabel tdob=new JLabel();
        tdob.setBounds(200,200,150,30);
        add(tdob);
        
        JLabel labelsalary=new JLabel("Employee Salary");
        labelsalary.setBounds(400,200,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(labelsalary);
        
         tsalary=new JTextField();
        tsalary.setBounds(600,200,150,30);
        add(tsalary);
        
         JLabel labeladdress=new JLabel("Emp Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladdress);
        
         taddress=new JTextField();
        taddress.setBounds(200,250,150,30);
        add(taddress);
        
        JLabel labelphone=new JLabel("Phone No");
        labelphone.setBounds(400,250,150,30);
        labelphone.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphone);
        
         tphone=new JTextField();
        tphone.setBounds(600,250,150,30);
        add(tphone);
        
        JLabel labelemail=new JLabel("Email Id");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);
        
         temail=new JTextField();
        temail.setBounds(200,300,150,30);
        add(temail);
        
        JLabel hieghtedu=new JLabel("Higest Education");
        hieghtedu.setBounds(400,300,150,30);
        hieghtedu.setFont(new Font("serif",Font.PLAIN,20));
        add(hieghtedu);
        
       // String course[]={"Bsc IT","BBA","MBA","BCA","MCA","B Tech","M Tech","Msc IT"};
        tfeducation =new JTextField();
        tfeducation.setBackground(Color.WHITE);
        tfeducation.setBounds(600,300,150,30);
        add(tfeducation);
        
        JLabel labeldest=new JLabel("Degination");
        labeldest.setBounds(50,350,150,30);
        labeldest.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldest);
        
         tdest=new JTextField();
        tdest.setBounds(200,350,150,30);
        add(tdest);
        
        JLabel labeladhar=new JLabel("Adhar No");
        labeladhar.setBounds(400,350,150,30);
        labeladhar.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladhar);
        
        JLabel lblaadhar=new JLabel();
        lblaadhar.setBounds(600,350,150,30);
        add(lblaadhar);
        
        JLabel labelid=new JLabel("Employee Id");
        labelid.setBounds(50,400,150,30);
        labelid.setFont(new Font("serif",Font.PLAIN,20));
        add(labelid);
        
         labelempid=new JLabel();
        labelempid.setBounds(200,400,150,30);
        labelempid.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempid);
        
        try{
            Conn c=new Conn();
            String query="select *from employee where empid='"+empid+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                tname.setText(rs.getString("name"));
                tfname.setText(rs.getString("fname"));
                tdob.setText(rs.getString("dob"));
                tsalary.setText(rs.getString("salary"));
                taddress.setText(rs.getString("address"));
                tphone.setText(rs.getString("phone"));
                temail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                tdest.setText(rs.getString("designation"));
                lblaadhar.setText(rs.getString("adhaar"));
                labelempid.setText(rs.getString("empid"));
                
            }
            
        }catch(Exception e){
           e.printStackTrace();
        }
        
         add=new JButton("Update Details");
        add.setBounds(250,500,150,40);
        add.addActionListener((ActionListener) this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
         back=new JButton("Back");
        back.setBounds(450,500,150,40);
        back.addActionListener((ActionListener) this);
        add(back);
                        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
          
          String fname=tfname.getText();
          String salary=tsalary.getText();
          String address=taddress.getText();
          String phone=tphone.getText();
          String email=temail.getText();
          String education=tfeducation.getText();
          String designation=tdest.getText();
                            
            try{
                Conn con=new Conn();
               String query="update employee set fname= '"+fname+"', salary= '"+salary+"', address= '"+address+"', phone= '"+phone+"', email= '"+email+"', education= '"+education+"',designation= '"+designation+"' where empid= '"+empid+"'";
              
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated Successfully");
                setVisible(false);
                new Home();
                
            }   catch(Exception e){
                e.printStackTrace();                
            }  
           
        }else{
            setVisible(false);
            new Home();
        }
        
    }
    

//    public static void main(String [] args){
//        new UpdateEmployee("");
//    }
    
}
        
