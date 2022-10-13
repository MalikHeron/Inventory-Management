package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private static JButton customerButton;
    private static JButton staffButton;
    private static JButton inventoryButton;
    private static JButton checkOutButton;
    private static JButton exitButton;
    static JPanel rightPanel;
    static JPanel leftPanel;

    public MainScreen() {
        initializeComponents();
        addComponentsToPanels();
        addPanelsToWindow();
        registerListeners();
        setWindowProperties();
    }

    private void initializeComponents() {
        //Button properties
        customerButton = new JButton("Customer");
        customerButton.setFocusPainted(false);
        customerButton.setFont(new Font("times new roman", Font.PLAIN, 18));

        staffButton = new JButton("Staff");
        staffButton.setFocusPainted(false);
        staffButton.setFont(new Font("times new roman", Font.PLAIN, 18));

        inventoryButton = new JButton("Inventory");
        inventoryButton.setFocusPainted(false);
        inventoryButton.setFont(new Font("times new roman", Font.PLAIN, 18));

        checkOutButton = new JButton("Check Out");
        checkOutButton.setFocusPainted(false);
        checkOutButton.setFont(new Font("times new roman", Font.PLAIN, 18));

        exitButton = new JButton("Exit");
        exitButton.setFocusPainted(false);
        exitButton.setFont(new Font("times new roman", Font.PLAIN, 18));

        //Left Panel properties
        leftPanel = new JPanel();
        leftPanel.setBackground(new Color(0, 140, 255));
        leftPanel.setBorder(BorderFactory.createEtchedBorder());
        leftPanel.setFocusable(false);
        leftPanel.setPreferredSize(new Dimension(100, 500));
        GroupLayout leftPanelLayout = new GroupLayout(leftPanel);
        leftPanelLayout.setHorizontalGroup(
                leftPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                                .addContainerGap(100, Short.MAX_VALUE)
                                .addGroup(leftPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(customerButton, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(staffButton, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(inventoryButton, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(checkOutButton, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                                .addGap(93, 93, 93)));
        leftPanelLayout.setVerticalGroup(
                leftPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(leftPanelLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(customerButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(staffButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(inventoryButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(checkOutButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(106, Short.MAX_VALUE))
        );
        leftPanel.setLayout(leftPanelLayout);
        leftPanel.setBounds(0, 0, 350, 500);

        //Right Panel Properties
        rightPanel = new JPanel();
        rightPanel.setBackground(new Color(255, 255, 0));
        rightPanel.setBorder(BorderFactory.createEtchedBorder());
        rightPanel.setMaximumSize(new Dimension(880, 500));
        rightPanel.setMinimumSize(new Dimension(880, 500));
        rightPanel.setPreferredSize(new Dimension(880, 500));
        GroupLayout rightPanelLayout = new GroupLayout(rightPanel);
        rightPanelLayout.setHorizontalGroup(
                rightPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(rightPanelLayout.createSequentialGroup()
                                .addGroup(rightPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(rightPanelLayout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                //.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(rightPanelLayout.createSequentialGroup()
                                                .addGap(183, 183, 183)
                                                //.addComponent(jLabel2))
                                        .addGroup(rightPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                //.addComponent(jLabel3)))
                                .addContainerGap(16, Short.MAX_VALUE))))))
        );
        rightPanelLayout.setVerticalGroup(
                rightPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(rightPanelLayout.createSequentialGroup()
                                .addGap(170, 170, 170)
                                //.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                //.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                //.addComponent(jLabel3)
                                .addContainerGap())
        );
        rightPanel.setLayout(rightPanelLayout);
        rightPanel.setBounds(350, 0, 880, 500);
    }

    public static void addComponentsToPanels() {
        //Add components to panel
        leftPanel.add(customerButton);
        leftPanel.add(staffButton);
        leftPanel.add(inventoryButton);
        leftPanel.add(checkOutButton);
        leftPanel.add(exitButton);
    }

    private void addPanelsToWindow() {
        add(leftPanel);
        add(rightPanel);
    }

    private void setWindowProperties() {
        setLayout(null);
        setSize(1200, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Jan's Wholesale and Retail");
    }

    private void registerListeners() {
        customerButton.addActionListener(this);
        staffButton.addActionListener(this);
        inventoryButton.addActionListener(this);
        checkOutButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(inventoryButton)) {
            JComponent[] inventory = new Inventory().getComponent();
            leftPanel.removeAll();
            leftPanel.add(inventory[0]);
            leftPanel.repaint();
            leftPanel.revalidate();

            rightPanel.removeAll();
            rightPanel.add(inventory[1]);
            rightPanel.repaint();
            rightPanel.revalidate();
        }

        if (e.getSource().equals(exitButton)) {
            boolean isYes;
            int selection = JOptionPane.showConfirmDialog(null, "Do you want to continue?",
                    "Prompt", JOptionPane.YES_NO_OPTION);
            isYes = (selection == JOptionPane.YES_OPTION);
            if (isYes)
                dispose();
        }
    }
}