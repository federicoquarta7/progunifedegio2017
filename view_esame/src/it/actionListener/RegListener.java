package it.actionListener;

import it.view.GUI.Registrazione;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegListener implements ActionListener {
    private Registrazione finestra;

    public  RegListener(Registrazione finestra){
        this.finestra=finestra;
    }
    @Override
    public void actionPerformed(ActionEvent ee) {
        if("BACK".equals(ee.getActionCommand())){
            finestra.dispose();
        }
        if("REGISTRAZIONE".equals(ee.getActionCommand())){
            System.out.println(finestra.getTxtnome().getText());
            System.out.println(finestra.getTxtcognome().getText());
            System.out.println(finestra.getTxtindirizzo().getText());
            System.out.println(finestra.getTxtemail().getText());
            System.out.println(finestra.getTxtnTel().getText());
            System.out.println(finestra.getTxtPagamento().getSelectedItem());
        }

    }
}
