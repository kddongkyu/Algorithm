package Baekjoon;

// 문제 :
//  2020년에 입학한 헌내기 도연이가 있다. 도연이는 비대면 수업 때문에 학교에 가지 못해 학교에 아는 친구가 없었다. 드디어 대면 수업을 하게 된 도연이는 어서 캠퍼스 내의 사람들과 친해지고 싶다.
//  도연이가 다니는 대학의 캠퍼스는 N X M 크기이며 캠퍼스에서 이동하는 방법은 벽이 아닌 상하좌우로 이동하는 것이다.
//  예를 들어, 도연이가 (x,y)에 있다면 이동할 수 있는 곳은 (x+1,y), (x,y+1), (x-1,y), (x,y-1)이다.
//  단, 캠퍼스의 밖으로 이동할 수는 없다.
//  불쌍한 도연이를 위하여 캠퍼스에서 도연이가 만날 수 있는 사람의 수를 출력하는 프로그램을 작성해보자.

//  입력 :
//  첫째 줄에는 캠퍼스의 크기를 나타내는 두 정수 N ( 1 <= N <=600 ), M (1 <= M <=600 )이 주어진다.
//  둘째 줄부터 N개의 줄에는 캠퍼스의 정보들이 주어진다. O는 빈 공간, X는 벽, I는 도연이, P는 사람이다. I가 한 번만 주어짐이 보장된다.

//  출력 :
//  첫째 줄에 도연이가 만날 수 있는 사람의 수를 출력한다. 단, 아무도 만나지 못한 경우 TT를 출력한다.

//  예제 입력 1 :
//  3 5
//  OOOPO
//  OIOOX
//  OOOXP

//  예제 입력 2 :
//  3 3
//  IOX
//  OXP
//  XPP

// 예제 출력 1 :
//  1

// 예제 출력 2 :
//  TT

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj21736 {

    static int startX;
    static int startY;
    static char[][] campus;
    static int[][] check;
    static int[] moveX = {1,-1,0,0};
    static int[] moveY = {0,0,1,-1};
    static int N;
    static int M;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        check = new int[N][M];

        for (int i = 0; i<N; i++) {
            String input = br.readLine();
            for(int j = 0; j<M; j++) {
                campus[i][j] = input.charAt(j);
                if(campus[i][j] == 'I') {
                    startX = i;
                    startY = j;
                    check[startX][startY] = -1;
                }
            }
        }

        dfs();
        if(count > 0) {
            System.out.println(count);
        } else {
            System.out.println("TT");
        }
    }

    private static void dfs() {
        Queue<Coordinate> que = new LinkedList<>();
        que.add(new Coordinate(startX,startY));

        while (!que.isEmpty()) {
            Coordinate cor = que.poll();

            for(int i =0; i < 4; i++) {
                if(cor.x + moveX[i] >= 0 && cor.y + moveY[i] >= 0 && cor.x + moveX[i] < N && cor.y + moveY[i] < M && campus[cor.x + moveX[i]][cor.y + moveY[i]] != 'X' && check[cor.x + moveX[i]][cor.y + moveY[i]] != -1) {
                    que.add(new Coordinate(cor.x + moveX[i], cor.y + moveY[i]));
                    check[cor.x + moveX[i]][cor.y + moveY[i]] = -1;

                    if(campus[cor.x + moveX[i]][cor.y + moveY[i]] == 'P') {
                        count++;
                    }
                }
            }
        }
    }

    static class Coordinate {
        int x;
        int y;

        Coordinate(int corX,int corY) {
            this.x = corX;
            this.y = corY;
        }
    }
}
