package it.view.GUI.GUIprincipale_u_g_a.utentereg;

import it.DAO.mysql.ProdottoDAO;
import it.actionListener.Guiprinc_listener.PrincipaleListener;
import it.actionListener.Loginlistener.LoginListener;
import it.model.Prodotto;
import it.model.Utentereg;
import it.utility.SessionManager;
import it.view.CardLayout.LoginPassFrame;
import it.view.CardLayout.PrincUtentereg;
import it.view.GUI.GUIprincipale_u_g_a.GuiPrincipale;
import it.view.GUI.Login.LoginPanel;
import it.view.GUI.Prod_carr_pani.ProdottoPanel;
import it.view.GUI.Registrazione;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiCUPrezzo extends JPanel {
    public GuiCUPrezzo(PrincUtentereg princUtentereg) {
        super();
        this.setLayout(new BorderLayout());
        LoginPassFrame lpf=new LoginPassFrame(princUtentereg);
        LoginListener ll=new LoginListener(lpf,new LoginPanel(lpf,princUtentereg),princUtentereg);
        boolean value=ll.isLogin();
        if ((value==true)) {
            this.add(new Login(princUtentereg),BorderLayout.NORTH);
        }
        else {
            this.add(new Benvenuto(princUtentereg), BorderLayout.NORTH);
        }
        PrincipaleListener pl= new PrincipaleListener(princUtentereg);
        ArrayList<Prodotto> listaprodotti=ProdottoDAO.getInstance().findbycosto(pl.getPrezzo());
        JPanel centro=new JPanel();
        centro.setLayout(new GridLayout(4,4));
        for(int i=0;i<listaprodotti.size(); i++) {
            Prodotto prodotto=listaprodotti.get(i);
            centro.add(new ProdottoPanel(prodotto));
        }
        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setViewportView(centro);
        scrollPane.getVerticalScrollBar().setUnitIncrement(17);
        this.add(scrollPane);
        this.add(centro,BorderLayout.CENTER);

    }
    public class Benvenuto extends JPanel {
        GuiCUPrezzo.Benvenuto _this = this;
        public Benvenuto(PrincUtentereg finestraprinc) {
            super();
            _this.setLayout(new BorderLayout());
            Utentereg utentereg = (Utentereg) SessionManager.getInstance().getSession().get("utente");
            try {
                _this.add(new JLabel("Benvenuto " + utentereg.getNome() + " " + utentereg.getCognome()), BorderLayout.WEST);
            } catch (Exception e) {
                _this.add(new JLabel("Benvenuto utente"), BorderLayout.WEST);
            }
            JPanel est = new JPanel();
            JButton btLogout = new JButton("Logout");
            btLogout.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    finestraprinc.getClp().show(finestraprinc.getPanelcontprinc(), "1");
                }
            });
            JButton carrello = new JButton("Il tuo carrello");
            JButton panieri = new JButton("I tuoi panieri");
            est.add(btLogout);
            est.add(carrello);
            est.add(panieri);
            _this.add(est, BorderLayout.EAST);
        }
    }
    public class Login extends JPanel{
        GuiCUPrezzo.Login _this=this;
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
