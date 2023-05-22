
package employeedetails;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{
    Random ran=new Random();
    int number=ran.nextInt(999999);
    JTextField tfname,tffname,tsalary,taddress,tphone,temail,tdest,tadhar;
    JDateChooser dcdob;
    JComboBox thieghtedu;
    JLabel labeleid;
    JButton add,back;
  
    
    AddEmployee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("San_SERIF",Font.BOLD,25));
        add(heading);
        
        JLabel labelname=new JLabel("Employee Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
        
        tfname=new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        JLabel labelfname=new JLabel("Father's Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);
        
         tffname=new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        JLabel labeldob=new JLabel("Date of Birth");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldob);
        
         dcdob=new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);
        
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
        
        String course[]={"Bsc IT","BBA","MBA","BCA","MCA","B Tech","M Tech","Msc IT"};
        thieghtedu=new JComboBox(course);
        thieghtedu.setBackground(Color.WHITE);
        thieghtedu.setBounds(600,300,150,30);
        add(thieghtedu);
        
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
        
         tadhar=new JTextField();
        tadhar.setBounds(600,350,150,30);
        add(tadhar);
        
        JLabel labelid=new JLabel("Employee Id");
        labelid.setBounds(50,400,150,30);
        labelid.setFont(new Font("serif",Font.PLAIN,20));
        add(labelid);
        
         labeleid=new JLabel(""+number);
        labeleid.setBounds(200,400,150,30);
        labeleid.setFont(new Font("serif",Font.PLAIN,20));
        add(labeleid);
        
         add=new JButton("Add Details");
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
          String name=tfname.getText();
          String fname=tffname.getText();
          String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
          String salary=tsalary.getText();
          String address=taddress.getText();
          String phone=tphone.getText();
          String email=temail.getText();
          String education=(String)thieghtedu.getSelectedItem();
          String designation=tdest.getText();
          String adhaar=tadhar.getText();
          String empid=labeleid.getText();
                  
            try{
                Conn con=new Conn();
               
                //String query="insert into employee values("+name+","+fname+","+dob+","+salary+","+address+","+phone+","+email+","+educat+","+destg+","+aadhar+","+empid+",)";
               String query="insert into employee values(name,fname,dob,salary,address,phone,email,education,designation,adhaar,empid)";
               //+"values(?,?,?,?,?,?,?,?,?,?,?)";
                //String sql = " insert into users (first_name, last_name, date_created, is_admin, num_points)"
   // + " values (?, ?, ?, ?, ?)";
               // String query = "Select * From login Where username= username and password= password";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Added Successfully");
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
    

    public static void main(String [] args){
        new AddEmployee();
    }
    
}
        
