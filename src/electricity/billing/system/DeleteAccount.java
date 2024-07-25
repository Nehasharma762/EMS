package electricity.billing.system;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteAccount extends JFrame implements ActionListener {

    JButton delete, back;
    JTextField meter;

    DeleteAccount() {

        setBounds(450, 150, 500, 250);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(30, 30, 450, 170);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Delete-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(172, 216, 230)));
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        add(panel);

        JLabel lblmeter = new JLabel("Enter Meter Number");
        lblmeter.setBounds(100, 70, 140, 20);
        lblmeter.setForeground(Color.GRAY);
        lblmeter.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(lblmeter);

        meter = new JTextField();
        meter.setBounds(250, 70, 150, 20);
        panel.add(meter);

        delete = new JButton("Delete");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setBounds(100, 120, 100, 25);
        delete.addActionListener(this);
        panel.add(delete);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(250, 120, 100, 25);
        back.addActionListener(this);
        panel.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            String smeter = meter.getText();

            try {
                Conn c = new Conn();

                // Delete from customer table
                String queryCustomer = "delete from customer where meter_no = '" + smeter + "'";
                int rowsAffected = c.s.executeUpdate(queryCustomer);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Account Deleted Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Meter number not found in the customer table!");
                }

                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new DeleteAccount();
    }
}
