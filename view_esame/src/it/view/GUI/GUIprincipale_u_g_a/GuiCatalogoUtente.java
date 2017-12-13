package it.view.GUI.GUIprincipale_u_g_a;

import it.model.Persona;
import it.utility.SessionManager;
import it.view.CardLayout.PrincUtentereg;
import it.view.GUI.Prod_carr_pani.ProdottoPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiCatalogoUtente extends JPanel {

    public GuiCatalogoUtente(PrincUtentereg finestraprinc){
        super();
        this.setLayout(new BorderLayout());
        JPanel north =new JPanel();
        north.setLayout(new FlowLayout());
        north.add(new Benvenuto(finestraprinc));
        this.add(north,BorderLayout.NORTH);

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
        Benvenuto _this=this;
        public Benvenuto(PrincUtentereg finestraprinc){
            super();
            _this.setLayout(new BorderLayout());
            Persona p=(Persona)SessionManager.getInstance().getSession().get("persona");
            //Utentereg utentereg=(Utentereg) SessionManager.getInstance().getSession().get("studente");
            try {
                _this.add(new JLabel("Benvenuto \n" + p.getNome() + " " + p.getCognome()), BorderLayout.WEST);
            }
            catch (Exception e){
                _this.add(new JLabel("Benvenuto"),BorderLayout.WEST);
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
