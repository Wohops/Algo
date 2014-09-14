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
     * Solve the tree summing problem and print in the console the solution for
     * each given problem
     */
    public void solveAll() {

        while (scanner.hasNext() && scanner.hasNextLine()) {
            // target is always the first input for a given problem
            Integer target = scanner.nextInt();
            // tree given on possibly multiple line
            StringBuilder sb = new StringBuilder();
            sb.append(scanner.nextLine().trim());
            while (scanner.hasNext() && !scanner.hasNextInt()) {
                sb.append(scanner.nextLine().trim());
            }
            // remove all the spaces. Should contain only parenthesis and
            // integers
            String tree = sb.toString().trim().replaceAll("\\s+", "");

            String result = solve(target, tree);
            if (result != null) {
                System.out.println(result);
            }
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
            return null;
        }

        Node binaryTree = new Node(tree);
        boolean found = dfs(binaryTree, target);
        return found ? "yes" : "no";
    }

    /**
     * Execute a depth first search on a binary tree
     *
     * @param tree
     *            The tree to be explored
     * @param target
     *            the value to find
     * @return true if the value has been found
     */
    private boolean dfs(Node tree, int target) {
        if (tree.isEmpty()) {
            return false;
        } else if (tree.isLeaf()) {
            return tree.getSum() == target;
        } else {
            boolean result = false;
            if (tree.getLeft() != null) {
                result = result || dfs(tree.getLeft(), target);
            }
            if (tree.getRight() != null) {
                result = result || dfs(tree.getRight(), target);
            }
            return result;
        }
    }
}

class Node {

    private boolean leaf = true;

    private boolean empty = true;

    private int sum = 0;

    private String valueAsText;

    private Integer value;

    private Node left;

    private Node right;

    public Node(String tree) {
        this(tree, 0);
    }

    private Node(String tree, int sumParent) {
        String[] node = cleanNode(tree);
        valueAsText = tree;
        empty = node == null;
        if (!empty) {
            value = Integer.parseInt(node[0]);
            sum = sumParent + value;
            left = new Node(node[1], sum);
            right = new Node(node[2], sum);
            leaf = right.isEmpty() && left.isEmpty();
            if (right.isEmpty()) {
                right = null;
            }
            if (left.isEmpty()) {
                left = null;
            }
        }
    }

    private String[] cleanNode(String nodeAsText) {
        // remove first and last parenthesis
        String node = nodeAsText.substring(1, nodeAsText.length() - 1);
        if (node.isEmpty()) {
            return null;
        }
        String[] result = new String[3];
        char[] n = node.toCharArray();
        int start = 0;
        int pointer = 0;
        boolean getInt = false;
        boolean hadInt = false;
        boolean foundChild = false;
        int openedParenthesis = 0;
        while (pointer < n.length) {
            char c = n[pointer];
            if (!getInt && c >= '0' && c <= '9') {
                hadInt = true;
            } else if (c == '(') {
                foundChild = true;
                openedParenthesis++;
                if (!getInt && hadInt) {
                    getInt = true;
                    start = pointer;
                    result[0] = node.substring(0, pointer).trim();
                }
            } else if (c == ')') {
                openedParenthesis--;
            }

            if (openedParenthesis == 0 && foundChild) {
                result[1] = node.substring(start, pointer + 1).trim();
                result[2] = node.substring(pointer + 1).trim();
                return result;
            }

            pointer++;
        }
        return null;
    }

    public Integer getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getSum() {
        return sum;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public String getValueAsText() {
        return valueAsText;
    }

    public boolean isEmpty() {
        return empty;
    }
}