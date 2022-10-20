/**
 * CustomerScreen.java
 * View for editing and displaying Customer info
 * Author (s): Shawn Grant
 */
package view;

import client.Client;
import models.Customer;
import view.dialogs.customer.CustomerInsertDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CustomerScreen extends BaseScreen implements ActionListener {

    private final String[] tableHeaders = {
            "ID",
            "First Name",
            "Last Name",
            "DOB",
            "Email",
            "Phone",
            "Address",
            "Membership Date",
            "Expiry Date",
    };
    private JTable table;
    private DefaultTableModel model;

    public CustomerScreen() {
        super("Customers");

        initializeComponents();
        setupListeners();
        setContentView();
        getData();
    }

    private void initializeComponents() {
        model = new DefaultTableModel(tableHeaders, 0);
        table = new JTable(model);
        table.setDefaultEditor(Object.class, null); //Set to not editable
        table.setAutoCreateRowSorter(true); //Enable sorting by columns
    }

    // setup actions for buttons
    private void setupListeners() {
        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        searchButton.addActionListener(this);
        refreshButton.addActionListener(this);
    }

    // set main content view
    private void setContentView() {
        setMainContent(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
    }

    private void getData() {
        Client client = new Client();
        client.sendAction("View Customers");
        List<Customer> customersList = client.receiveViewCustomersResponse();
        client.closeConnections();

        int count = 0;
        int rowCount = model.getRowCount();
        int counter = 0;

        while (counter < rowCount) {
            model.removeRow(count);
            counter++;
        }

        for (Customer customer : customersList) {
            System.out.println(customer);

            model.insertRow(count, new Object[]{
                    customer.getId(),
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getDOB(),
                    customer.getEmail(),
                    customer.getTelephone(),
                    customer.getAddress(),
                    customer.getMembershipDate(),
                    customer.getMembershipExpiryDate()
            });
            count++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addButton)) {
            new CustomerInsertDialog();
            getData();
        }
        if (e.getSource().equals(updateButton)) {

        }
        if (e.getSource().equals(searchButton)) {

        }
        if (e.getSource().equals(deleteButton)) {

        }
        if (e.getSource().equals(refreshButton)) {
            getData();
        }
    }
}
