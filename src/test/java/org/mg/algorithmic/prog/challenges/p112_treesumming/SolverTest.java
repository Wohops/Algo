package org.mg.algorithmic.prog.challenges.p112_treesumming;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolverTest {

    private static final String INPUT_FILE = "/112.in";
    private Solver solver;

    @Before
    public void setUp() throws Exception {
        InputStream is = Solver.class.getResourceAsStream(INPUT_FILE);
        solver = new Solver(is);
    }

    @Test
    public void testFromFile() {
        solver.solveAll();
    }

    @Test
    public void test() {
        String[] trees = new String[] { "(5(4(11(7()())(2()()))()) (8(13()())(4()(1()()))))",
                "(3(2(4()())(8()()))(1(6()())(4()())))", "(5(4(11(7()())(2()()))()) (8(13()())(4()(1()()))))",
                "(5(4(11(7()())(2()()))()) (8(13()())(4()(1()()))))",
                "(5(4(11(7()())(2()()))()) (8(13()())(4()(1()()))))", "()",
                "(5(4(11(7()())(2()()))()) (8(13()())(4()(1()()))))", "(-1()())", "(77(1()())())",
                "(18 ( -13 ( ) (  ))())", "(1 ()(-2 () (1()()) ) )" };
        int[] targets = new int[] { 18, 10, 27, 26, 22, 5, 20, -1, 77, 5, 0 };
        String[] solutions = new String[] { "yes", "yes", "yes", "yes", "yes", "no", "no", "yes", "no", "yes", "yes" };

        for (int i = 0; i < trees.length; i++) {
            Assert.assertEquals("should ne equals", solutions[i], solver.solve(targets[i], trees[i]));
        }
    }

    @Test
    public void test2() {
        String[] trees = new String[] { "(18 ( -13 ( ) (  ))())", "(1 ()(-2 () (1()()) ) )" };
        int[] targets = new int[] { 5, 0 };
        String[] solutions = new String[] { "yes", "yes" };

        for (int i = 0; i < trees.length; i++) {
            Assert.assertEquals("should ne equals", solutions[i], solver.solve(targets[i], trees[i]));
        }
    }

}
