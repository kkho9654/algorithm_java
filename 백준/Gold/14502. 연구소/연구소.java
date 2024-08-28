import java.util.*;
import java.io.*;

public class Main {
    static int N,M,safeZoneCnt,ans;
    static int[][] board;

    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        safeZoneCnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==0||board[i][j]==2) safeZoneCnt++;
            }
        }

        ans = 0;
        dfs(0,0,0);
        
        // 벽 3개 값 빼기
        System.out.println(ans - 3);
    }

    public static void dfs(int wallCnt, int R, int C){
        if(wallCnt==3) {
//            if(floodFill() == 28){
//                for(int[] b : board){
//                    System.out.println(Arrays.toString(b));
//                }
//            }
            ans = Math.max(ans, floodFill());
            return;
        }


        for (int i = R; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(i==R && j<C) continue;

                if(board[i][j]==0){
                    board[i][j] = 1;
                    dfs(wallCnt+1, i, j);
                    board[i][j] = 0;
                }
            }
        }
    }

    public static int floodFill(){
        Queue<Pos> q = new ArrayDeque<>();
        int cnt = 0;
        boolean[][] isv = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(board[i][j] == 2) {
                    cnt++;
                    q.add(new Pos(i,j));
                    isv[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()){
            Pos cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if(nextR<0||nextR>N-1||nextC<0||nextC>M-1) { continue; }
                // 이미 방문했거나 벽이면 방문 안함
                if(isv[nextR][nextC] || board[nextR][nextC]==1) { continue; }

                cnt++;
                isv[nextR][nextC] = true;
                q.add(new Pos(nextR,nextC));
            }
        }
        return safeZoneCnt - cnt;
    }


    static class Pos{
        int r,c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Pos{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }
}