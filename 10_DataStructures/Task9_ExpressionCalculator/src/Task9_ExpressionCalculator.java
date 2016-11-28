
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stanislav Stanislavov
 */
public class Task9_ExpressionCalculator {

    public static final int NUM_OPERATORS = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String st = sc.nextLine();

        if (!Task3_ParenthesesMatching.checkParentheses(st)) {
            throw new IllegalArgumentException("Illegal number of open or close parentheses.");
        }

        st = st.replace(" ", "");

        boolean isNumberRead = false;
        String stNumber = "";
        int levelBase = 0;
        Node prevoisNode = null, firstNode = null, node = null;
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == '(') {
                if (isNumberRead) {
                    throw new IllegalArgumentException("Bad order of operation.");
                }
                levelBase += NUM_OPERATORS;
            } else if (st.charAt(i) == ')') {
                if (!isNumberRead) {
                    throw new IllegalArgumentException("Bad order of operation.");
                }
                levelBase -= NUM_OPERATORS;
            } else if (st.substring(i, i + 1).matches("[0-9.]")) {
                isNumberRead = true;
                stNumber += st.substring(i, i + 1);
            } else if (st.substring(i, i + 1).matches("[-+*/^]")) {
                if (!isNumberRead) {
                    throw new IllegalArgumentException("Bad order of operation.");
                }
                int level = new String("+-*/^").indexOf(st.substring(i, i + 1));

                node = new Node(level + levelBase, Double.parseDouble(stNumber), prevoisNode);
                if (prevoisNode == null) {
                    firstNode = node;
                } else {
                    prevoisNode.setNextNode(node);
                }
                prevoisNode = node;
                isNumberRead = false;
                stNumber = "";
            } else {
                throw new IllegalArgumentException("Bad symbol.");
            }
        }
        if (!isNumberRead) {
            throw new IllegalArgumentException("Bad order of operation.");
        }
        node = new Node(-1, Double.parseDouble(stNumber), prevoisNode);
        if (prevoisNode == null) {
            firstNode = node;
        } else {
            prevoisNode.setNextNode(node);
        }

        //Calculation
        while (firstNode.getNextNode() != null) {
            Node currentNode = firstNode;
            while (currentNode.getNextNode() != null) {
                if (currentNode.getNextNode() != null && currentNode.getPrevoisNode() != null) {//first condition is unnessesary
                    if (currentNode.getOperation() >= currentNode.getNextNode().getOperation()
                            && currentNode.getOperation() >= currentNode.getPrevoisNode().getOperation()) {
                        currentNode.getNextNode().setArgument(calculateExpression(
                                currentNode.getArgument(), currentNode.getOperation(),
                                currentNode.getNextNode().getArgument()));
                        currentNode.getNextNode().setPrevoisNode(currentNode.getPrevoisNode());
                        currentNode.getPrevoisNode().setNextNode(currentNode.getNextNode());
                        currentNode = currentNode.getPrevoisNode();
                    }else{
                        currentNode = currentNode.getNextNode();
                    }                    
                } else {
                    if (currentNode.getOperation() >= currentNode.getNextNode().getOperation()) {
                        currentNode.getNextNode().setArgument(calculateExpression(
                                currentNode.getArgument(), currentNode.getOperation(),
                                currentNode.getNextNode().getArgument()));
                        currentNode.getNextNode().setPrevoisNode(null);
                        firstNode = currentNode.getNextNode();             

                    }
                    currentNode = currentNode.getNextNode();
                }
            }
        }

        System.out.printf("%.6f%n", firstNode.getArgument());

    }

    private static double calculateExpression(double a, int operation, double b) {
        switch (operation % NUM_OPERATORS) {
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            case 3:
                return a / b;
            case 4:
                return Math.pow(a, b);
            default:
                throw new IllegalArgumentException();
        }
    }
}
