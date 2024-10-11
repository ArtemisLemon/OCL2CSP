package org.example;

import org.chocosolver.solver.*;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.util.tools.ArrayUtils;

public class PropArrayTable {
    IntVar[][] matrix;
    int n, nn, lb,ub;
    IntVar[] nullptrs;

    public PropArrayTable(Model m, int n, int nn, int lb, int ub){
        this.n=n;
        this.nn=nn;
        this.lb=lb;
        this.ub=ub;
        this.matrix = m.intVarMatrix(n,nn,lb,ub);

        
        this.nullptrs = new IntVar[nn];
        for(int i=0;i<nn;i++) nullptrs[i] = m.getVar(0);
    }

    public IntVar[] vars(){
        return ArrayUtils.concat(nullptrs, ArrayUtils.flatten(matrix)); //flatten sources, dummies at the beginning (lb++)
    }
}
