package Atividade9;

import java.util.*;

public class BaseballGame {
    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        
        for (String op : ops) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if (op.equalsIgnoreCase("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equalsIgnoreCase("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        
        int sum = 0;
        for (int score : stack) {
            sum += score;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter operations separated by space:");
        String[] ops = sc.nextLine().split(" ");
        System.out.println("Final Score: " + calPoints(ops));
        sc.close();
    }
}

