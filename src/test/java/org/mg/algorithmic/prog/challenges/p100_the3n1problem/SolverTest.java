package org.mg.algorithmic.prog.challenges.p100_the3n1problem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mg.algorithmic.prog.challenges.p100_the3n1problem.Solver;

public class SolverTest {

    /**
     * The class to be tested
     */
    private Solver solver;

    @Before
    public void setUp() throws Exception {
        solver = new Solver();
    }

    @Test
    public void test1() {
        Assert.assertEquals("Should be the expected result", "1 10 20",
                solver.solve("1 10"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("Should be the expected result", "100 200 125",
                solver.solve("100 200"));
    }

    @Test
    public void test3() {
        Assert.assertEquals("Should be the expected result", "201 210 89",
                solver.solve("201 210"));
    }

    @Test
    public void test4() {
        Assert.assertEquals("Should be the expected result", "900 1000 174",
                solver.solve("900 1000"));
    }
}
