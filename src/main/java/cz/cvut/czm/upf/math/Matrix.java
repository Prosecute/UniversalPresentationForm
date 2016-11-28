package cz.cvut.czm.upf.math;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


public class Matrix {

    protected float[][] data;

    public Matrix(int size)
    {
        if(size>=0)
            data=new float[size][size];
    }

    public Matrix multiplicate(Matrix b)
    {
        this.data=MatrixHelper.multiplicate(this.data,b.data);
        return this;
    }

    public Matrix add(Matrix b)
    {
        this.data=MatrixHelper.add(this.data,b.data);
        return this;
    }



    public static Matrix getUnitMatrix3()
    {
        return new Matrix(-1){{
           this.data= new float[][]{
                   {1,0,0},
                   {0,1,0},
                   {0,0,1}
           };
        }};
    }
}
