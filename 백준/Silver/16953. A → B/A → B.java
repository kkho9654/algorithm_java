import java.util.*;
import java.io.*;

public class Main {
    static int depth;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        int cnt= 0;

        q.add(B);

        while(!q.isEmpty()){
            cnt++;
            int size = q.size();
            while(--size>=0){
                int val = q.poll();
                if(val == A) {
                    System.out.println(cnt);
                    return;
                }
                if(val!=1 && val%10 == 1){
                    q.add(val/10);
                }
                if(val/2!=val &&val%2==0) {
                    q.add(val/2);
                }
            }
        }
        System.out.println(-1);

    }


}