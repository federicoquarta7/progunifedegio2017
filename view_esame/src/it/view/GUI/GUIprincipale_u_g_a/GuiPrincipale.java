package it.view.GUI.GUIprincipale_u_g_a;

import it.DAO.mysql.ProdottoDAO;
import it.actionListener.Guiprinc_listener.PrincipaleListener;
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

        this.add(new Login(finestraprinc),BorderLayout.NORTH);

        ArrayList<Prodotto> listaprodotti= ProdottoDAO.getInstance().findAllprod();
        JPanel centro=new JPanel();
            centro.setLayout(new GridLayout(4,4));
            for(int i=0;i<listaprodotti.size(); i++) {
                centro.add(new ProdottoPanel(listaprodotti.get(i)));
            }
        this.add(centro,BorderLayout.CENTER);

        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setViewportView(centro);
        scrollPane.getVerticalScrollBar().setUnitIncrement(17);
        this.add(scrollPane);

    }
    public class Login extends JPanel{
        GuiPrincipale.Login _this=this;
        public Login(PrincUtentereg finestraprinc){
            super();
            _this.setLayout(new BorderLayout());
            JPanel est=new JPanel();
            JButton btlogin = new JButton("Login");
            btlogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new LoginPassFrame(finestraprinc);
                }
            });
            est.add(btlogin);
            JButton btregistrazione = new JButton("Registrati");
            btregistrazione.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Registrazione();
                }
            });
            est.add(btregistrazione);
            _this.add(est,BorderLayout.EAST);

        }
    }
}
