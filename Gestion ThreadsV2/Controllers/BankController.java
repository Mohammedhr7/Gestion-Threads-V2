package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

import DAO.accountDao;
import DAO.bankTransactionDao;
import DAO.personDa;
import models.Account;
import models.BankTransaction;
import views.BankView;
import views.login;
import views.user;

import java.util.Random;

public class BankController {

    // Attributs

    private accountDao accDao;
    private BankView view;
    private bankTransactionDao bDao;
    private login log;
    private personDa dao;

    // Constructeur

    public BankController(accountDao accDao, BankView view, bankTransactionDao bDao) {
        this.accDao = accDao;
        this.view = view;
        this.bDao = bDao;

        // .................................createaccount...................................................

        view.getAddButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent i) {

                Account a;
                try {

                    int IdHolder = Integer.parseInt(view.getTextField1().getText());
                    Double balance = Double.parseDouble(view.getTextField2().getText());
                    String accountNumber = genererChaineAleatoire();
                    String next = view.getTextField3().getText();

                    System.out.println("ok:\n" + IdHolder);
                    System.out.println("ok:\n" + balance);
                    System.out.println("ok:\n" + accountNumber);
                    System.out.println("ok:\n" + next);

                    a = new Account(accountNumber, IdHolder, balance, next);
                    accDao.createAccount(a);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // ...........................deleteaccount.......................................................................

        view.getDeleteButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowIndex = view.getTable1().getSelectedRow();

                if (rowIndex != -1) {
                    DefaultTableModel model = (DefaultTableModel) view.getTable1().getModel();

                    model.removeRow(rowIndex);
                    accDao.deleteAcount(rowIndex);

                    System.out.println("Entity deleted successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a row first!");
                }
            }
        });

        // .................................................displayAccounts.............................................................

        view.getDisplayButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Object[]> l = accDao.getAllAccount();
                // System.out.println("eeew");
                DefaultTableModel model = (DefaultTableModel) view.getTable1().getModel();

                for (Object[] row : l) {
                    model.addRow(row);
                }
            }
        });

        // ...............................................UpdateAccount.............................................

        view.getEditButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
        });

        // :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

        // .......................createTransaction.........................................;

        view.getAddButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedOption = getSelectedButtonText(view.getButtonGroup());

                BankTransaction t = new BankTransaction(
                        Double.parseDouble(view.getT1().getText()),
                        new Date(System.currentTimeMillis()),
                        selectedOption,
                        view.getT2().getText(),
                        view.getT3().getText());

                System.out.println("\n" + Double.parseDouble(view.getT1().getText()));
                System.out.println("\n" + new Date(System.currentTimeMillis()));
                System.out.println("\n" + selectedOption);
                System.out.println("\n" + view.getT2().getText());
                System.out.println("\n" + view.getT3().getText());

                bDao.createBanqueTransaction(t);
            }
        });

        // ...........................;;;;;display Transactions
        // ..........................

        view.getDisplayButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Object[]> l;
                try {
                    l = bDao.getAllBankTransactions();
                    DefaultTableModel model = (DefaultTableModel) view.getTable2().getModel();

                    for (Object[] row : l) {
                        model.addRow(row);
                    }
                } catch (SQLException e1) {

                    e1.printStackTrace();
                }

            }
        });

        // :::::::::::::::::::::::::::::::::save
        // ::::::::::::::::::::::::::::::::::::::::::
        view.getEnregistrer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Object[]> l = new ArrayList<>();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");

                try {

                    l = bDao.getAllBankTransactions();
                    // if (l != null)
                    // System.out.println("ooooooo");

                    String filePath = "C:\\Users\\hp\\Desktop\\TP java-av\\TP4.txt";

                    FileWriter writer = new FileWriter(filePath, true);

                    for (Object[] row : l) {

                        for (Object element : row) {
                            if (element != null)
                                writer.write(element.toString() + "\t");
                        }
                        writer.write("\n");
                    }

                    writer.write(
                            "**********************************END OF  SECTION*********************************************************\n");
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Data Saved to the file!");
                } catch (Exception a) {
                    a.printStackTrace();
                }
            }
        });

    }

    // ////////////////////////////////////////////:::

    public BankController(login log, personDa dao) {
        this.log = log;
        this.dao = dao;
        log.getB1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String email = log.getTuser().getText();
                String password = log.getTpass().getText();

                if (dao.isAdmin(email, password)) {

                    new BankController(new accountDao(), new BankView(), new bankTransactionDao());

                } else {
                    new user();
                }

            }
        });
    }

    // .........................Main..................................................
    public static void main(String[] args) {

        new BankController(new accountDao(), new BankView(), new bankTransactionDao());

        // new BankController(new login(), new personDa());

    }

    // random pour generer
    // Rib...........................................................................

    public static String genererChaineAleatoire() {

        char letre = (char) ('A' + new Random().nextInt(26));

        StringBuilder chiffres = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            chiffres.append(random.nextInt(10));
        }

        StringBuilder resultat = new StringBuilder();
        resultat.append(letre);
        resultat.append(chiffres);

        return resultat.toString();
    }

    //
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

}
