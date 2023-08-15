package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        String bomb = br.readLine();
        StringBuilder sb = new StringBuilder();
        br.close();

        for(int i= 0; i<word.length();i++){
            sb.append(word.charAt(i));
            if(sb.length() >= bomb.length()){
                int idx = sb.indexOf(bomb);
                if(idx >= 0){
                    sb.delete(idx,idx+bomb.length());
                }
            }
        }

        if(sb.length() == 0){
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}
