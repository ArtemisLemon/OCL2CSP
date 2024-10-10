package org.example;
import org.chocosolver.solver.*;
import org.chocosolver.solver.variables.IntVar;

public class navCSP {
    IntVar[] vars;
    
    public navCSP(Model m, AdjList src, AdjListTable table){
        int n = src.vars().length;
        int nn = table.nn;
        int nnn = n*nn;
        vars = new IntVar[nnn];

        int k=0;
        for(int i=0;i<n;i++) for(int j=0;j<nn;j++){ 
            IntVar ptr = src.vars()[i].mul(nn).add(j).intVar(); // = pointer arithm
            m.element(vars[k++],table.vars(),ptr,0).post();
        }
    }

    IntVar[] vars(){
        return vars;
    }   
}
