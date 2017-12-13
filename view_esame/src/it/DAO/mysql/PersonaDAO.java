package it.DAO.mysql;

import it.DAO.interfaces.IPersonaDAO;
import it.dbinterface.DbConnection;
import it.model.Amministratore;
import it.model.Gestore;
import it.model.Persona;
import it.model.Utentereg;

import javax.swing.*;
import java.util.ArrayList;

public class PersonaDAO implements IPersonaDAO {
    public static PersonaDAO instance;
    public static PersonaDAO getInstance()
    {
        if(instance== null) {
            instance = new PersonaDAO();
        }
        return instance;
    }
    @Override
    public Persona findUserByUsernameAndPassword(String username, byte[] password){
        Persona p=null;
        ArrayList<String[]> ris= DbConnection.getInstance().eseguiQuery("SELECT * FROM persona WHERE "+ "username = '"+username+"' "+
                                                                        " AND "+"password = '"+new String(password)+"'");
        if(ris.size() != 0) {
            //esiste un utente
            String[] utente = ris.get(0);
            Utentereg utentereg = UtenteregDAO.getInstance().findID(Integer.parseInt(utente[0]));
            if(utentereg==null){
                //allora sarà un gestore
                Gestore gestore=GestoreDAO.getInstance().findID(Integer.parseInt(utente[0]));
                if(gestore==null){
                    Amministratore amministratore=AmministratoreDAO.getInstance().findID(Integer.parseInt(utente[0]));
                    if(amministratore!=null){
                        p=amministratore;
                    }
                    if(amministratore==null){
                        JOptionPane.showMessageDialog(null,"Password o username sbagliati");
                    }
                }
                else{
                    p=gestore;
                }
            }
            else{
                p=utentereg;
            }
            if(p!=null){
                p.setNome(utente[1]);
                p.setCognome(utente[2]);
            }
        }
        return p;
    }
    public ArrayList<Persona> findAll(){
        return null;
    }
    public Persona findID(int id){
        return null;
    }
}

