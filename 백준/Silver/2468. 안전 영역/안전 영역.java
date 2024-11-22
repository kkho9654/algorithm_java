import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for (int h = 0; h < 100; h++) {
            boolean[][] isv = new boolean[N][N];
            int localMax = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(isv[i][j] || board[i][j]<h) continue;
                    localMax++;
                    isv[i][j] = true;
                    dfs(i,j,h,isv);
                }
            }
            ans = Math.max(ans, localMax);
        }
        System.out.println(ans);
    }

    static void dfs(int r, int c, int h, boolean[][] isv){

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(nextR<0 || nextR > N-1 || nextC<0 || nextC > N-1) continue;
            if(isv[nextR][nextC] || board[nextR][nextC]<h) continue;
            isv[nextR][nextC] = true;
            dfs(nextR,nextC,h,isv);
        }
    }

}