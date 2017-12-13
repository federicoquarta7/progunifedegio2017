package it.actionListener.Carr_prod_pani_listener;

import it.view.GUI.Prod_carr_pani.ProdottoPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prodottolistener implements ActionListener {
    private ProdottoPanel finestra;
    public Prodottolistener (ProdottoPanel finestra) {
        this.finestra = finestra;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("AGGIUNGI_PRODOTTO_CARR".equals(e.getActionCommand())){

        }
    }
}
