package cz.cvut.czm.upf.util.time;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.MsgUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Random;

public class TimeSpanTest {

    @DataProvider(name="random-date-provider")
    public Object[][] randomDateProvider()
    {
        final int SIZE = 10;
        final Random rnd = new Random();
        Object[][] output = new Object[10][5];
        for(int i=0;i<SIZE;i++)
        {
            output[i][0]=rnd.nextInt(30);
            output[i][1]=rnd.nextInt(24);
            output[i][2]=rnd.nextInt(60);
            output[i][3]=rnd.nextInt(60);
            output[i][4]=rnd.nextInt(1000);
        }
        return output;
    }

    @Test(dataProvider = "random-date-provider")
    public void testValueRounding(int d,int h,int m,int s,int ms)
    {
        TimeSpan timeSpan=new TimeSpan(d,h,m,s,ms);
        Assert.assertEquals(timeSpan.getDays(),d);
        Assert.assertEquals(timeSpan.getHours(),h);
        Assert.assertEquals(timeSpan.getMinutes(),m);
        Assert.assertEquals(timeSpan.getSeconds(),s);
        Assert.assertEquals(timeSpan.getMiliSeconds(),ms);
        Assert.assertEquals(timeSpan.getTicks(),d*TimeSpan.TICKS_PER_DAY+h*TimeSpan.TICKS_PER_HOUR+m*TimeSpan.TICKS_PER_MINUTE+s*TimeSpan.TICKS_PER_SECOND+ms*TimeSpan.TICKS_PER_MILISECOND);

    }
    @Test()
    public void testValueRoundingConstant()
    {
        TimeSpan timeSpan=new TimeSpan(6,23,59,58,100);
        Assert.assertEquals(timeSpan.getDays(),6);
        Assert.assertEquals(timeSpan.getHours(),23);
        Assert.assertEquals(timeSpan.getMinutes(),59);
        Assert.assertEquals(timeSpan.getSeconds(),58);
        Assert.assertEquals(timeSpan.getMiliSeconds(),100);
        Assert.assertEquals(timeSpan.getTicks(),6_047_981_000_000l);
        Assert.assertEquals(timeSpan.getTotalDays(),6.9999776f,0.00001f);
        Assert.assertEquals(timeSpan.getTotalHours(),167.99948f,0.0001f);
        Assert.assertEquals(timeSpan.getTotalMinutes(),10079.968f,0.001f);
        Assert.assertEquals(timeSpan.getTotalSeconds(),604798.06f,0.01f);
        Assert.assertEquals(timeSpan.getTotalMiliSeconds(),6.0479808E8f,0.1f);

    }

}
