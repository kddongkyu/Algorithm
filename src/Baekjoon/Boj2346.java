package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Boj2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
            deque.add(new int[]{i,Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();
        int move = deque.poll()[1];
        sb.append("1").append(" ");

        while (!deque.isEmpty()) {

            if(move > 0) {
                for(int i = 1; i< move; i++) {
                    deque.add(deque.poll());
                }

                int[] next = deque.poll();
                move = next[1];
                sb.append(next[0]).append(" ");
            } else {
                for(int i = 1; i< -move; i++) {
                    deque.addFirst(deque.pollLast());
                }

                int[] next = deque.pollLast();
                move = next[1];
                sb.append(next[0]).append(" ");
            }

        }
        System.out.println(sb);

    }
}
