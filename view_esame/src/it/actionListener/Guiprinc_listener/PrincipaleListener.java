package it.actionListener.Guiprinc_listener;

import it.view.CardLayout.PrincUtentereg;
import it.view.GUI.Prod_carr_pani.CarrelloFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipaleListener implements ActionListener {
    private double prezzo;
    private PrincUtentereg finestra;
    public PrincipaleListener(PrincUtentereg finestra) {
        this.finestra=finestra;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("VISUALIZZA_TUTTI".equals(e.getActionCommand())){
            JOptionPane.showMessageDialog(null,"hai premuto tutti");
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
            JOptionPane.showMessageDialog(null,"hai selezionato i prodotti fino a €20");
            prezzo=20;
            finestra.getClp().show(finestra.getPanelcontprinc(),"5");
        }
        if("FINO_50".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(null,"hai selezionato i prodotti da €20 a €50");
            prezzo=50;
            finestra.getClp().show(finestra.getPanelcontprinc(),"5");
        }
        if("FINO_100".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(null,"hai selezionato i prodotti da €50 a €100");
            prezzo=100;
            finestra.getClp().show(finestra.getPanelcontprinc(),"5");
        }
        if("OLTRE_100".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(null,"hai selezionato i prodotti oltre €100");
            prezzo=101;
            finestra.getClp().show(finestra.getPanelcontprinc(),"5");
        }

        if("CARRELLO".equals(e.getActionCommand())){
            new CarrelloFrame();
        }

    }

    public double getPrezzo() {
        return prezzo;
    }
}
