package cz.cvut.czm.upf;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


public class TODO {

    public TODO()
    {
        throw new RuntimeException("TODO");
    }

    public static TODO c()
    {
        return new TODO();
    }
    public static <T>T create(T type)
    {
        return (T)new TODO();
    }
}
