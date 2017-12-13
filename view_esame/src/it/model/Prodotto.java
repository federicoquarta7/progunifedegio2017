package it.model;

public class Prodotto {
    private int idprodotto;
    private String nomeprodotto;
    private double prezzo;
    private int sconto;
    private boolean prodottocomposto;

    public int getIdprodotto() {
        return idprodotto;
    }
    public void setIdprodotto(int idprodotto) {
        this.idprodotto = idprodotto;
    }
    public String getNomeprodotto() {
        return nomeprodotto;
    }
    public void setNomeprodotto(String nomeprodotto) {
        this.nomeprodotto = nomeprodotto;
    }
    public double getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    public int getSconto() {
        return sconto;
    }
    public void setSconto(int sconto) {
        this.sconto = sconto;
    }
    public boolean isProdottocomposto() {
        return prodottocomposto;
    }
    public void setProdottocomposto(boolean prodottocomposto) {
        this.prodottocomposto = prodottocomposto;
    }
}
