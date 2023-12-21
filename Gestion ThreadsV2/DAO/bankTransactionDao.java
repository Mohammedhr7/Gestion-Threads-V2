package DAO;

import java.sql.*;
import java.util.ArrayList;

import models.BankTransaction;

public class bankTransactionDao implements IBankTransactionDAO {

    // ..................................................createTransaction.................................................

    @Override
    public void createBanqueTransaction(BankTransaction transaction) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = connection.getConnection();
            String query = "INSERT INTO BankTransaction (amount, date, type, sourceAccountNumber, targetAccountNumber) VALUES (?, ?, ?, ?, ?)";

            pstmt = conn.prepareStatement(query);
            pstmt.setDouble(1, transaction.getAmount());
            pstmt.setDate(2, new Date(System.currentTimeMillis()));
            pstmt.setString(3, transaction.getType());
            pstmt.setString(4, transaction.getSourceAccountNumber());
            pstmt.setString(5, transaction.getTargetAccountNumber());

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Transaction created successfully!");
            } else {
                System.out.println("Failed to create transaction.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ..................................................getTransaction.................................................

    @Override
    public BankTransaction geTransactionById(int transactionId) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        BankTransaction transaction = null;

        try {
            conn = connection.getConnection();
            String query = "SELECT * FROM BankTransaction WHERE transactionId = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, transactionId);

            rs = pstmt.executeQuery();

            if (rs.next()) {

                // double amount = rs.getDouble("amount");
                // java.sql.Date date = rs.getDate("date");
                // String type = rs.getString("type");
                // String sourceAccountNumber = rs.getString("sourceAccountNumber");
                // String targetAccountNumber = rs.getString("targetAccountNumber");

                // transaction = new BankTransaction(amount, date,
                // TransactionType.valueOf(type),
                // sourceAccountNumber, targetAccountNumber);

                // System.out.println("Transaction ID: " + transactionId);
                // System.out.println("Amount: " + amount);
                // System.out.println("Date: " + date);
                // System.out.println("Type: " + type);
                // System.out.println("Source Account Number: " + sourceAccountNumber);
                // System.out.println("Target Account Number: " + targetAccountNumber);

            } else {
                System.out.println("No transaction found with ID: " + transactionId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transaction;
    }

    // get all transaction
    // (person+account+transaction)..................................

    public ArrayList<Object[]> getAllBankTransactions() throws SQLException {
        ArrayList<Object[]> l = new ArrayList<>();

        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;

        try {
            conn = connection.getConnection();

            String query = "SELECT * FROM BankTransaction " +
                    "JOIN Account ON BankTransaction.sourceAccountNumber = Account.Account_Number " +
                    "JOIN Person ON Account.accountHolder = Person.id";

            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                double amount = rs.getDouble("amount");
                java.sql.Date date = rs.getDate("date");
                String type = rs.getString("type");
                String sourceAccountNumber = rs.getString("sourceAccountNumber");
                String targetAccountNumber = rs.getString("targetAccountNumber");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");

                // System.out.println("email:"+email);

                Object[] row = { amount, date, type, sourceAccountNumber, targetAccountNumber,
                        firstName + " " + lastName, email };
                l.add(row);
            }
            System.out.println("cool");

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return l;
    }

    public static void main(String[] args) throws SQLException {
        // bankTransactionDao c = new bankTransactionDao();
        // c.getAllBankTransactions();

    }

}
