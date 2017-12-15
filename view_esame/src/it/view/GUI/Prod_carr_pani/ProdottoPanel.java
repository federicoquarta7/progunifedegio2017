package it.view.GUI.Prod_carr_pani;

import it.actionListener.Carr_prod_pani_listener.Prodottolistener;
import it.model.Prodotto;

import javax.swing.*;
import java.awt.*;

public class ProdottoPanel extends JPanel{
    public ProdottoPanel(Prodotto prodotto){
        super();
        Prodottolistener listener=new Prodottolistener(this);
        this.setLayout(new BorderLayout());
        JLabel nome=new JLabel(prodotto.getNomeprodotto());
        this.add(nome,BorderLayout.NORTH);

        ImageIcon imageprod=new ImageIcon("ciao.jpg");
        JLabel img=new JLabel(imageprod);
        this.add(img,BorderLayout.CENTER);

        JPanel sud=new JPanel();
        sud.setLayout(new GridLayout(2,2));
        JLabel costo=new JLabel("Prezzo: "+prodotto.getPrezzo()+"€");
        sud.add(costo);
        JButton btInfo=new JButton("Info");
        btInfo.addActionListener(listener);
        btInfo.setActionCommand("Informazione");
        sud.add(btInfo);
        //ImageIcon icon = new ImageIcon("carrello.jpg");
        JButton btAggiungi=new JButton("Aggiungi carrello");
        btAggiungi.addActionListener(listener);
        btAggiungi.setActionCommand("AGGIUNGI_PRODOTTO_CARR");
        sud.add(btAggiungi);
        //ImageIcon iconp = new ImageIcon("paniere.jpg");
        JButton btAggPaniere=new JButton("Aggiungi paniere");
        btAggPaniere.addActionListener(listener);
        btAggPaniere.setActionCommand("AGGIUNGI_PRODOTTO_PANIERE");
        sud.add(btAggPaniere);
        this.add(sud,BorderLayout.SOUTH);
        this.setOpaque(true);
    }
}
