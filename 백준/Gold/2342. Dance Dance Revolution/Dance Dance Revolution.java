import java.util.*;
import java.io.*;

public class Main {
    static int[][] costs =  {
            {9,2,2,2,2},
            {9,1,3,4,3},
            {9,3,1,3,4},
            {9,4,3,1,3},
            {9,3,4,3,1}
    };

    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> seq = new ArrayList<>();
        while(true){
            int s = Integer.parseInt(st.nextToken());
            seq.add(s);
            if(s==0) break;
        }
        int[][][] dp = new int[seq.size()+1][5][5];
        for (int i = 0; i <= seq.size(); i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        System.out.println(bt(0,0,0,seq,dp));
//        System.out.println(Arrays.deepToString(dp));
    }

    public static int bt(int depth, int left, int right, List<Integer> seq, int[][][] dp){
        int target = seq.get(depth);
        if(target == 0) return 0;
        if(dp[depth][left][right] != -1) return dp[depth][left][right];

        int c = bt(depth+1, target, right, seq, dp) + costs[left][target];
        int d = bt(depth+1, left, target, seq, dp) + costs[right][target];

        return dp[depth][left][right] = Math.min(c,d);
    }

}