package cz.cvut.czm.upf;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


public class MsgUtil {
    public static String d(String m,Object v,Object e)
    {
        return m+" Expected: "+e+" Given:" + v;
    }
}
