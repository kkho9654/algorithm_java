import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<Integer>[] tree = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        int[] dp = new int[N+1];

        dfs(0,R, tree, dp);

//        System.out.println(Arrays.toString(dp));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int question = Integer.parseInt(br.readLine());
            sb.append(dp[question]).append("\n");
        }
        System.out.print(sb);
    }

    private static int dfs(int parent, int cur, List<Integer>[] tree, int[] dp) {
        int total = 0;
        for(int child : tree[cur]){
            if(parent==child) continue;
            total+=dfs(cur, child, tree,dp);
        }

        return dp[cur] = total+1;
    }

}