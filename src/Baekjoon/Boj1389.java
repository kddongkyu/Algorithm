package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1389 {

    static final int maxValue = 987654321;
    static int[][] relationship;
    static int users;
    static int countRel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        users = Integer.parseInt(st.nextToken());
        countRel = Integer.parseInt(st.nextToken());

        relationship = new int[users+1][users+1];

        for(int i = 1; i <= users; i++) {
            for(int j = 1; j <= users; j++) {
                relationship[i][j] = maxValue;
                if( i == j ) {
                    relationship[i][j] = 0;
                }
            }
        }

        for(int i = 1; i <= countRel; i++) {
            st = new StringTokenizer(br.readLine());
            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());
            relationship[person1][person2] = 1;
            relationship[person2][person1] = 1;
        }

        for(int i = 1; i <= users; i++) {
            for(int j = 1; j <= users; j++) {
                for (int z = 1; z <= users; z++) {
                    if(relationship[j][z] > relationship[j][i] + relationship[i][z]) {
                        relationship[j][z] = relationship[j][i] + relationship[i][z];
                    }
                }
            }
        }

        int result = maxValue;
        int idx = -1;

        for(int i = 1; i <= users; i++) {
            int total = 0;
            for(int j = 1; j <= users; j++) {
                total += relationship[i][j];
            }
            if(result > total) {
                result = total;
                idx = i;
            }
        }

        System.out.println(idx);

    }

}
