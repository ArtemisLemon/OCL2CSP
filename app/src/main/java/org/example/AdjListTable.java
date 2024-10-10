package org.example;

import org.chocosolver.solver.*;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.util.tools.ArrayUtils;

public class AdjListTable {
    IntVar[][] matrix;
    int n, nn, d; boolean nullptr, set;
    IntVar[] nullptrs; 

    public AdjListTable(Model m, int n, int nn, int d, IntVar nullptr, boolean set){
        this.n=n;
        this.nn=nn;
        this.d=d;
        this.nullptr=(nullptr!=null);
        this.set=set;

        if (nullptr!=null) matrix = m.intVarMatrix(n,nn,0,d);
        else matrix = m.intVarMatrix(n,nn,1,d);
        
        if (set) for(int i=0;i<n;i++) m.allDifferentExcept0(matrix[i]).post(); //(ordered) set

        if(nullptr!=null){
            this.nullptrs = new IntVar[nn];
            for(int i=0;i<nn;i++) nullptrs[i] = nullptr;
        }
    }

    public AdjListTable(AdjList[] rows, IntVar nullptr){
        this.n = rows.length;
        this.nullptr = (nullptr!=null);
        matrix = new IntVar[rows.length][];
        for(int i=0;i<rows.length;i++){
            matrix[i] = rows[i].vars();
        }
    }

    public IntVar[] vars(){
        return ArrayUtils.concat(nullptrs, ArrayUtils.flatten(matrix)); //flatten sources, dummies at the beginning (lb++)
    }

    public AdjList adjlist(int i){
        return new AdjList(matrix[i]);
    }

    int lb(){
        if(!nullptr) return 1;
        return 0;
    }
    int ub(){
        return d;
    }
}
