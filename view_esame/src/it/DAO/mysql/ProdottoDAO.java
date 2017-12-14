package it.DAO.mysql;

import it.DAO.interfaces.IProdottoDAO;
import it.dbinterface.DbConnection;
import it.model.Prodotto;

import java.util.ArrayList;
import java.util.Iterator;

public class ProdottoDAO implements IProdottoDAO {

    private String nomeprod;
    private double prezzo;
    private int sconto;
    private boolean prodottocomposto;



    public static ProdottoDAO instance;
    public static ProdottoDAO getInstance()
    {
        if(instance== null) {
            instance = new ProdottoDAO();
        }
        return instance;
    }

    public Prodotto findbynomeprodotto(String nomeprod){
        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM prodotto " +
                                                                                "WHERE nome= '"+nomeprod+"'");
        if (risultato.size() == 0) return null;
        Prodotto prodotto=new Prodotto();
        String[] riga = risultato.get(0);
        prodotto.setIdprodotto(Integer.parseInt(riga[0]));
        prodotto.setNomeprodotto(riga[1]);
        prodotto.setPrezzo(Double.parseDouble(riga[2]));
        prodotto.setSconto(Integer.parseInt(riga[3]));
        //nel db ciò è salvato come un boolean ossia true e false, poiche risultato
        // legge tutto come una stringa si deve convertire
        prodotto.setProdottocomposto(Boolean.parseBoolean(riga[6]));
        return prodotto;
    }
    public ArrayList<Prodotto> findAllprod()
    {
        ArrayList<String[]> risultato= DbConnection.getInstance().eseguiQuery("SELECT * FROM utente_reg");
        ArrayList<Prodotto> listautenti= new ArrayList<Prodotto>();
        /*interetor è un iteratore di liste*/
        Iterator<String[]> i = risultato.iterator();
        while(i.hasNext()) {
            String[] riga = i.next();
            Prodotto prodotto= new Prodotto();
            /*riempiio "s"*/
            prodotto.setIdprodotto(Integer.parseInt(riga[0]));
            prodotto.setNomeprodotto(riga[1]);
            prodotto.setPrezzo(Double.parseDouble(riga[2]));
            prodotto.setSconto(Integer.parseInt(riga[3]));
            prodotto.setProdottocomposto(Boolean.parseBoolean(riga[6]));
            listautenti.add(prodotto);
        }
        return listautenti;
    }
    public void insertProdotto(){
        Prodotto prodotto=new Prodotto();
       nomeprod=prodotto.getNomeprodotto();
       prezzo=prodotto.getPrezzo();
       sconto=prodotto.getSconto();
       prodottocomposto=prodotto.isProdottocomposto();
        DbConnection.getInstance().eseguiQuery("INSERT INTO `prova3_2`.`prodotto` (nome,prezzo,sconto,is_composto) " +
                                           "VALUES ('"+nomeprod+"','"+prezzo+"','"+sconto+"','"+prodottocomposto+"') ");

    }
}
