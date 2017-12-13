package it.DAO.interfaces;

import java.util.ArrayList;

public interface IBaseDAO<T> /*accetta un tipo*/
{
    //findAll
    ArrayList<T> findAll();

    //findbyID
    T findID(int id);
}
