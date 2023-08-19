package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1 ; i >= 0; i--) {
            stack.push(Integer.parseInt(arr[i]));
        }

        Stack<Integer> tempStack = new Stack<>();
        int order = 1;

        while (order <= n) {
            if(!stack.isEmpty() && stack.peek() == order) {
                stack.pop();
                order++;
            } else if(!tempStack.isEmpty() && tempStack.peek() == order) {
                tempStack.pop();
                order++;
            } else if(!stack.isEmpty() && stack.peek() != order) {
                for(int i = 0; i< stack.size(); i++) {
                    if(stack.peek() != order) {
                        tempStack.push(stack.pop());
                    } else {
                        stack.pop();
                        order++;
                        break;
                    }
                }
            } else {
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");


    }
}
