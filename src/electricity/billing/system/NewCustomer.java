package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class NewCustomer extends JFrame implements ActionListener {
    
    JTextField tfname, tfaddress, tfstate, tfcity, tfemail, tfphone;
    JButton next, cancel;
    JLabel lblmeter;
    NewCustomer(){
        setSize(700, 500);
        setLocation(400, 200);
        
        JPanel P = new JPanel();
        P.setLayout(null);
        P.setBackground(new Color(173, 216, 230));
        add(P);
        
        JLabel heading = new JLabel("New Customer");
        heading.setBounds(100, 20, 200, 25);
        heading.setFont(new Font("calberi", Font.PLAIN, 24)); 
        P.add(heading);
        
        JLabel lblname = new JLabel("Customer Name");
        lblname.setBounds(100, 80, 100, 20);
        P.add(lblname);
       
        tfname = new JTextField();
        tfname.setBounds(240,80,200,20);
        P.add(tfname);
        
        JLabel lblmeterno = new JLabel("Meter Number");
        lblmeterno.setBounds(100, 120, 100, 20);
        P.add(lblmeterno);
       
        lblmeter = new JLabel("");
        lblmeter.setBounds(240, 120, 100, 20);
        P.add(lblmeter);
       
        Random ran = new Random();
        long number = ran.nextLong() % 1000000;
        lblmeter.setText(""+ Math.abs(number));
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(100, 160, 100, 20);
        P.add(lbladdress);
       
        tfaddress = new JTextField();
        tfaddress.setBounds(240,160,200,20);
        P.add(tfaddress);
        
        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(100, 200, 100, 20);
        P.add(lblcity);
       
        tfcity = new JTextField();
        tfcity.setBounds(240,200,200,20);
        P.add(tfcity);
        
        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(100, 240, 100, 20);
        P.add(lblstate);
       
        tfstate = new JTextField();
        tfstate.setBounds(240,240,200,20);
        P.add(tfstate);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(100, 280, 100, 20);
        P.add(lblemail);
       
        tfemail = new JTextField();
        tfemail.setBounds(240,280,200,20);
        P.add(tfemail);
        
        JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(100, 320, 100, 20);
        P.add(lblphone);
       
        tfphone = new JTextField();
        tfphone.setBounds(240,320,200,20);
        P.add(tfphone);
        
        next = new JButton("Next");
        next.setBounds(120, 390, 100, 25);
        next.addActionListener(this);
        P.add(next);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(300, 390, 100, 25);
        cancel.addActionListener(this);
        P.add(cancel);
        
        setLayout(new BorderLayout());
        add(P, "Center");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "West");
        
        getContentPane().setBackground(Color.white);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== next){
            String name = tfname.getText();
            String meter = lblmeter.getText();
            String address= tfaddress.getText();
            String city = tfcity.getText();
            String state = tfstate.getText();
            String email = tfemail.getText();
            String phone = tfphone.getText();
            
            String query1 = "insert into customer value('"+name+"','"+meter+"','"+address+"','"+city+"','"+state+"','"+email+"','"+phone+"')";
            String query2 = "insert into login value('"+meter+"','','"+name+"','','')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
                
                // new frame
                new meterinfo(meter);
            }catch(Exception e){
                e.printStackTrace();
            } 
        }else{
            setVisible(false);
        }
    }
   
   public static void main(String[] args){
       new NewCustomer();
   }    
}
