package it.view.GUI.Login;

import it.actionListener.Loginlistener.LoginListener;
import it.view.CardLayout.LoginPassFrame;
import it.view.CardLayout.PrincUtentereg;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    private JTextField txtUsername = new JTextField();
    private JPasswordField txtPassword = new JPasswordField();

    public LoginPanel(LoginPassFrame finestra, PrincUtentereg finestraprinc) {
        super();

        LoginListener listen = new LoginListener(finestra,this,finestraprinc);
        this.setLayout(new BorderLayout());
        JPanel north = new JPanel();
        north.add(new JLabel("Benvenuto"));
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(2, 2));
        JLabel lblUsername = new JLabel("Username");
        JLabel lblPassword = new JLabel("Password");
        centro.add(lblUsername);
        centro.add(txtUsername);
        centro.add(lblPassword);
        centro.add(txtPassword);
        txtUsername.addActionListener(listen);
        txtPassword.addActionListener(listen);
        JPanel sud = new JPanel();
        sud.setLayout(new FlowLayout());
        JButton btPassDimenticata = new JButton("Password dimenticata");
        btPassDimenticata.addActionListener(listen);
        btPassDimenticata.setActionCommand("PASSWORD_DIMENTICATA");
        sud.add(btPassDimenticata);
        JButton lgbutton = new JButton("Login");
        lgbutton.addActionListener(listen);
        lgbutton.setActionCommand("LOGGA");
        sud.add(lgbutton);
        this.add(north, BorderLayout.NORTH);
        this.add(centro, BorderLayout.WEST);
        this.add(sud, BorderLayout.SOUTH);
        //this.setLayout(new FlowLayout());
        setSize(300, 150);
        this.setOpaque(true);

    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }
}
