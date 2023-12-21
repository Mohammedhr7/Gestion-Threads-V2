package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankView extends JFrame {

    private JTabbedPane tabbedPane;
    private JButton addButton1, addButton2;
    private JButton editButton1, editButton2;
    private JButton deleteButton1, deleteButton2;
    private JButton displayButton1, displayButton2;
    private JButton effectuer, enregistrer;

    private JTable table1, table2;
    private DefaultTableModel model1, model2;
    private JTextField textField2, textField3, textField1;
    private JTextField t2, t3, t1;
    private ButtonGroup buttonGroup;

    // getters & setters

    public JButton getEnregistrer() {
        return enregistrer;
    }

    public void setEnregistrer(JButton enregistrer) {
        this.enregistrer = enregistrer;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public void setTabbedPane(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    public JButton getAddButton1() {
        return addButton1;
    }

    public void setAddButton1(JButton addButton1) {
        this.addButton1 = addButton1;
    }

    public JButton getAddButton2() {
        return addButton2;
    }

    public void setAddButton2(JButton addButton2) {
        this.addButton2 = addButton2;
    }

    public JButton getEditButton1() {
        return editButton1;
    }

    public void setEditButton1(JButton editButton1) {
        this.editButton1 = editButton1;
    }

    public JButton getEditButton2() {
        return editButton2;
    }

    public void setEditButton2(JButton editButton2) {
        this.editButton2 = editButton2;
    }

    public JButton getDeleteButton1() {
        return deleteButton1;
    }

    public void setDeleteButton1(JButton deleteButton1) {
        this.deleteButton1 = deleteButton1;
    }

    public JButton getDeleteButton2() {
        return deleteButton2;
    }

    public void setDeleteButton2(JButton deleteButton2) {
        this.deleteButton2 = deleteButton2;
    }

    public JButton getDisplayButton1() {
        return displayButton1;
    }

    public void setDisplayButton1(JButton displayButton1) {
        this.displayButton1 = displayButton1;
    }

    public JButton getDisplayButton2() {
        return displayButton2;
    }

    public void setDisplayButton2(JButton displayButton2) {
        this.displayButton2 = displayButton2;
    }

    public JButton getEffectuer() {
        return effectuer;
    }

    public void setEffectuer(JButton effectuer) {
        this.effectuer = effectuer;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JTable getTable2() {
        return table2;
    }

    public void setTable2(JTable table2) {
        this.table2 = table2;
    }

    public DefaultTableModel getModel1() {
        return model1;
    }

    public void setModel1(DefaultTableModel model1) {
        this.model1 = model1;
    }

    public DefaultTableModel getModel2() {
        return model2;
    }

    public void setModel2(DefaultTableModel model2) {
        this.model2 = model2;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public void setTextField2(JTextField textField2) {
        this.textField2 = textField2;
    }

    public JTextField getTextField3() {
        return textField3;
    }

    public void setTextField3(JTextField textField3) {
        this.textField3 = textField3;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JTextField getT2() {
        return t2;
    }

    public void setT2(JTextField t2) {
        this.t2 = t2;
    }

    public JTextField getT3() {
        return t3;
    }

    public void setT3(JTextField t3) {
        this.t3 = t3;
    }

    public JTextField getT1() {
        return t1;
    }

    public void setT1(JTextField t1) {
        this.t1 = t1;
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }

    public BankView() {

        tabbedPane = new JTabbedPane();

        // panel 1
        JPanel accountPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel1 = new JPanel();
        JPanel attributePanel1 = new JPanel(new GridLayout(4, 2));

        addButton1 = new JButton("Create a new element");
        editButton1 = new JButton("Update an element");
        deleteButton1 = new JButton("Remove an element");
        displayButton1 = new JButton("Display All elements");
        effectuer = new JButton("Effectuer Transaction");

        Font buttonFont = new Font("Arial", Font.PLAIN, 14);

        addButton1.setFont(buttonFont);
        editButton1.setFont(buttonFont);
        deleteButton1.setFont(buttonFont);
        displayButton1.setFont(buttonFont);
        effectuer.setFont(buttonFont);

        buttonPanel1.add(addButton1);
        buttonPanel1.add(editButton1);
        buttonPanel1.add(deleteButton1);
        buttonPanel1.add(displayButton1);
        buttonPanel1.add(effectuer);

        JLabel label1 = new JLabel("IdHolder");
        textField1 = new JTextField();
        JLabel label2 = new JLabel("Balance");
        textField2 = new JTextField();
        JLabel label3 = new JLabel("NextAccountNumber");
        textField3 = new JTextField();

        attributePanel1.add(label1);
        attributePanel1.add(textField1);
        attributePanel1.add(label2);
        attributePanel1.add(textField2);
        attributePanel1.add(label3);
        attributePanel1.add(textField3);

        table1 = new JTable();
        model1 = new DefaultTableModel(
                new Object[] { "full_name", "Account_Number", "Balance" }, 0);
        table1.setModel(model1);

        Font tableFont = new Font("Arial", Font.PLAIN, 12);
        table1.setFont(tableFont);

        JTableHeader header1 = table1.getTableHeader();
        header1.setFont(new Font("Arial", Font.BOLD, 14));

        accountPanel.add(buttonPanel1, BorderLayout.NORTH);
        accountPanel.add(attributePanel1, BorderLayout.CENTER);
        accountPanel.add(new JScrollPane(table1), BorderLayout.SOUTH);

        // panel 2
        // :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
        JPanel transactionPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel2 = new JPanel();
        JPanel attributePanel2 = new JPanel(new GridLayout(3, 2));
        JPanel p3 = new JPanel(new FlowLayout());

        addButton2 = new JButton("Create a new element");
        editButton2 = new JButton("Update an element");
        deleteButton2 = new JButton("Remove an element");
        displayButton2 = new JButton("Display All elements");
        enregistrer = new JButton("Save all Data");

        buttonGroup = new ButtonGroup();

        addButton2.setFont(buttonFont);
        editButton2.setFont(buttonFont);
        deleteButton2.setFont(buttonFont);
        displayButton2.setFont(buttonFont);
        enregistrer.setFont(buttonFont);

        buttonPanel2.add(addButton2);
        buttonPanel2.add(editButton2);
        buttonPanel2.add(deleteButton2);
        buttonPanel2.add(displayButton2);
        buttonPanel2.add(enregistrer);

        JLabel l1 = new JLabel("Amount");
        t1 = new JTextField();
        JLabel l2 = new JLabel("SourceAccount");
        t2 = new JTextField();
        JLabel l3 = new JLabel("TargetAccount");
        t3 = new JTextField();

        // ::::::::::::::::::::::::::::::::::::::::::::::::::::: radio

        JRadioButton option1 = new JRadioButton("DEPOT");
        JRadioButton option2 = new JRadioButton("TRANSFERT");
        JRadioButton option3 = new JRadioButton("RETRAIT");

        buttonGroup.add(option1);
        buttonGroup.add(option2);
        buttonGroup.add(option3);

        p3.add(option1);
        p3.add(option2);
        p3.add(option3);

        //

        attributePanel2.add(l1);
        attributePanel2.add(t1);
        attributePanel2.add(l2);
        attributePanel2.add(t2);
        attributePanel2.add(l3);
        attributePanel2.add(t3);

        table2 = new JTable();
        model2 = new DefaultTableModel(
                new Object[] { "Amount", "Date", "Type", "SourceAccount", "TargetAccount", "Full_Name", "email" }, 0);
        table2.setModel(model2);
        table2.setFont(tableFont);

        JTableHeader header2 = table2.getTableHeader();
        header2.setFont(new Font("Arial", Font.BOLD, 14));

        // ordonn

        JPanel containerPanel = new JPanel(new BorderLayout());

        containerPanel.add(attributePanel2, BorderLayout.CENTER);
        containerPanel.add(p3, BorderLayout.SOUTH);

        transactionPanel.add(buttonPanel2, BorderLayout.NORTH);
        transactionPanel.add(containerPanel, BorderLayout.CENTER);
        transactionPanel.add(new JScrollPane(table2), BorderLayout.SOUTH);

        tabbedPane.addTab("Account", accountPanel);
        tabbedPane.addTab("Transaction", transactionPanel);

        add(tabbedPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        // login
        effectuer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedIndex(1);
            }
        });
    }

    public static void main(String[] args) {
        new BankView();
    }

}
