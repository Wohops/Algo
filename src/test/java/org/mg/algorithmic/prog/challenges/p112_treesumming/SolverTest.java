package org.mg.algorithmic.prog.challenges.p112_treesumming;

import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;

public class SolverTest {

    private static final String INPUT_FILE = "/112.in";
    private static final String OUTPUT_FILE = "/112.ou";
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

}
