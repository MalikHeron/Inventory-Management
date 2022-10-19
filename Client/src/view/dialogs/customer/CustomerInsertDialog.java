/**
 * CustomerInsertDialog.java
 * Popup to add a new customer
 * Author (s): Shawn Grant
 */
package view.dialogs.customer;

import client.Client;
import models.Customer;
import view.RoundedBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class CustomerInsertDialog extends JDialog implements ActionListener {

    private JLabel idLabel, firstNameLabel, lastNameLabel, dobLabel;
    private JLabel addressLabel, telephoneLabel, emailLabel;
    private JLabel membershipDateLabel, membershipExpiryDateLabel;
    private JTextField idField, firstNameField, lastNameField;
    private JTextField addressField, telephoneField, emailField;
    private JFormattedTextField dobField, membershipDateField, membershipExpiryDateField;
    private JButton cancelButton, confirmButton;

    public CustomerInsertDialog() {
        initComponents();
        addPanelsToWindow();
        registerListeners();
        setWindowProperties();
    }

    private void initComponents() {
        //Label properties
        idLabel = new JLabel("ID");
        idLabel.setFont(new Font("arial", Font.BOLD, 14));
        idLabel.setPreferredSize(new Dimension(130, 20));

        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setFont(new Font("arial", Font.BOLD, 14));
        firstNameLabel.setPreferredSize(new Dimension(130, 20));

        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setFont(new Font("arial", Font.BOLD, 14));
        lastNameLabel.setPreferredSize(new Dimension(130, 20));

        dobLabel = new JLabel("Date of Birth");
        dobLabel.setFont(new Font("arial", Font.BOLD, 14));
        dobLabel.setPreferredSize(new Dimension(130, 20));

        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("arial", Font.BOLD, 14));
        emailLabel.setPreferredSize(new Dimension(130, 20));

        addressLabel = new JLabel("Address");
        addressLabel.setFont(new Font("arial", Font.BOLD, 14));
        addressLabel.setPreferredSize(new Dimension(130, 20));

        telephoneLabel = new JLabel("Phone #");
        telephoneLabel.setFont(new Font("arial", Font.BOLD, 14));
        telephoneLabel.setPreferredSize(new Dimension(130, 20));

        membershipDateLabel = new JLabel("Membership Date");
        membershipDateLabel.setFont(new Font("arial", Font.BOLD, 14));
        membershipDateLabel.setPreferredSize(new Dimension(130, 20));

        membershipExpiryDateLabel = new JLabel("Expiry Date");
        membershipExpiryDateLabel.setFont(new Font("arial", Font.BOLD, 14));
        membershipExpiryDateLabel.setPreferredSize(new Dimension(130, 20));

        //Field properties
        idField = new JTextField(generateId());
        idField.setBorder(new RoundedBorder(8));
        idField.setPreferredSize(new Dimension(250, 30));

        firstNameField = new JTextField();
        firstNameField.setBorder(new RoundedBorder(8));
        firstNameField.setPreferredSize(new Dimension(250, 30));

        lastNameField = new JTextField();
        lastNameField.setBorder(new RoundedBorder(8));
        lastNameField.setPreferredSize(new Dimension(250, 30));

        dobField = new JFormattedTextField(new Date());
        dobField.setBorder(new RoundedBorder(8));
        dobField.setPreferredSize(new Dimension(250, 30));

        emailField = new JTextField();
        emailField.setBorder(new RoundedBorder(8));
        emailField.setPreferredSize(new Dimension(250, 30));

        addressField = new JTextField();
        addressField.setBorder(new RoundedBorder(8));
        addressField.setPreferredSize(new Dimension(250, 30));

        telephoneField = new JTextField();
        telephoneField.setBorder(new RoundedBorder(8));
        telephoneField.setPreferredSize(new Dimension(250, 30));

        membershipDateField = new JFormattedTextField(new Date());
        membershipDateField.setBorder(new RoundedBorder(8));
        membershipDateField.setPreferredSize(new Dimension(250, 30));

        membershipExpiryDateField = new JFormattedTextField(new Date());
        membershipExpiryDateField.setBorder(new RoundedBorder(8));
        membershipExpiryDateField.setPreferredSize(new Dimension(250, 30));

        //Button properties
        confirmButton = new JButton("ADD CUSTOMER");
        confirmButton.setPreferredSize(new Dimension(200, 30));
        confirmButton.setForeground(Color.BLUE);
        confirmButton.setFont(new Font("arial", Font.BOLD, 14));
        confirmButton.setFocusPainted(false);

        cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(100, 30));
        cancelButton.setFocusPainted(false);
    }

    private void addPanelsToWindow() {
        add(idLabel);
        add(idField);
        add(firstNameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);
        add(dobLabel);
        add(dobField);
        add(emailLabel);
        add(emailField);
        add(addressLabel);
        add(addressField);
        add(telephoneLabel);
        add(telephoneField);
        add(membershipDateLabel);
        add(membershipDateField);
        add(membershipExpiryDateLabel);
        add(membershipExpiryDateField);
        add(confirmButton);
        add(cancelButton);
    }

    private void setWindowProperties() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        setTitle("Add New Customer");
        setSize(450, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
        setVisible(true);
    }

    private void registerListeners() {
        confirmButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            Client client = new Client();
            Customer customer = new Customer(
                    idField.getText(),
                    firstNameField.getText(),
                    lastNameField.getText(),
                    new Date(dobField.getText()),
                    addressField.getText(),
                    telephoneField.getText(),
                    emailField.getText(),
                    new Date(membershipDateField.getText()),
                    new Date(membershipExpiryDateField.getText())
            );
            client.sendAction("Add Customer");
            client.sendCustomer(customer);
            client.receiveResponse();
            client.closeConnections();
            dispose();
        }
        if (e.getSource() == cancelButton) {
            dispose();
        }
    }

    private String generateId() {
        String id = "C";
        int num = (int) ((Math.random() * (4000 - 100)) + 100);

        return id + num;
    }
}
