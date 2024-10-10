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
    public static void main(String[] args) {
        Model m = new Model();

        int a = 1; //a2b []
        int b = 6;
        int c = 2;

        IntVar nullptr = m.intVar(0);

        AdjList a02b = new AdjList(m, 5, b, true, true);
        AdjListTable b2c = new AdjListTable(m, b, c, c, null, true);
        navCSP a02b2c = new navCSP(m, a02b, b2c);
        int[] sel = {1,2};
        Includes.includesAll(m, sel, a02b2c.adjList());


        IntVar[] problemVars = ArrayUtils.concat(a02b.vars(),b2c.vars());
        Solution solution = m.getSolver().findSolution();
        if(solution != null){
            System.out.println(solution.toString());
        } else {
            System.out.println("mmh");
        }
        m.getSolver().printStatistics();
    }
}
