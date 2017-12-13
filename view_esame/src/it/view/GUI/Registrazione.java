package it.view.GUI;

import it.actionListener.RegListener;

import javax.swing.*;
import java.awt.*;

public class Registrazione extends JFrame{
    private JTextField txtUser=new JTextField();
    private JTextField txnome=new JTextField();
    private JTextField txcognome=new JTextField();
    private JTextField txindirizzo=new JTextField();
    private JTextField txtIndi_sped=new JTextField();
    private JTextField txemail=new JTextField();
    //da vedere se si può prendere come numero;
    private JTextField txnTel=new JTextField();
    String[] pagamenti={"Visa","Carta di credito","Bonifico"};
    private JComboBox listaPagamento=new JComboBox(pagamenti);
    private JPasswordField txtPass=new JPasswordField();

    public Registrazione() {
        super("REGISTRAZIONE UTENTE" );

        RegListener listener=new RegListener(this);
        Container c=getContentPane();
        c.setLayout(new BorderLayout());

        JPanel centro=new JPanel();
        centro.setLayout(new GridLayout(9,2));
        JLabel nomeLbl=new JLabel("Nome:");
        JLabel cognomeLbl=new JLabel("Cognome:");
        JLabel indirizzoLbl=new JLabel("Indirizzo:");
        JLabel indi_spedlbl=new JLabel("Indirizzo di spedizione: ");
        JLabel mailLbl=new JLabel("E-mail:");
        JLabel telefonoLbl=new JLabel("Telefono:");
        JLabel pagamentoLbl=new JLabel("Pagamento");
        JLabel userLbl=new JLabel("Username:");
        JLabel passLbl=new JLabel("Password:");
        centro.add(nomeLbl);
        centro.add(txnome);
        centro.add(cognomeLbl);
        centro.add(txcognome);
        centro.add(indirizzoLbl);
        centro.add(txindirizzo);
        centro.add(indi_spedlbl);
        centro.add(txtIndi_sped);
        centro.add(mailLbl);
        centro.add(txemail);
        centro.add(telefonoLbl);
        centro.add(txnTel);
        centro.add(pagamentoLbl);
        centro.add(listaPagamento);
        centro.add(userLbl);
        centro.add(txtUser);
        centro.add(passLbl);
        centro.add(txtPass);
        txnome.addActionListener(listener);
        txcognome.addActionListener(listener);
        txindirizzo.addActionListener(listener);
        txemail.addActionListener(listener);
        txnTel.addActionListener(listener);
        listaPagamento.addActionListener(listener);
        txtPass.addActionListener(listener);
        txtUser.addActionListener(listener);
        c.add(centro,BorderLayout.CENTER);

        JPanel inBasso=new JPanel();
        JButton registrati=new JButton("Registrati");
            registrati.addActionListener(listener);
            registrati.setActionCommand("REGISTRAZIONE");
                inBasso.add(registrati);
        JButton annulla=new JButton("Chiudi");
            annulla.addActionListener(listener);
            annulla.setActionCommand("BACK");
                inBasso.setLayout(new FlowLayout());
                inBasso.add(annulla);
        c.add(inBasso,BorderLayout.SOUTH);

        setSize(300, 340);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);



    }

    public JTextField getTxtnome() {
        return txnome;
    }
    public JTextField getTxtcognome() {
        return txcognome;
    }
    public JTextField getTxtindirizzo() {
        return txindirizzo;
    }
    public JTextField getTxtemail() {
        return txemail;
    }
    public JTextField getTxtnTel() {
        return txnTel;
    }
    public JComboBox getTxtPagamento(){return listaPagamento;}
    public JTextField getTxtUser() {
        return txtUser;
    }
    public JPasswordField getTxtPass() {
        return txtPass;
    }
}
