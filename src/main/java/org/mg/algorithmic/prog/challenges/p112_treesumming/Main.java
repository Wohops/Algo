package org.mg.algorithmic.prog.challenges.p112_treesumming;

import java.io.InputStream;
import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Solver s = new Solver(System.in);
        s.solveAll();
    }
}

/**
 * Solve the tree summing problem
 */
class Solver {
    /**
     * The scanner use to read input
     */
    private Scanner scanner;

    /**
     * Solver constructor
     *
     * @param is
     *            The input stream used to read data
     */
    public Solver(InputStream is) {
        this.scanner = new Scanner(is);
    }

    /**
     * Solve the skyline problem
     *
     * @return the string defining the skyline
     */
    public void solveAll() {

        while (scanner.hasNextLine()) {
            Integer target = scanner.nextInt();
            StringBuilder sb = new StringBuilder();
            sb.append(scanner.nextLine().trim());
            while (scanner.hasNext() && !scanner.hasNextInt()) {
                sb.append(scanner.nextLine().trim());
            }
            String tree = sb.toString();
            System.out.println(solve(target, tree));
        }
    }

    /**
     * Solve a given problem
     *
     * @param target
     *            The number which should be reached
     * @param tree
     *            The given binary tree of integer
     * @return "yes" if the target correspond to a possible value of the tree,
     *         "no" otherwise
     */
    protected String solve(Integer target, String tree) {
        if (target == null || tree == null || tree.isEmpty()) {
            return "no";
        }

        return "yes";
    }
}