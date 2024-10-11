package org.example;
import org.chocosolver.solver.*;
import org.chocosolver.util.ESat;
import org.chocosolver.util.tools.ArrayUtils;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Solution;
import org.chocosolver.solver.Solver;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.constraints.Propagator;
import org.chocosolver.solver.constraints.nary.cnf.LogOp;
import org.chocosolver.solver.exception.ContradictionException;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.search.strategy.selectors.values.IntValueSelector;
import org.chocosolver.solver.search.strategy.strategy.IntStrategy;
import org.chocosolver.solver.variables.BoolVar;
import org.chocosolver.solver.variables.IntVar;



public class App {

    static String AdjList2String(AdjList a){
        String out="[";
        for(int i=0;i<a.vars().length;i++){
            out += a.vars()[i].getValue()+",";
        }
        return out + "]";
    }

    public static void main(String[] args) {
        Model m = new Model();
        IntVar nullptr = m.intVar("nullptr",0);


        int a = 1, aptrs=5; //a2b []
        int b = 6, bptrs=1;
        int c = 2;


        AdjList a1b = new AdjList(m, aptrs, b, nullptr, true); //self.var(b, min=0, max=5, "orderedSet")
        AdjListTable b2c = new AdjListTable(m, b, bptrs, c, nullptr, false); //B.AllInstances().var(c, min=0. max=1) //This is what should usually be used when modeling variable associations
        b2c.ApplyConstainment();
        navCSP a1b2c = new navCSP(m, a1b, b2c); //self.var(b).var(c)
        int[] sel = {nullptr.getValue(),1,2};
        Inclusion.includesAll(m, sel, a1b2c.adjList());
        m.sum(a1b2c.vars(),"=",3).post();


        IntVar[] UMLCSPpbvars = ArrayUtils.concat(a1b.vars(),b2c.vars());
        IntVar[] OCLCSPpbvars = a1b2c.vars(); //because includesAll
        IntVar[] problemVars = ArrayUtils.concat(UMLCSPpbvars,OCLCSPpbvars);
        m.getSolver().setSearch(Search.intVarSearch(problemVars));
        Solution solution = m.getSolver().findSolution();
        if(solution != null){
            System.out.println("a1->b = "+AdjList2String(a1b));
            for(int i=0;i<b2c.n;i++)
                System.out.println("b"+(i+1)+"->c = "+AdjList2String(b2c.adjlist(i)));
        } else {
            System.out.println("mmh");
        }
        m.getSolver().printStatistics();
    }
}
