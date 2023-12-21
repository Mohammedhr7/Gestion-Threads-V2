package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class user extends JFrame {

    JTextField t1, t2, t3;
    JButton addButton2, editButton2, deleteButton2, displayButton2, enregistrer;
    ButtonGroup buttonGroup;
    JTable table2, table4;
    DefaultTableModel model2, model4;
    JPanel pt = new JPanel();
    JPanel pcentre = new JPanel();

    public user() {
        setTitle("app");
        setDefaultCloseOperation(3);
        setSize(1000, 1200);
        setVisible(true);
        JPanel transactionPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel2 = new JPanel();
        JPanel attributePanel2 = new JPanel(new GridLayout(3, 2));
        JPanel p3 = new JPanel(new FlowLayout());

        addButton2 = new JButton("Create a new element");
        // editButton2 = new JButton("Update an element");
        // deleteButton2 = new JButton("Remove an element");
        displayButton2 = new JButton("Display All elements");
        // enregistrer = new JButton("Save all Data");

        buttonGroup = new ButtonGroup();

        buttonPanel2.add(addButton2);
        // buttonPanel2.add(editButton2);
        // buttonPanel2.add(deleteButton2);
        buttonPanel2.add(displayButton2);
        // buttonPanel2.add(enregistrer);

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

        table4 = new JTable();
        model4 = new DefaultTableModel(
                new Object[] { "Amount", "Date", "Type", "SourceAccount", "TargetAccount", "Full_Name", "email" }, 0);
        table4.setModel(model4);

        JTableHeader header2 = table2.getTableHeader();
        JTableHeader header4 = table4.getTableHeader();
        pcentre.add(header2);
        pcentre.add(header4);

        pt.setLayout(new GridLayout(4, 1, 20, 20));
        pt.add(buttonPanel2);
        pt.add(attributePanel2);
        pt.add(p3);
        pt.add(pcentre);

        add(pt);

    }

    public static void main(String[] args) {
        new user();
    }

}
