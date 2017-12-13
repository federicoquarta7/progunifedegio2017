package it.DAO.interfaces;

import it.model.Prodotto;

import java.util.ArrayList;

public interface IProdottoDAO {
    Prodotto findbynomeprodotto(String nomeprod);
    ArrayList<Prodotto> findAllprod();
}
