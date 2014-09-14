package org.mg.algorithmic.prog.challenges.p105_skylineproblem;

import java.io.InputStream;
import java.util.Scanner;

/**
 * ACCEPTED on http://uva.onlinejudge.org : 12.09.2014 00:05
 */
class Main {
    public static void main(String args[]) {
        Solver s = new Solver(System.in);
        System.out.println(s.solve());
    }
}

/**
 * Solve the skyline problem
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
     *            The input stream used to read buildings
     */
    public Solver(InputStream is) {
        this.scanner = new Scanner(is);
    }

    /**
     * Solve the skyline problem
     *
     * @return the string defining the skyline
     */
    public String solve() {
        StringBuilder sb = new StringBuilder();
        short[] skyline = new short[10001];

        short maxX = 0;
        while (scanner.hasNextLine()) {
            Short[] b = readBuilding(scanner.nextLine());
            if (b != null) {
                if (maxX < b[2]) {
                    maxX = b[2];
                }
                for (int i = b[0]; i < b[2]; i++) {
                    if (skyline[i] < b[1]) {
                        skyline[i] = b[1];
                    }
                }
            }
        }
        skyline[maxX + 1] = -1;

        for (int i = 1; i < skyline.length; i++) {
            if (skyline[i] == -1) {
                break;
            }
            if (skyline[i] != skyline[i - 1]) {
                sb.append(i).append(" ").append(skyline[i]).append(" ");
            }
        }

        return sb.toString().trim();
    }

    /**
     * A building is an array of 3 short integers, defining the Left limit, the
     * Height and the Right limit
     *
     * @param line
     *            the line containing the building
     * @return the building as an array
     */
    private Short[] readBuilding(String line) {
        if (line != null && !line.trim().isEmpty()) {
            String[] dims = line.trim().split("\\s+");
            return new Short[] { Short.parseShort(dims[0]), Short.parseShort(dims[1]), Short.parseShort(dims[2]) };
        }
        return null;
    }
}