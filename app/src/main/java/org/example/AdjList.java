package org.example;

import org.chocosolver.solver.*;
import org.chocosolver.solver.variables.IntVar;

public class AdjList {
    // AdjList : list of pointer Vars
    // CSP model for Reference-like nodes of OCL, and references in UML/EMF instances
    // OCL Reference Collection Type : ordered multiset (All) 

    // vars[]
    //  - n : number of pointers, normally max cardinality of the reference, keep it small
    //  - domain of pointers :
    //      - 0 = nullptr
    //      - 1 = first object
    //      - d = last object

    IntVar[] vars;
    public AdjList(Model m, int n, int d, IntVar nullptr, boolean set){
        if (nullptr!=null) vars = m.intVarArray(n,0,d);
                else vars = m.intVarArray(n,1,d);
        if (set) m.allDifferentExcept0(vars).post(); //(ordered) set
    }

    public AdjList(Model m, int[] values){ //for known instance links 
        vars = new IntVar[values.length];
        for(int i=0; i<values.length;i++)
            vars[i] = m.intVar(values[i]);
    }

    public AdjList(IntVar[] vars){
        this.vars=vars;
    }

    IntVar[] vars(){
        return vars;
    }

}
