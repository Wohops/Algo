package org.mg.algorithmic.prog.challenges.p102_ecologicalbinpacking;

import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Solver solver = new Solver();
        while (in.hasNextLine()) {
            String result = solver.solve(in.nextLine());
            if (result != null) {
                System.out.println(result);
            }
        }
    }
}

/**
 * The solver of the Ecological Bin Packing problem
 */
class Solver {
    /**
     * Solve the Ecological Bin Packing problem, given a line of two integers
     *
     * @param line
     *            A line containing 9 integers representing the values of each
     *            bin
     * @return The string with the color chosen for each bin and the number of
     *         movements
     */
    public String solve(String line) {
        String[] ns = line.trim().split("\\s+");
        if (ns.length != 9) {
            return null;
        }

        char[] lbl = new char[] { 'B', 'G', 'C' };

        // count bottles
        int[] bottles = new int[9];
        for (int i = 0; i < 9; i++) {
            bottles[i] = Integer.parseInt(ns[i]);
        }

        int[][] cbn = new int[][] { { 0, 2, 1 }, { 0, 1, 2 }, { 2, 1, 0 }, { 2, 0, 1 }, { 1, 0, 2 }, { 1, 2, 0 } };
        int[] results = new int[cbn.length];
        String[] lbls = new String[cbn.length];
        for (int i = 0; i < cbn.length; i++) {
            lbls[i] = lbl[cbn[i][0]] + "" + lbl[cbn[i][1]] + "" + lbl[cbn[i][2]];

        }

        int minMoves = -1;
        int bestCbnIndex = 0;
        for (int i = 0; i < cbn.length; i++) {
            results[i] = this.swap(bottles, cbn[i]);
            if (minMoves == -1 || results[i] < minMoves) {
                bestCbnIndex = i;
                minMoves = results[i];
            }
        }

        return lbls[bestCbnIndex] + " " + results[bestCbnIndex];
    }

    private int swap(int[] bottles, int[] cbn) {
        int moves = 0;
        for (int i = 0; i < bottles.length; i++) {
            int c = i % 3;
            int b = i / 3;
            if (c != cbn[b]) {
                moves += bottles[i];
            }
        }
        return moves;
    }
}
