package it.DAO.mysql;

import it.DAO.interfaces.IGestoreDAO;
import it.dbinterface.DbConnection;
import it.model.Gestore;

import java.util.ArrayList;

public class GestoreDAO implements IGestoreDAO {
    public static GestoreDAO instance;
    public static GestoreDAO getInstance()
    {
        if(instance== null) {
            instance = new GestoreDAO();
        }
        return instance;
    }

    public Gestore findID(int i) {
        ArrayList<String[]> risultato= DbConnection.getInstance().eseguiQuery("SELECT * FROM gestore WHERE persona_idpersona="+i);
        if(risultato.size() == 0) return null;
        Gestore s= new Gestore ();
        String[] riga=risultato.get(0);
        s.setIdgestore(Integer.parseInt(riga[0]));
        return s;
    }
    public ArrayList<Gestore> findAll()
    {return null;}
}
