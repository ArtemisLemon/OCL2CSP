package org.example;

import org.chocosolver.solver.*;
import org.chocosolver.solver.variables.IntVar;

public class Inclusion {
    static void includes(Model m, int[] src, IntVar body){
        m.member(body, src).post();
    }
    static void includesAll(Model m, int[] src, IntVar[] body){
        for(int i=0;i<body.length;i++)
            includes(m,src,body[i]);
    }
    
    static void includesAll(Model m, int[] src, AdjList body){
        for(int i=0;i<body.vars().length;i++)
            includes(m,src,body.vars()[i]);
    }

}
