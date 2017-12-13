package it.DAO.interfaces;

import it.model.Persona;

public interface IPersonaDAO extends IBaseDAO<Persona>{
    Persona findUserByUsernameAndPassword(String username, byte[] password);
}
