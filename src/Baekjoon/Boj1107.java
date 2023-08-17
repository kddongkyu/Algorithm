package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1107 {

    static int goalChannel;
    static boolean[] buttons = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        goalChannel = Integer.parseInt(br.readLine());
        if(goalChannel == 100) {
            System.out.println(0);
            return;
        }
        int buttonCount = Integer.parseInt(br.readLine());

        if(buttonCount > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i =0; i<buttonCount; i++) {
                buttons[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int count = Math.abs(100-goalChannel);

        for(int i = 0 ; i<999999; i++) {

            boolean check = true;
            String channel = Integer.toString(i);
            for(int j = 0; j < channel.length(); j++) {
                if(buttons[channel.charAt(j)-'0']) {
                    check = false;
                    break;
                }
            }

            if(check) {
               count = Math.min(count, Integer.toString(i).length() + Math.abs(i - goalChannel));
            }
        }

        System.out.println(count);
    }
}
