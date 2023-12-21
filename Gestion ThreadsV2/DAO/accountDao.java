package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Account;

public class accountDao implements IAccountDao {

    // ...........................................................AddAccount...................................................................

    @Override
    public void createAccount(Account a) {

        int idHolder = a.getAccountHolder();
        Double balance = a.getBalance();
        String next = a.getNextAccountNumber();
        String xt = a.getAccount_Number();

        Connection conn;

        try {
            conn = connection.getConnection();

            String query = "INSERT INTO Account VALUES (?, ?, ?, ?)";

            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, xt);
                pstmt.setInt(2, idHolder);
                pstmt.setDouble(3, balance);
                pstmt.setString(4, next);

                pstmt.executeUpdate();

                System.out.println("Account Created successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ....................................................getaccount................................................
    @Override
    public Account getAccount(int accountId) {

        Connection con;
        Statement st;
        ResultSet rs;
        Account account = null;

        try {
            con = connection.getConnection();

            String sql = "SELECT   Account.Account_Number, Account.balance, Person.first_name, Person.last_name " +
                    "FROM Account " +
                    "JOIN Person ON Account.accountHolder = Person.id " +
                    "WHERE Account.accountHolder = " + accountId;

            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                System.out.println("AccountNumber:\n" + rs.getString("Account_Number"));
                System.out.println("Balance:\n" + rs.getDouble("balance"));
                System.out.println("Full_name:\n" + rs.getString("first_name") + " " +
                        rs.getString("last_name"));

                String xt = rs.getString("first_name").concat(rs.getString("last_name"));

                account = new Account(
                        rs.getString("Account_Number"),
                        accountId,
                        rs.getDouble("balance"), xt);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(account);
        return account;
    }

    // ............................................................update..................................................................

    @Override
    public void updateAccount(Account account) {

        throw new UnsupportedOperationException("Unimplemented method 'updateAccount'");
    }
    // ........................................................delete.....................................................................;

    @Override
    public void deleteAcount(int accountId) {
        Connection conn = null;
        Statement st = null;

        try {
            conn = connection.getConnection();
            String query = "DELETE FROM Account WHERE id = " + accountId;

            st = conn.createStatement();
            int rowsAffected = st.executeUpdate(query);

            if (rowsAffected > 0) {
                System.out.println("Account Deleted successfully!");
            } else {
                System.out.println("No account found with ID: " + accountId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ................................................Main........................................................................

    public static void main(String[] args) {

        // Account a = new Account("123456789", 2, 1000.00, "987654321");

        // accountDao c = new accountDao();
        // c.createAccount(a);

    }

    // .......................................................................................................................................

    public ArrayList<Object[]> getAllAccount() {

        Connection con;
        Statement st;
        ResultSet rs;
        ArrayList<Object[]> list = new ArrayList<>();

        try {
            con = connection.getConnection();

            String sql = "SELECT   Account.Account_Number, Account.balance, Person.first_name, Person.last_name " +
                    "FROM Account " +
                    "JOIN Person ON Account.accountHolder = Person.id ";

            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                System.out.println("AccountNumber:\n" + rs.getString("Account_Number"));
                System.out.println("Balance:\n" + rs.getDouble("balance"));
                System.out.println("Full_name:\n" + rs.getString("first_name") + " " +
                        rs.getString("last_name"));

                String fullName = rs.getString("first_name") + " " + rs.getString("last_name");

                Object[] accountInfo = { fullName, rs.getString("Account_Number"), rs.getDouble("balance") };
                list.add(accountInfo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}
