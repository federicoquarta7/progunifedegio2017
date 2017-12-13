package it.view.CardLayout;

import it.actionListener.Guiprinc_listener.PrincipaleListener;
import it.view.GUI.GUIprincipale_u_g_a.GuiCatalogoUtente;
import it.view.GUI.GUIprincipale_u_g_a.GuiPrincipale;

import javax.swing.*;
import java.awt.*;

public class PrincUtentereg extends JFrame {
    private JFrame framePrinc=new JFrame("Coop");
    private JPanel panelcontprinc=new JPanel();
    private CardLayout clp=new CardLayout();
    public PrincUtentereg(){
        panelcontprinc.setLayout(clp);
        panelcontprinc.add(new GuiPrincipale(this),"1");
        panelcontprinc.add(new GuiCatalogoUtente(this),"2");
        clp.show(panelcontprinc,"1");
        PrincipaleListener listener = new PrincipaleListener(this);
        JMenuBar bar= new JMenuBar();
        JMenu visualizza=new JMenu("Visualizza");
                bar.add(visualizza);
            JMenuItem tutti=new JMenuItem("Tutti");
                tutti.addActionListener(listener);
                tutti.setActionCommand("VISUALIZZA_TUTTI");
                visualizza.add(tutti);
        JMenu categoria=new JMenu("Per categoria");
                visualizza.add(categoria);
        JMenuItem elettronica=new JMenuItem("Elettronica");
                categoria.add(elettronica);
                elettronica.addActionListener(listener);
                elettronica.setActionCommand("ELETTRONICA_MENU_ITEM");
        JMenuItem casa=new JMenuItem("Casa");
                categoria.add(casa);
                casa.addActionListener(listener);
                casa.setActionCommand("CASA_MENU_ITEM");
        JMenuItem abbigliamento=new JMenuItem("Abbigliamento");
                categoria.add(abbigliamento);
                abbigliamento.addActionListener(listener);
                abbigliamento.setActionCommand("ABBIGLIAMENTO_MENU_ITEM");
        JMenuItem alimentari=new JMenuItem("Alimentari");
                categoria.add(alimentari);
                alimentari.addActionListener(listener);
                alimentari.setActionCommand("ALIMENTARI_MENU_ITEM");
        JMenuItem libri=new JMenuItem("Libri");
                categoria.add(libri);
                libri.addActionListener(listener);
                libri.setActionCommand("LIBRI_MENU_ITEM");
        JMenu fasciaDiPrezzo=new JMenu("Per fascia di prezzo");
        JMenuItem finoA20=new JMenuItem("Fino a €20");
                finoA20.addActionListener(listener);
                finoA20.setActionCommand("FINO_A_20");
                fasciaDiPrezzo.add(finoA20);
        JMenuItem da20A50=new JMenuItem("Da €20 a €50");
                da20A50.addActionListener(listener);
                da20A50.setActionCommand("DA_20_A_50");
                fasciaDiPrezzo.add(da20A50);
        JMenuItem da50A100=new JMenuItem("Da €50 a €100");
                da50A100.addActionListener(listener);
                da50A100.setActionCommand("DA_50_A_100");
                fasciaDiPrezzo.add(da50A100);
        JMenuItem oltre=new JMenuItem("Oltre €100");
                oltre.addActionListener(listener);
                oltre.setActionCommand("OLTRE_100");
                fasciaDiPrezzo.add(oltre);
                visualizza.add(fasciaDiPrezzo);
        framePrinc.setJMenuBar(bar);

        framePrinc.add(panelcontprinc);
        framePrinc.setSize(1000,700);
        framePrinc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrinc.setVisible(true);
    }

    public JPanel getPanelcontprinc() {
        return panelcontprinc;
    }
    public CardLayout getClp() {
        return clp;
    }
}
