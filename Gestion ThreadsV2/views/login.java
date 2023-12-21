package views;

import javax.swing.*;

public class login extends JFrame {

    private JTextField tuser, tpass;
    private JPanel p1, p2, p3, p4;
    private JButton b1, b2;
    private JLabel luser, lpass;

    public JTextField getTuser() {
        return tuser;
    }

    public void setTuser(JTextField tuser) {
        this.tuser = tuser;
    }

    public JTextField getTpass() {
        return tpass;
    }

    public void setTpass(JTextField tpass) {
        this.tpass = tpass;
    }

    public JPanel getP1() {
        return p1;
    }

    public void setP1(JPanel p1) {
        this.p1 = p1;
    }

    public JPanel getP2() {
        return p2;
    }

    public void setP2(JPanel p2) {
        this.p2 = p2;
    }

    public JPanel getP3() {
        return p3;
    }

    public void setP3(JPanel p3) {
        this.p3 = p3;
    }

    public JPanel getP4() {
        return p4;
    }

    public void setP4(JPanel p4) {
        this.p4 = p4;
    }

    public JButton getB1() {
        return b1;
    }

    public void setB1(JButton b1) {
        this.b1 = b1;
    }

    public JButton getB2() {
        return b2;
    }

    public void setB2(JButton b2) {
        this.b2 = b2;
    }

    public JLabel getLuser() {
        return luser;
    }

    public void setLuser(JLabel luser) {
        this.luser = luser;
    }

    public JLabel getLpass() {
        return lpass;
    }

    public void setLpass(JLabel lpass) {
        this.lpass = lpass;
    }

    public login() {

        tuser = new JTextField(20);
        tpass = new JTextField(20);
        b1 = new JButton("login");
        b2 = new JButton("register");
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();

        luser = new JLabel("username    ");
        lpass = new JLabel("password    ");

        p1.add(luser);
        p1.add(tuser);
        p2.add(lpass);
        p2.add(tpass);
        p3.add(b1);
        p3.add(b2);
        p4.add(p1);
        p4.add(p2);
        p4.add(p3);

        this.add(p4);
        this.setVisible(true);
        this.setSize(400, 300);

    }

    public static void main(String[] args) {
        new login();
    }

}
