package org.mg.algorithmic.prog.challenges.p102_ecologicalbinpacking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mg.algorithmic.prog.challenges.p102_ecologicalbinpacking.Solver;

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
    public void test0() {
        Assert.assertEquals("Should be the expected result", "BCG 30",
                solver.solve("1 2 3 4 5 6 7 8 9"));
    }

    @Test
    public void test1() {
        Assert.assertEquals("Should be the expected result", "CBG 50",
                solver.solve("5 10 5 20 10 5 10 20 10"));
    }

    @Test
    public void test2() {
        Assert.assertEquals("Should be the expected result", "BCG 30",
                solver.solve("9 8 7 6 5 4 3 2 1"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(
                "Should be the expected result",
                "BCG 1431655764",
                solver.solve("238609294 238609294 238609294 238609294 238609294 238609294 238609294 238609294 238609294"));
    }

    @Test
    public void test4() {
        Assert.assertEquals(
                "Should be the expected result",
                "BGC 193193965",
                solver.solve("85263245 25965748 69854785 15874569 36985745 12365478 36985526 32147859 96587458"));
    }

    @Test
    public void test5() {
        Assert.assertEquals("Should be the expected result", "CBG 2292",
                solver.solve("123 654 789 963 258 741 159 963 357"));
    }

    @Test
    public void test6() {
        Assert.assertEquals("Should be the expected result", "CBG 0",
                solver.solve("0 0 1 1 0 0 0 1 0"));
    }

}
