package it.model;

public class Utentereg extends Persona {
    private int idutente;
    private String indirizzo;
    private String email;
    private String telefono;
    private String iban;

    public int getIdutente() {
        return idutente;
    }
    public void setIdutente(int idutente) {
        this.idutente = idutente;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getIban() {
        return iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }
}
