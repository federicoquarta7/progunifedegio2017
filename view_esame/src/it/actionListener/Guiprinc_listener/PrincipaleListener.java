package it.actionListener.Guiprinc_listener;

import it.view.CardLayout.PrincUtentereg;
import it.view.GUI.GUIprincipale_u_g_a.GuiPrincipale;
import it.view.GUI.Prod_carr_pani.CarrelloFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipaleListener implements ActionListener {
    private double prezzo;
    private String reparto;
    private String categoria;
    private PrincUtentereg finestra;
    public PrincipaleListener(PrincUtentereg finestra) {
        this.finestra=finestra;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("VISUALIZZA_TUTTI".equals(e.getActionCommand())){
            finestra.getClp().show(finestra.getPanelcontprinc(),"1");
        }
        if("ELETTRONICA_MENU_ITEM".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(null,"hai premuto elettronica");
        }
        if("CASA_MENU_ITEM".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(null,"hai premuto casa");
        }
        if("ABBIGLIAMENTO_MENU_ITEM".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(null,"hai premuto abbigliamento");
        }
        if("ALIMENTARI_MENU_ITEM".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(null,"hai premuto alimentari");
        }
        if("LIBRI_MENU_ITEM".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(null,"hai premuto libri");
        }
        if("FINO_A_20".equals(e.getActionCommand())) {
            prezzo=21;
            finestra.getClp().show(finestra.getPanelcontprinc(),"5");
        }
        if("FINO_50".equals(e.getActionCommand())) {
            prezzo=51;
            finestra.getClp().show(finestra.getPanelcontprinc(),"5");
        }
        if("FINO_100".equals(e.getActionCommand())) {
            prezzo=99.99;
            finestra.getClp().show(finestra.getPanelcontprinc(),"5");
        }
        if("OLTRE_100".equals(e.getActionCommand())) {
            prezzo=100;
            finestra.getClp().show(finestra.getPanelcontprinc(),"5");
        }

        if("CARRELLO".equals(e.getActionCommand())){
            new CarrelloFrame();
        }

    }

    public String getReparto() {
        return reparto;
    }
    public String getCategoria() {
        return categoria;
    }
    public double getPrezzo() {
        return prezzo;
    }
}
