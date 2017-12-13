package it.view.CardLayout;

import it.view.GUI.Login.LoginFrame;
import it.view.GUI.Login.PassDimenticata;

import javax.swing.*;
import java.awt.*;

public class LoginPassFrame extends JFrame {
    private JFrame frame=new JFrame("Login");
    private JPanel panelcont=new JPanel();
    private CardLayout cl=new CardLayout();
    public LoginPassFrame(PrincUtentereg finestraprinc){
        panelcont.setLayout(cl);
        panelcont.add(new LoginFrame(this,finestraprinc),"1");
        panelcont.add(new PassDimenticata(this),"2");
        cl.show(panelcont,"1");
        frame.add(panelcont);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300,150);
        frame.setVisible(true);


    }

    public JPanel getPanelcont() {
        return panelcont;
    }
    public CardLayout getCl() {
        return cl;
    }
}

