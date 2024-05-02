import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int[][] rooms = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            rooms[i][0] = Integer.parseInt(st.nextToken());
            rooms[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(rooms, ((o1, o2) -> {
            if(o1[1]==o2[1]){
                return o1[0] - o2[0];
            }else{
                return o1[1]-o2[1];
            }
        }));

//        Arrays.stream(rooms).forEach(x->System.out.println(Arrays.toString(x)));

        int endTime = rooms[0][1];
        int ans = 1;
        for (int i = 1; i < N; i++) {
            if(endTime <= rooms[i][0]){
                ans++;
                endTime = rooms[i][1];
            }
        }
        System.out.println(ans);

    }
}