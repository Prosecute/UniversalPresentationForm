package cz.cvut.czm.upf.framework;

import cz.cvut.czm.upf.core.threading.DispatcherObject;

/**
 * Created by Fry on 01.12.2016.
 */
public class Style<T extends Style> extends DispatcherObject<T> {

    //region Constructors
    public Style()
    {

    }
    public Style(T objectToCopy)
    {
        super(objectToCopy);
    }
    //endregion
}
