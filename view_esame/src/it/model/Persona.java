package it.model;

public class Persona {
    private int idpersona;
    private String nome;
    private String cognome;
    private String username;
    private byte[] password;

    public int getIdpersona() {
        return idpersona;
    }
    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public byte[] getPassword() {
        return password;
    }
    public void setPassword(byte[] password) {
        this.password = password;
    }
}
