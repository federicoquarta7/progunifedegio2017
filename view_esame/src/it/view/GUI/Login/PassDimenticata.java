package it.view.GUI.Login;

import it.actionListener.Loginlistener.PassDimListener;
import it.view.CardLayout.LoginPassFrame;

import javax.swing.*;
import java.awt.*;

public class PassDimenticata extends JPanel {
    private JTextField txtemail=new JTextField();

    public PassDimenticata(LoginPassFrame finestra){

        super();
        PassDimListener listen = new PassDimListener( finestra,this);

        this.setLayout(new BorderLayout());
        JPanel centro=new JPanel();
        centro.setLayout(new GridLayout(2, 2));
        JLabel lbemail=new JLabel("Email:");
        centro.add(lbemail);
        centro.add(txtemail);

        JButton btBack=new JButton("Indietro");
        btBack.addActionListener(listen);
        btBack.setActionCommand("BACK");
        centro.add(btBack);

        JButton btNext= new JButton("Avanti");
        btNext.addActionListener(listen);
        btNext.setActionCommand("MANDA_EMAIL_RESET");
        centro.add(btNext);


        this.add(centro,BorderLayout.CENTER);

        this.setLayout(new FlowLayout());
        setSize(300, 150);
        this.setOpaque(true);
        setVisible(true);

    }

    public JTextField getTxtemail() {
        return txtemail;
    }
}
