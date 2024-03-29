package view.screens;

import client.Client;
import models.Customer;
import view.dialogs.customer.InsertDialog;
import view.dialogs.customer.RemoveDialog;
import view.dialogs.customer.SearchDialog;
import view.dialogs.customer.UpdateDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

/**
 * View for editing and displaying Customer info
 * @author Shawn Grant
 */
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
        table.getTableHeader().setOpaque(false);//Remove header background
        table.getTableHeader().setBackground(new Color(224, 224, 224));//Setting new background of table headings
        table.setBackground(Color.white);
        table.setForeground(Color.black);
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

    // remove item at selected row
    private boolean removeItem() {
        boolean isSelected = false;
        if (table.getSelectedRow() != -1) {
            isSelected = true;
            int choice = JOptionPane.showConfirmDialog(
                    null,
                    "Remove this customer?",
                    "Remove Customer",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            if (choice == JOptionPane.YES_OPTION) {
                Client client = new Client();
                client.sendAction("Remove Customer");
                client.sendCustomerId((String) model.getValueAt(table.getSelectedRow(), 0));
                client.receiveResponse();
                client.closeConnections();
            }
        }
        return isSelected;
    }

    // update item at selected row
    private boolean updateItem() {
        boolean isSelected = false;
        //auto populate if a row is selected
        if (table.getSelectedRow() != -1) {
            isSelected = true;
            // Split values format YYYY-MM-DD
            String[] dob = model.getValueAt(table.getSelectedRow(), 3).toString().split("-");
            String[] memDate = model.getValueAt(table.getSelectedRow(), 7).toString().split("-");
            String[] memExpDate = model.getValueAt(table.getSelectedRow(), 8).toString().split("-");

            Customer customer = new Customer(
                    model.getValueAt(table.getSelectedRow(), 0).toString(),
                    model.getValueAt(table.getSelectedRow(), 1).toString(),
                    model.getValueAt(table.getSelectedRow(), 2).toString(),
                    new Date(),
                    model.getValueAt(table.getSelectedRow(), 6).toString(),
                    model.getValueAt(table.getSelectedRow(), 5).toString(),
                    model.getValueAt(table.getSelectedRow(), 4).toString(),
                    new Date(),
                    new Date()
            );

            // primary constructor to take a customer
            new UpdateDialog(customer, dob, memDate, memExpDate);
        }
        return isSelected;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addButton)) {
            new InsertDialog();
            getData();
        }
        if (e.getSource().equals(updateButton)) {
            if (!updateItem()) {
                new UpdateDialog();
            }
            getData();
        }
        if (e.getSource().equals(searchButton)) {
            new SearchDialog(model);
        }
        if (e.getSource().equals(deleteButton)) {
            if (!removeItem()) {
                new RemoveDialog();
            }
            getData();
        }
        if (e.getSource().equals(refreshButton)) {
            getData();
        }
    }
}
