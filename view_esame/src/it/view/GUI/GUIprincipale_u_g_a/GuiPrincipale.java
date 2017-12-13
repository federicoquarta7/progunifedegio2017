package it.view.GUI.GUIprincipale_u_g_a;

import it.view.CardLayout.LoginPassFrame;
import it.view.CardLayout.PrincUtentereg;
import it.view.GUI.Prod_carr_pani.ProdottoPanel;
import it.view.GUI.Registrazione;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiPrincipale extends JPanel{
    public GuiPrincipale(PrincUtentereg finestraprinc){
        super();
        this.setLayout(new BorderLayout());

        JPanel north =new JPanel();
            north.setLayout(new FlowLayout());
            JButton btlogin = new JButton("Login");
            btlogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new LoginPassFrame(finestraprinc);
                }
            });
            north.add(btlogin);
            JButton btregistrazione = new JButton("Registrati");
            btregistrazione.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Registrazione();
                }
            });
            north.add(btregistrazione);
        this.add(north,BorderLayout.NORTH);

        JPanel centro=new JPanel();
            centro.setLayout(new GridLayout(4,4));
            for(int i=1;i<=10; i++) {
                centro.add(new ProdottoPanel());
            }
        this.add(centro,BorderLayout.CENTER);

        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setViewportView(centro);
        scrollPane.getVerticalScrollBar().setUnitIncrement(17);
        this.add(scrollPane);

    }
}
