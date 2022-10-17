package view;

import client.Client;
import models.Product;
import view.dialogs.InventoryInsertDialog;
import view.dialogs.InventoryUpdateDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InventoryScreen extends BaseScreen implements ActionListener {

    private final String[] TableHead = {"Product Code", "Product Name", "Short Description", "Long Description",
            "Items in Stock", "Unit Price"};
    private JTable table;
    private DefaultTableModel model;

    public InventoryScreen() {
        super("Inventory");

        initializeComponents();
        setupListeners();
        setContentView();
        getInventory();
    }

    private void initializeComponents() {
        //Table properties
        model = new DefaultTableModel(TableHead, 0);
        table = new JTable(model);
        table.setDefaultEditor(Object.class, null); //Set to not editable
        table.setAutoCreateRowSorter(true); //Enable sorting by columns
    }

    // set main content view
    private void setContentView() {
        setMainContent(new JScrollPane(table));
    }

    // setup actions for buttons
    private void setupListeners() {
        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        searchButton.addActionListener(this);
        refreshButton.addActionListener(this);
    }

    // retrieve all product information
    private void getInventory() {
        Client client = new Client();
        client.sendAction("View Inventory");
        List<Product> productList = client.receiveViewInventoryResponse();
        client.closeConnections();

        int count = 0;
        int rowCount = model.getRowCount();
        int counter = 0;

        while (counter < rowCount) {
            model.removeRow(count);
            counter++;
        }

        for (Product product : productList) {
            System.out.println(product);

            model.insertRow(count, new Object[]{product.getCode(), product.getName(),
                    product.getShortDescription(), product.getLongDescription(),
                    product.getItemInStock(), product.getUnitPrice()});
            count++;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(addButton)) {
            InventoryInsertDialog insertDialog = new InventoryInsertDialog();
            insertDialog.setVisible(true);
        }
        /*if (e.getSource().equals(searchButton)) {
            //InventorySearchDialog searchDialog = new InventorySearchDialog();
            //searchDialog.setVisible(true);
        }*/
        if (e.getSource().equals(updateButton)) {
            InventoryUpdateDialog updateDialog = new InventoryUpdateDialog();
            updateDialog.setVisible(true);
        }
        if (e.getSource().equals(deleteButton)) {
            //InventoryRemoveDialog removeDialog = new InventoryRemoveDialog();
            //removeDialog.setVisible(true);
        }
        if (e.getSource().equals(refreshButton)) {
            getInventory();
        }
    }
}
