package org.mg.algorithmic.prog.challenges.p105_skylineproblem;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolverTest {

    private Solver solver;

    @Before
    public void setUp() throws Exception {
        InputStream is = Solver.class.getResourceAsStream("/105.in");
        solver = new Solver(is);
    }

    @Test
    public void test() {
        Assert.assertEquals("results should be matching", "1 11 3 13 9 0 12 7 16 3 19 18 22 3 23 13 29 0",
                solver.solve());
    }

}
