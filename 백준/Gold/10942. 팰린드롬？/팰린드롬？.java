import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[2*N+2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < 2*N+1; i++) {
            if(i%2!=0) continue;
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] compNums = new int[2*N+1];

        for (int i = 2; i <= 2*N; i++) {
            int comp = 0;
            while (i-(1+comp)>=1 && i+(1+comp)<=2*N+1){
                if(nums[i-(1+comp)]==nums[i+(1+comp)])
                    comp++;
                else
                    break;
            }
            compNums[i] = comp/2;
        }
        StringBuilder sb = new StringBuilder();

//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(compNums));

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if(compNums[s+e]>=(e-s+1)/2){
                sb.append(1);
            }else {
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}