package cz.cvut.czm.upf.core.media;

/**
 * Created by Fry on 29.11.2016.
 */
public class Margin {

    public volatile Float left,top,right,bottom;

    public Margin(Float left,Float top,Float right,Float bottom)
    {
        this.left=left;
        this.top=top;
        this.bottom=bottom;
        this.right=right;
    }
    public Margin(Float horizontal,Float vertical)
    {
        this(horizontal,vertical,horizontal,vertical);
    }
    public Margin(Float all)
    {
        this(all,all,all,all);
    }

}
