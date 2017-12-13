package it.actionListener.Loginlistener;

import it.business.UtenteBusiness;
import it.model.Amministratore;
import it.model.Gestore;
import it.model.Persona;
import it.model.Utentereg;
import it.utility.SessionManager;
import it.view.CardLayout.LoginPassFrame;
import it.view.CardLayout.PrincUtentereg;
import it.view.GUI.Login.LoginFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginListener implements ActionListener {
    private LoginPassFrame finestra;
    private LoginFrame finestralogin;
    private PrincUtentereg finestraprinc;

    public LoginListener(LoginPassFrame finestra,LoginFrame finestralogin,PrincUtentereg finestraprinc) {
        this.finestra = finestra;
        this.finestralogin=finestralogin;
        this.finestraprinc=finestraprinc;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if ("PASSWORD_DIMENTICATA".equals(e.getActionCommand())) {
            finestra.getCl().show(finestra.getPanelcont(), "2");
        }
        else if ("LOGGA".equals(e.getActionCommand())
                || e.getSource() instanceof JTextField
                || e.getSource() instanceof JPasswordField) {
            finestra.dispose();
            String username = finestralogin.getTxtUsername().getText();
            byte[] password = new String(finestralogin.getTxtPassword().getPassword()).getBytes();
            Persona p = UtenteBusiness.getInstance().login(username, password);

            if (p != null) {
                System.out.println("Login ok.");
                if (p instanceof Gestore) {
                    //aprirà la view del docente
                    System.out.println("benvenuto gestore \n" + p.getNome() + " " + p.getCognome());
                    Gestore g = (Gestore) p;
                    System.out.println("id gestore : " + g.getIdgestore());
                } else if (p instanceof Utentereg) {
                    System.out.println("benvenuto utente \n" + p.getNome() + " " + p.getCognome());
                    Utentereg utentereg = (Utentereg) p;
                    System.out.println("indirizzo: " + utentereg.getIndirizzo());
                    SessionManager.getInstance().getSession().put("persona",utentereg);
                    finestraprinc.getClp().show(finestraprinc.getPanelcontprinc(),"2");
                } else if (p instanceof Amministratore) {
                    System.out.println("benvenuto amministratore \n" + p.getNome() + " " + p.getCognome());
                    Amministratore am = (Amministratore) p;
                    System.out.println("id amministratore: " + am.getIdamministratore());
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "il login non è andato a buon fine");
        }
    }
}