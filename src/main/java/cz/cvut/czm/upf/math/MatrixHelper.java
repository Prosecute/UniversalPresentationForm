package cz.cvut.czm.upf.math;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


public class MatrixHelper {

    public static float[][] multiplicate(float[][] a, float[][] b) {
        int aC = a[0].length;
        int bC = b[0].length;
        int aR = a.length;
        int bR = b.length;

        if (aC != bR)
            throw new IllegalArgumentException("a:Row: " + aC + " != b:Col " + bR);

        float[][] c = new float[aR][bC];
        for (int i = 0; i < aR; i++)
            for (int j = 0; j < bC; j++)
                for (int k = 0; k < aC; k++)
                    c[i][j] = a[i][k] * b[k][j];
        return c;
    }
    public static float[][] add(float[][] a,float[][] b)
    {
        int aC = a[0].length;
        int bC = b[0].length;
        int aR = a.length;
        int bR = b.length;
        float[][] cc = new float[aR<bR?bR:aR][aC<bC?bC:aC];
        for(int r=0;r<(aR<bR?bR:aR);r++)
            for(int c=0;c<(aC<bC?bC:aC);c++)
                cc[r][c]=((r<aR&&c<aC)?a[r][c]:0) + ((r<bR&&c<bC)?b[r][c]:0);
        return cc;
    }
}
