package org.example;

import org.chocosolver.solver.*;
import org.chocosolver.solver.variables.IntVar;

public class PropArray {
    // PropArray : list of Int Vars
    // CSP model for Collection-like nodes of OCL
    // OCL Collection Type : ordered multiset (All) 

    IntVar[] vars;
    public PropArray(Model m, int n, int lb, int ub){
        vars = m.intVarArray(n,lb,ub);
    }

    public PropArray(Model m, int[] values){ //for known data 
        vars = new IntVar[values.length];
        for(int i=0; i<values.length;i++)
            vars[i] = m.intVar(values[i]);
    }

    public PropArray(IntVar[] vars){
        this.vars=vars;
    }

    IntVar[] vars(){
        return vars;
    }

}
