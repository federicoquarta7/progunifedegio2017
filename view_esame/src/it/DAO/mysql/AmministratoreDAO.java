package it.DAO.mysql;

import it.DAO.interfaces.IAmministratoreDAO;
import it.dbinterface.DbConnection;
import it.model.Amministratore;

import java.util.ArrayList;

public class AmministratoreDAO implements IAmministratoreDAO {
    public static AmministratoreDAO instance;
    public static AmministratoreDAO getInstance()
    {
        if(instance== null) {
            instance = new AmministratoreDAO();
        }
        return instance;
    }

    public Amministratore findID(int i) {
        ArrayList<String[]> risultato= DbConnection.getInstance().eseguiQuery("SELECT * FROM amministratore WHERE persona_idpersona="+i);
        if(risultato.size() == 0) return null;
        Amministratore s= new Amministratore ();
        String[] riga=risultato.get(0);
        s.setIdamministratore(Integer.parseInt(riga[0]));
        return s;
    }
    public ArrayList<Amministratore> findAll()
    {return null;}
}
