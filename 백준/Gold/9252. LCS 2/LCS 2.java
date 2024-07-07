import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int[][] dp = new int[a.length()+1][b.length()+1];

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        int i=a.length(); int j = b.length();
        Stack<Character> ans = new Stack<>();
        while(true){
            if(i==0 || j==0) break;
            if(a.charAt(i-1) == b.charAt(j-1)){
                ans.add(a.charAt(i-1));
                i--; j--;
            }else{
                if(dp[i-1][j] > dp[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!ans.isEmpty()){
            sb.append(ans.pop());
        }


        System.out.println(dp[a.length()][b.length()]);
        System.out.println(dp[a.length()][b.length()]==0?"":sb);

    }

}