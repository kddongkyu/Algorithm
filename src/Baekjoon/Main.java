import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int width;
    static int height;
    static int startX;
    static int startY;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] map;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        map = new int[height][width];
        distance = new int[height][width];

        for(int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < width; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                distance[i][j] = -1;
                if(map[i][j] == 2) {
                    startX = i;
                    startY = j;
                    distance[i][j] = 0;
                } else if(map[i][j] == 0) {
                    distance[i][j] = 0;
                }
            }
        }

        bfs(startX,startY);
        StringBuilder sb = new StringBuilder();

        for(int i =0; i<height; i++) {
            for(int j = 0; j<width; j++) {
                sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();

        que.add(new int[]{x,y});

        while (!que.isEmpty()) {
            int[] poll = que.poll();
            for(int i = 0; i<4;i++) {
                int newX = poll[0] +dx[i];
                int newY = poll[1] +dy[i];

                if(newX >= 0 && newY >= 0 && newX < height && newY < width) {
                    if(map[newX][newY] != 0 && distance[newX][newY] == -1) {
                        distance[newX][newY] = distance[poll[0]][poll[1]] + 1;
                        que.add(new int[]{newX,newY});
                    }
                }
            }
        }
    }
}
