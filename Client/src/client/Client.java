package client;

import models.*;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for sending requests and receiving responses from the Server
 * @author Malik Heron
 */
public class Client {

    private Socket connectionSocket;
    private ObjectOutputStream objOs;
    private ObjectInputStream objIs;
    private String action;

    public Client() {
        this.createConnection();
        this.configureStreams();
    }

    private void createConnection() {
        try {
            connectionSocket = new Socket("localhost", 8888);
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            JOptionPane.showMessageDialog(null,
                    "Failure to Establish Connection with Server",
                    "Connection Status",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void configureStreams() {
        try {
            objOs = new ObjectOutputStream(connectionSocket.getOutputStream());
            objIs = new ObjectInputStream(connectionSocket.getInputStream());
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void closeConnections() {
        try {
            objOs.close();
            objIs.close();
            connectionSocket.close();
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }
    }

    public void sendAction(String action) {
        this.action = action;
        try {
            objOs.writeObject(action);
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }
    }

    public void sendEmployee(Employee employee) {
        try {
            objOs.writeObject(employee);
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }
    }

    public void sendEmployeeId(String employeeId) {
        try {
            objOs.writeObject(employeeId);
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }
    }

    public void sendCustomer(Customer customer) {
        try {
            objOs.writeObject(customer);
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }
    }

    public void sendCustomerId(String customerId) {
        try {
            objOs.writeObject(customerId);
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }
    }

    public void sendProduct(Product product) {
        try {
            objOs.writeObject(product);
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }
    }

    public void sendProductCode(String productCode) {
        try {
            objOs.writeObject(productCode);
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }
    }

    public void sendInvoice(Invoice invoice) {
        try {
            objOs.writeObject(invoice);
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }
    }

    public void sendInvoiceNumber(int invoiceNum) {
        try {
            objOs.writeObject(invoiceNum);
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }
    }

    public void sendPurchase(List<Purchase> purchaseList) {
        try {
            objOs.writeObject(purchaseList);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("IOException: " + e);
        }
    }

    public void sendInventory(List<Inventory> inventoryList) {
        try {
            objOs.writeObject(inventoryList);
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }
    }

    public void sendInventoryInfo(InventoryId inventoryInfo) {
        try {
            objOs.writeObject(inventoryInfo);
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        }
    }

    /**
     * General Responses
     */
    public void receiveResponse() {
        try {
            if (action.equalsIgnoreCase("Add Employee")) {
                Boolean flag = (Boolean) objIs.readObject();
                if (flag) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Record added successfully",
                            "Add Record Status",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Failed to add record",
                            "Add Record Status",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
            if (action.equalsIgnoreCase("Update Employee")) {
                Boolean flag = (Boolean) objIs.readObject();
                if (flag) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Employee updated successfully",
                            "Update Employee Status",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Failed to update record",
                            "Update Employee Status",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
            if (action.equalsIgnoreCase("Remove Employee")) {
                Boolean flag = (Boolean) objIs.readObject();
                if (flag) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Employee removed successfully",
                            "Remove Employee Status",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Failed to remove record",
                            "Remove Employee Status",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
            if (action.equalsIgnoreCase("Add Customer")) {
                Boolean flag = (Boolean) objIs.readObject();
                if (flag) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Record added successfully",
                            "Add Record Status",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Failed to add record",
                            "Add Record Status",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
            if (action.equalsIgnoreCase("Update Customer")) {
                Boolean flag = (Boolean) objIs.readObject();
                if (flag) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Customer updated successfully",
                            "Update Customer Status",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Failed to update record",
                            "Update Customer Status",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
            if (action.equalsIgnoreCase("Remove Customer")) {
                Boolean flag = (Boolean) objIs.readObject();
                if (flag) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Customer removed successfully",
                            "Remove Customer Status",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Failed to remove record",
                            "Remove Customer Status",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
            if (action.equalsIgnoreCase("Add Product")) {
                Boolean flag = (Boolean) objIs.readObject();
                if (flag) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Product added successfully",
                            "Add Product Status",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Product could not be added",
                            "Add Product Status",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
            if (action.equalsIgnoreCase("Update Product")) {
                Boolean flag = (Boolean) objIs.readObject();
                if (flag) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Product updated successfully",
                            "Update Product Status",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Failed to update record",
                            "Update Product Status",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
            if (action.equalsIgnoreCase("Remove Product")) {
                Boolean flag = (Boolean) objIs.readObject();
                if (flag) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Product removed successfully",
                            "Remove Product Status",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Failed to remove record",
                            "Remove Product Status",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
            if (action.equalsIgnoreCase("Add Invoice")) {
                Boolean flag = (Boolean) objIs.readObject();
                if (flag) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Invoice added successfully",
                            "Add Invoice Status",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
            if (action.equalsIgnoreCase("Remove Invoice")) {
                Boolean flag = (Boolean) objIs.readObject();
                if (flag) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Invoice removed successfully",
                            "Remove Invoice Status",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Failed to remove record",
                            "Remove Invoice Status",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
            if (action.equalsIgnoreCase("Add Purchase")) {
                Boolean flag = (Boolean) objIs.readObject();
                if (flag) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Purchase added successfully",
                            "Add Invoice Status",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
            if (action.equalsIgnoreCase("Update Inventory")) {
                Boolean flag = (Boolean) objIs.readObject();
                if (flag) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Inventory updated successfully",
                            "Update Inventory Status",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Failed to update inventory",
                            "Update Inventory Status",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        } catch (IOException e) {
            System.err.println("IOException: " + e);
        } catch (ClassNotFoundException e) {
            System.err.println("ClassNotFoundException: " + e);
        } catch (ClassCastException e) {
            System.err.println("ClassCastException: " + e);
        }
    }

    /**
     * Find Responses
     */
    public Employee receiveFindEmployeeResponse() {
        Employee employee = new Employee();
        if (action.equalsIgnoreCase("Find Employee")) {
            try {
                employee = (Employee) objIs.readObject();
                if (employee == null) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Employee record not found",
                            "Search Result",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            } catch (IOException e) {
                System.err.println("IOException: " + e);
            } catch (ClassNotFoundException e) {
                System.err.println("ClassNotFoundException: " + e);
            } catch (ClassCastException e) {
                System.err.println("ClassCastException: " + e);
            }
        }
        return employee;
    }

    public Customer receiveFindCustomerResponse() {
        Customer customer = new Customer();
        if (action.equalsIgnoreCase("Find Customer")) {
            try {
                customer = (Customer) objIs.readObject();
                if (customer == null) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Customer record not found",
                            "Search Result",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            } catch (IOException e) {
                System.err.println("IOException: " + e);
            } catch (ClassNotFoundException e) {
                System.err.println("ClassNotFoundException: " + e);
            } catch (ClassCastException e) {
                System.err.println("ClassCastException: " + e);
            }
        }
        return customer;
    }

    public Product receiveFindProductResponse() {
        Product product = new Product();
        if (action.equalsIgnoreCase("Find Product")) {
            try {
                product = (Product) objIs.readObject();
                if (product == null) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Product record not found",
                            "Search Result",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            } catch (IOException e) {
                System.err.println("IOException: " + e);
            } catch (ClassNotFoundException e) {
                System.err.println("ClassNotFoundException: " + e);
            } catch (ClassCastException e) {
                System.err.println("ClassCastException: " + e);
            }
        }
        return product;
    }

    public Invoice receiveFindInvoiceResponse() {
        Invoice invoice = new Invoice();
        if (action.equalsIgnoreCase("Find Invoice")) {
            try {
                invoice = (Invoice) objIs.readObject();
                if (invoice == null) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Invoice not found",
                            "Search Result",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            } catch (IOException e) {
                System.err.println("IOException: " + e);
            } catch (ClassNotFoundException e) {
                System.err.println("ClassNotFoundException: " + e);
            } catch (ClassCastException e) {
                System.err.println("ClassCastException: " + e);
            }
        }
        return invoice;
    }

    /**
     * View Responses
     */
    public Inventory receiveViewInventoryItemResponse() {
        Inventory inventory = new Inventory();
        if (action.equalsIgnoreCase("View Inventory Item")) {
            try {
                inventory = (Inventory) objIs.readObject();
            } catch (IOException e) {
                System.err.println("IOException: " + e);
            } catch (ClassNotFoundException e) {
                System.err.println("ClassNotFoundException: " + e);
            } catch (ClassCastException e) {
                System.err.println("ClassCastException: " + e);
            }
        }
        return inventory;
    }

    public List<Employee> receiveViewEmployeeResponse() {
        List<Employee> employeeList = new ArrayList<>();
        Employee employee;
        if (action.equalsIgnoreCase("View Employees")) {
            try {
                while (true) {
                    employee = (Employee) objIs.readObject();
                    if (employee != null) {
                        employeeList.add(employee);
                    } else {
                        break;
                    }
                }
            } catch (IOException e) {
                System.err.println("IOException: " + e);
            } catch (ClassNotFoundException e) {
                System.err.println("ClassNotFoundException: " + e);
            } catch (ClassCastException e) {
                System.err.println("ClassCastException: " + e);
            }
        }
        return employeeList;
    }

    public List<Customer> receiveViewCustomersResponse() {
        List<Customer> customerList = new ArrayList<>();
        Customer customer;
        if (action.equalsIgnoreCase("View Customers")) {
            try {
                while (true) {
                    customer = (Customer) objIs.readObject();
                    if (customer != null) {
                        customerList.add(customer);
                    } else {
                        break;
                    }
                }
            } catch (IOException e) {
                System.err.println("IOException: " + e);
            } catch (ClassNotFoundException e) {
                System.err.println("ClassNotFoundException: " + e);
            } catch (ClassCastException e) {
                System.err.println("ClassCastException: " + e);
            }
        }
        return customerList;
    }

    public List<Product> receiveViewProductsResponse() {
        List<Product> productList = new ArrayList<>();
        Product product;
        if (action.equalsIgnoreCase("View Products")) {
            try {
                while (true) {
                    product = (Product) objIs.readObject();
                    if (product != null) {
                        productList.add(product);
                    } else {
                        break;
                    }
                }
            } catch (IOException e) {
                System.err.println("IOException: " + e);
            } catch (ClassNotFoundException e) {
                System.err.println("ClassNotFoundException: " + e);
            } catch (ClassCastException e) {
                System.err.println("ClassCastException: " + e);
            }
        }
        return productList;
    }

    public List<Invoice> receiveViewInvoiceResponse() {
        List<Invoice> invoiceList = new ArrayList<>();
        Invoice invoice;
        if (action.equalsIgnoreCase("View Invoices")) {
            try {
                while (true) {
                    invoice = (Invoice) objIs.readObject();
                    if (invoice != null) {
                        invoiceList.add(invoice);
                    } else {
                        break;
                    }
                }
            } catch (IOException e) {
                System.err.println("IOException: " + e);
            } catch (ClassNotFoundException e) {
                System.err.println("ClassNotFoundException: " + e);
            } catch (ClassCastException e) {
                System.err.println("ClassCastException: " + e);
            }
        }
        return invoiceList;
    }

    public List<Purchase> receiveViewInvoiceItemResponse() {
        List<Purchase> purchaseList = new ArrayList<>();
        Purchase purchase;
        if (action.equalsIgnoreCase("View Purchase")) {
            try {
                while (true) {
                    purchase = (Purchase) objIs.readObject();
                    if (purchase != null) {
                        purchaseList.add(purchase);
                    } else {
                        break;
                    }
                }
            } catch (IOException e) {
                System.err.println("IOException: " + e);
            } catch (ClassNotFoundException e) {
                System.err.println("ClassNotFoundException: " + e);
            } catch (ClassCastException e) {
                System.err.println("ClassCastException: " + e);
            }
        }
        return purchaseList;
    }
}
