package org.mg.algorithmic.prog.challenges.p100_the3n1problem;

import java.io.IOException;

class Main implements Runnable {
    static String ReadLn(int maxLength) {
        //
        byte line[] = new byte[maxLength];
        int length = 0;
        int input = -1;
        try {
            while (length < maxLength) {// Read untill maxlength
                input = System.in.read();
                if ((input < 0) || (input == '\n')) {
                    break; // or untill end of line ninput
                }
                line[length++] += input;
            }

            if ((input < 0) && (length == 0)) {
                return null; // eof
            }
            return new String(line, 0, length);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Main function
     *
     * @param args
     *            Arguments
     */
    public static void main(String args[]) {
        Main m = new Main();
        m.run();
    }

    /**
     * {@inheritDoc}
     */
    public void run() {
        new Solver().run();
    }
}

/**
 * The solver of the 3n+1 problem
 */
class Solver implements Runnable {
    /**
     * {@inheritDoc}
     */
    public void run() {
        String line = Main.ReadLn(128);
        while (line != null) {
            System.out.println(solve(line));
            line = Main.ReadLn(128);
        }
    }

    /**
     * Solve the 3n+1 problem, given a line of two integers
     *
     * @param line
     *            A line containing two integers
     * @return The string with the line and the max cycle length
     */
    public String solve(String line) {
        String[] ns = line.trim().split("\\s+");
        if (ns.length != 2) {
            return "";
        }

        int i = Integer.parseInt(ns[0]);
        int j = Integer.parseInt(ns[1]);
        if (i > 1000000 || j > 1000000) {
            return "";
        }

        int min = i;
        int max = j;

        if (i > j) {
            min = j;
            max = i;
        }

        int result = Integer.MIN_VALUE;
        for (int k = min; k <= max; k++) {
            int c = cycleLength(k);
            if (c > result) {
                result = c;
            }
        }

        return i + " " + j + " " + result;
    }

    /**
     * Calculates the cycle length of a number n
     *
     * @param n
     *            The value to be used
     * @return The cycle length of n
     */
    private int cycleLength(int n) {
        int c = 1;
        if (n != 1) {
            while (n > 1) {
                if (n % 2 == 0) {
                    n /= 2;
                } else {
                    n = (3 * n) + 1;
                }
                c++;
            }
        }
        return c;
    }
}
