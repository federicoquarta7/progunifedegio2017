package it.business;

public class Prodottobusiness {
    private static Prodottobusiness instance;
    public static Prodottobusiness getInstance()
    {
        if(instance== null) {
            instance = new Prodottobusiness();
        }
        return instance;
    }

}
