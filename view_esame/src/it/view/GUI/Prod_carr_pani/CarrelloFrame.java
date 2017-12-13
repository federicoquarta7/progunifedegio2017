package it.view.GUI.Prod_carr_pani;

import it.actionListener.Carr_prod_pani_listener.CartListener;

import javax.swing.*;
import java.awt.*;

public class CarrelloFrame extends JFrame {
    private CartListener listener=new CartListener(this);

    public  CarrelloFrame(){
        super("Carrello");
        Container c=getContentPane();
        c.setLayout(new BorderLayout());
        JPanel centro=new JPanel();
        centro.setLayout(new GridLayout(10,2));
        for (int i=0;i<5;i++){
            centro.add(new ProdottoPanel());
        }
        c.add(centro,BorderLayout.CENTER);

        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setViewportView(centro);
        scrollPane.getVerticalScrollBar().setUnitIncrement(17);
        c.add(scrollPane);

        JPanel north =new JPanel();
        north.setLayout(new FlowLayout());
        JButton btlogin = new JButton("Login");
        JButton btnAcquista=new JButton("Procedi all'acquisto");
        btlogin.addActionListener(listener);
        btlogin.setActionCommand("BTLOGIN");
        btnAcquista.addActionListener(listener);
        btnAcquista.setActionCommand("ACQUISTA");
        north.add(btnAcquista);
        north.add(btlogin);
        JButton btregistrazione = new JButton("Registrati");
        btregistrazione.addActionListener(listener);
        btregistrazione.setActionCommand("REGISTRAZIONE");
        north.add(btregistrazione);
        JButton panieri=new JButton("I tuoi panieri");
        north.add(panieri);
        c.add(north,BorderLayout.NORTH);

        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
