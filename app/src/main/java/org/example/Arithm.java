package org.example;
import org.chocosolver.solver.*;
import org.chocosolver.solver.variables.IntVar;


public class Arithm { // =<
    static void leq(Model m, IntVar a,IntVar b){
        m.arithm(a,"<=",b).post();
    }

    // static void leq(Model m, PropArray a, PropArray b){
    //     IntVar aa = m.intVar(IntVar.MIN_INT_BOUND,IntVar.MIN_INT_BOUND);
    //     m.sum(a.vars(),aa).post();
    //     m.maximum(aa,a.vars()).post();
    //     IntVar bb = m.intVar(IntVar.MIN_INT_BOUND,IntVar.MIN_INT_BOUND);
    //     m.sum(b.vars(),bb).post();
    //     m.maximum(bb,b.vars()).post();
    //     m.arithm(aa,"<=",bb).post();
    // }
}
