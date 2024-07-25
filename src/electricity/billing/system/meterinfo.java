package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class meterinfo extends JFrame implements ActionListener {

    JButton next;
    Choice meterLocation, meterType, phaseCode;
    JLabel billTypeLabel; // Static label for bill type
    String meternumber;

    meterinfo(String meternumber) {
        this.meternumber = meternumber;

        setSize(700, 500);
        setLocation(400, 200);

        JPanel P = new JPanel();
        P.setLayout(null);
        P.setBackground(new Color(173, 216, 230));
        add(P);

        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(100, 20, 200, 25);
        heading.setFont(new Font("calberi", Font.PLAIN, 24));
        P.add(heading);

        JLabel lblname = new JLabel("Meter number");
        lblname.setBounds(100, 80, 100, 20);
        P.add(lblname);

        JLabel lblmeternumber = new JLabel(meternumber);
        lblmeternumber.setBounds(240, 80, 100, 20);
        P.add(lblmeternumber);

        JLabel lblmeterno = new JLabel("Meter Location");
        lblmeterno.setBounds(100, 120, 100, 20);
        P.add(lblmeterno);

        meterLocation = new Choice();
        meterLocation.add("Outside");
        meterLocation.add("Inside");
        meterLocation.setBounds(240, 120, 200, 20);
        P.add(meterLocation);

        JLabel lbladdress = new JLabel("Meter Type");
        lbladdress.setBounds(100, 160, 100, 20);
        P.add(lbladdress);

        meterType = new Choice();
        meterType.add("Electric Meter");
        meterType.add("Solar Meter");
        meterType.add("Smart Meter");
        meterType.setBounds(240, 160, 200, 20);
        P.add(meterType);

        JLabel lblcity = new JLabel("Phase Code");
        lblcity.setBounds(100, 200, 100, 20);
        P.add(lblcity);

        phaseCode = new Choice();
        phaseCode.add("101");
        phaseCode.add("102");
        phaseCode.add("103");
        phaseCode.add("104");
        phaseCode.add("105");
        phaseCode.add("106");
        phaseCode.add("107");
        phaseCode.add("108");
        phaseCode.add("109");
        phaseCode.setBounds(240, 200, 200, 20);
        P.add(phaseCode);

        JLabel lblstate = new JLabel("Bill Type");
        lblstate.setBounds(100, 240, 100, 20);
        P.add(lblstate);

        billTypeLabel = new JLabel("Normal"); // Static label for bill type
        billTypeLabel.setBounds(240, 240, 200, 20);
        P.add(billTypeLabel);

        JLabel lblemail = new JLabel("Days");
        lblemail.setBounds(100, 280, 100, 20);
        P.add(lblemail);

        JLabel lblemails = new JLabel("30 Days");
        lblemails.setBounds(240, 280, 100, 20);
        P.add(lblemails);

        JLabel lblphone = new JLabel("Note");
        lblphone.setBounds(100, 320, 100, 20);
        P.add(lblphone);

        JLabel lblphones = new JLabel("By Default Bill is calculated for 30 days only");
        lblphones.setBounds(240, 320, 500, 20);
        P.add(lblphones);

        next = new JButton("Submit");
        next.setBounds(240, 390, 100, 25);
        next.addActionListener(this);
        P.add(next);

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

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            String meter = meternumber;
            String location = meterLocation.getSelectedItem();
            String type = meterType.getSelectedItem();
            String code = phaseCode.getSelectedItem();
            String typebill = "Normal"; // Fixed bill type as "Normal"
            String days = "30";

            double costPerUnit = 10.0; // Updated cost per unit in Rs
            double unitsConsumed = 50; // Sample units consumed, replace with actual value

            // Calculate the bill amount
            double billAmount = costPerUnit * unitsConsumed;

            String query = "insert into meter_info values('" + meter + "','" + location + "','" + type + "','" + code
                    + "','" + typebill + "','" + days + "')";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Meter Information Added Successfully");
                JOptionPane.showMessageDialog(null, "Bill Amount: Rs " + billAmount);
                setVisible(false);

                // new frame

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new meterinfo("");
    }
}
