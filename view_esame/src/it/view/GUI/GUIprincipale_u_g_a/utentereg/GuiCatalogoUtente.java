package it.view.GUI.GUIprincipale_u_g_a.utentereg;

import it.model.Persona;
import it.model.Utentereg;
import it.utility.SessionManager;
import it.view.CardLayout.PrincUtentereg;
import it.view.GUI.GUIprincipale_u_g_a.gestore.GuiCatalogoGestore;
import it.view.GUI.Prod_carr_pani.ProdottoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiCatalogoUtente extends JPanel {

    public GuiCatalogoUtente(PrincUtentereg finestraprinc){
        super();
        this.setLayout(new BorderLayout());
        this.add(new Benvenuto(finestraprinc),BorderLayout.NORTH);

        JPanel centro=new JPanel();
        centro.setLayout(new GridLayout(4,4));
        for(int i=1;i<=10; i++) {
            centro.add(new ProdottoPanel());
        }
        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setViewportView(centro);
        scrollPane.getVerticalScrollBar().setUnitIncrement(17);
        this.add(scrollPane);
        this.add(centro,BorderLayout.CENTER);

    }
    public class Benvenuto extends JPanel{
        GuiCatalogoUtente.Benvenuto _this=this;
        public Benvenuto(PrincUtentereg finestraprinc){
            super();
            _this.setLayout(new BorderLayout());
            Utentereg utentereg=(Utentereg) SessionManager.getInstance().getSession().get("utente");
            try {
                _this.add(new JLabel("Benvenuto " + utentereg.getNome() + " " + utentereg.getCognome()), BorderLayout.WEST);
            }
            catch (Exception e){
                _this.add(new JLabel("Benvenuto utente"),BorderLayout.WEST);
            }
            JPanel est=new JPanel();
            JButton btLogout=new JButton("Logout");
            btLogout.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    finestraprinc.getClp().show(finestraprinc.getPanelcontprinc(),"1");
                }
            });
            JButton carrello=new JButton("Il tuo carrello");
            JButton panieri=new JButton("I tuoi panieri");
                est.add(btLogout);
                est.add(carrello);
                est.add(panieri);
            _this.add(est,BorderLayout.EAST);
        }
    }


}
