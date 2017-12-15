package it.view.GUI.GUIprincipale_u_g_a;

import it.DAO.mysql.ProdottoDAO;
import it.model.Prodotto;
import it.view.CardLayout.LoginPassFrame;
import it.view.CardLayout.PrincUtentereg;
import it.view.GUI.Prod_carr_pani.ProdottoPanel;
import it.view.GUI.Registrazione;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

        ArrayList<Prodotto> listaprodotti= ProdottoDAO.getInstance().findAllprod();
        JPanel centro=new JPanel();
            centro.setLayout(new GridLayout(4,4));
            for(int i=1;i<=listaprodotti.size(); i++) {
                Prodotto p=listaprodotti.get(i);
                centro.add(new ProdottoPanel(p));
            }
        this.add(centro,BorderLayout.CENTER);

        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setViewportView(centro);
        scrollPane.getVerticalScrollBar().setUnitIncrement(17);
        this.add(scrollPane);

    }
}
