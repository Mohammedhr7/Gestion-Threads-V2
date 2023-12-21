
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class personDa {

    public personDa() {

    }

    public boolean isAdmin(String email, String pass) {
        Connection con;
        Statement st;
        String query;
        ResultSet rsp;
        String xt;

        try {
            con = connection.getConnection();

            query = "SELECT *  from person where email  like  '" + email + "' ";

            st = con.createStatement();

            rsp = st.executeQuery(query);

            rsp.next();
            System.out.println("\n" + rsp.getString("email"));
            System.out.println("\n" + rsp.getString("password"));
            System.out.println("\n" + rsp.getString("flag"));

            if (rsp != null && pass.equals(rsp.getString("password"))) {

                if (rsp.getInt("flag") == 1) {
                    return true;
                } else {
                    System.out.println("bye");
                    return false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

}
