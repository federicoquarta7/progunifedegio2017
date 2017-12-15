package it.view.GUI.GUIprincipale_u_g_a.gestore;

import it.model.Gestore;
import it.model.ProdottiaggiuntiTableModel;
import it.utility.SessionManager;
import it.view.CardLayout.PrincUtentereg;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GuiCatalogoGestore extends JPanel {
    public GuiCatalogoGestore(PrincUtentereg finestraprinc) {
        super();
        this.setLayout(new BorderLayout());
        this.add(new Benvenuto(finestraprinc),BorderLayout.NORTH);
        Gestore gestore=(Gestore) SessionManager.getInstance().getSession().get("gestore");
/*
        String[][] dato = new String[3][3];
        dato[0][0]="a";
        dato[0][1]="b";
        dato[0][2]="c";
        dato[1][0]="d";
        dato[1][1]="e";
        dato[1][2]="f";
        dato[2][0]="g";
        dato[2][1]="h";
        dato[2][2]="i";
        String[] columnName=new String[]{"nome","email","newsletter"};

        TableModel tm= new DefaultTableModel(dato,columnName);
        */
        //ProdottiaggiuntiTableModel ptm=new ProdottiaggiuntiTableModel(gestore.getProdottiAggiunti);
       // JTable esamiSostenuti = new JTable(ptm);
        //this.add(esamiSostenuti,BorderLayout.CENTER);



    }




    public class Benvenuto extends JPanel{
        GuiCatalogoGestore.Benvenuto _this=this;
        public Benvenuto(PrincUtentereg finestraprinc){
            super();
            _this.setLayout(new BorderLayout());
            Gestore gestore=(Gestore) SessionManager.getInstance().getSession().get("gestore");
            try{
                _this.add(new JLabel("Benvenuto " + gestore.getNome() + " " +gestore.getCognome()), BorderLayout.WEST);
            }
            catch (Exception e){
                _this.add(new JLabel("Benvenuto gestore "), BorderLayout.WEST);
            }

            JPanel est=new JPanel();
            JButton btLogout=new JButton("Logout");
            btLogout.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    finestraprinc.getClp().show(finestraprinc.getPanelcontprinc(),"1");
                }
            });
            JButton btAggProd=new JButton("Aggiungi prodotto");
                est.add(btLogout);
                est.add(btAggProd);
            _this.add(est,BorderLayout.EAST);
        }
    }
}
