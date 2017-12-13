package it.DAO.mysql;

import it.DAO.interfaces.IUtenteregDAO;
import it.dbinterface.DbConnection;
import it.model.Utentereg;

import java.util.ArrayList;
import java.util.Iterator;

public class UtenteregDAO implements IUtenteregDAO {
    private static UtenteregDAO instance;
    public static UtenteregDAO getInstance(){
        if(instance==null){
            instance=new UtenteregDAO();
        }
        return instance;
    }

    public Utentereg findID(int id) {
        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM utente_reg " +
                                                                              "WHERE persona_idpersona="+id);
        if (risultato.size() == 0) return null;
        Utentereg d = new Utentereg();
        String[] riga = risultato.get(0);
        d.setIdutente(Integer.parseInt(riga[0]));
        d.setIndirizzo(riga[1]);
        d.setEmail(riga[2]);
        d.setTelefono(riga[3]);
        d.setIban(riga[4]);
        return d;
    }
    public ArrayList<Utentereg> findAll()
    {
        ArrayList<String[]> risultato= DbConnection.getInstance().eseguiQuery("SELECT * FROM utente_reg");
        ArrayList<Utentereg> listautenti= new ArrayList<Utentereg>();
        /*interetor è un iteratore di liste*/
        Iterator<String[]> i = risultato.iterator();
        while(i.hasNext()) {
            String[] riga = i.next();
            Utentereg utentereg= new Utentereg();
            /*riempiio "s"*/
            utentereg.setIdutente(Integer.parseInt(riga[0]));
            utentereg.setIndirizzo(riga[1]);
            utentereg.setEmail(riga[2]);
            utentereg.setTelefono(riga[3]);
            utentereg.setIban(riga[4]);
            listautenti.add(utentereg);
        }
        return listautenti;
    }
}

