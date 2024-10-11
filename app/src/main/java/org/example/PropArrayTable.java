package org.example;

import org.chocosolver.solver.*;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.util.tools.ArrayUtils;

public class PropArrayTable {
    IntVar[][] matrix;
    int n, nn, d;

    public PropArrayTable(Model m, int n, int nn, int lb, int ub, IntVar nullptr){
        this.m=m;
        this.n=n;
        this.nn=nn;
        this.d=d;

        if (nullptr!=null) matrix = m.intVarMatrix(n,nn,lb,ub);
    }

    public IntVar[] vars(){
        return ArrayUtils.concat(nullptrs, ArrayUtils.flatten(matrix)); //flatten sources, dummies at the beginning (lb++)
    }

    public AdjList adjlist(int i){
        return new AdjList(matrix[i]);
    }

    int lb(){
        return lb;
    }
    int ub(){
        return ub;
    }
}
