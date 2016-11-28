package cz.cvut.czm.upf.core.dependency;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.TODO;
import cz.cvut.czm.upf.core.threading.DispatcherObject;

public class DependencyObject<T extends DependencyObject> extends DispatcherObject<T> {


    public Object GetValue(DependencyProperty property)
    {
        return TODO.create(Object.class);
    }
    public T InvalidateProperty(DependencyProperty property)
    {
        TODO.c();
        return getThis();
    }
    public T SetCurrentValue(DependencyProperty property,Object object)
    {
        TODO.c();
        return getThis();
    }
}
