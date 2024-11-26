import java.util.*;
import java.io.*;

public class Main {
    static List<int[]> houses;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // m 개 선택 후 모든 집과 거리 계산.
        // 계산 함수는 bfs로 모든 집을 초기에 받은 후 치킨집에 도달하면 현재까지의 거리를 더한 후 큐에 더 안넣음

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][N];
        List<int[]> chickens = new ArrayList<>();
        houses = new ArrayList<>();

        int idx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==2) {
                    chickens.add(new int[]{i,j,idx++});
                }else if(board[i][j]==1){
                    houses.add(new int[]{i,j});
                }
            }
        }
        ans = 100001;
        dfs(0,M,-1,chickens,new HashSet<>());
        System.out.println(ans);
    }

    public static void dfs(int depth, int M, int cur, List<int[]> chickens, Set<Integer> visited){
        if(depth==M){
            int localMin=0;
            for (int[] house: houses) {
                int r = house[0];
                int c = house[1];
                int mn = 100000;
                for (int[] chicken:chickens){

                    if(!visited.contains(chicken[2])) continue;
                    int dist = Math.abs(r-chicken[0]) + Math.abs(c-chicken[1]);

                    mn = Math.min(mn, dist);
                }
                localMin += mn;
            }
            ans = Math.min(ans, localMin);
        }
        for (int i = cur+1; i < chickens.size(); i++) {
            visited.add(chickens.get(i)[2]);
            dfs(depth+1, M, i, chickens, visited);
            visited.remove(chickens.get(i)[2]);
        }
    }
}
