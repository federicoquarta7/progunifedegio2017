package it.actionListener.Loginlistener;

import it.view.CardLayout.LoginPassFrame;
import it.view.GUI.Login.PassDimenticata;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class PassDimListener implements ActionListener {
    private PassDimenticata finestrapass;
    private LoginPassFrame finestra;
    private int i;

    public PassDimListener (LoginPassFrame finestra, PassDimenticata finestrapass) {
        this.finestrapass = finestrapass;
        this.finestra=finestra;
    }

    @Override
    public void actionPerformed(ActionEvent ee) {

        if("MANDA_EMAIL_RESET".equals(ee.getActionCommand())){
            String smtpHost="smtp.gmail.com";
            String txtemail=finestrapass.getTxtemail().getText();
            String indirizzoDA="quarta.federico97@gmail.com";
            try{
                //Impostazioni smtp
                Properties props = System.getProperties ();
                props.put("mail.smtp.host" , smtpHost);
                props.put("mail.stmp.user" , "username");
                //To use TLS
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.password", "password");
                //To use SSL
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class",
                        "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "25");


                //istanzio un oggetto session
                Session session = Session.getDefaultInstance(props);
                session.setDebug(true);

                    //creo l'oggetto Message tramite session
                    MimeMessage msg = new MimeMessage(session);
                    //definisco il mittente
                    msg.setFrom(new InternetAddress(indirizzoDA));
                    //destinatario
                    msg.addRecipient(Message.RecipientType.TO, new InternetAddress(txtemail));
                    msg.setSubject("Reset password");
                    i = (int) (Math.random() * 10000);
                    msg.setText("Salve gentile cliente,\n la password è stata resettata: " + i + ".\nCordiali saluti dalla direzione.");
                    Transport.send(msg);
                    System.out.println("email mandata");
            }
            catch (MessagingException mex)
            {
                mex.printStackTrace();
                System.out.println ("errore:       |||||| "+mex);
            }
        }
        if("BACK".equals(ee.getActionCommand())){
            finestra.getCl().show(finestra.getPanelcont(),"1");
        }
    }

}

