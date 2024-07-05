import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isOutdoor = new boolean[N];
        String tmp = br.readLine();
        List<Integer> starts = new ArrayList();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if(tmp.charAt(i) == '0'){
                isOutdoor[i] = true;
            }else{
                cnt++;
                starts.add(i);
            }
        }

        List<Integer>[] tree = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            tree[a].add(b);
            tree[b].add(a);
        }

        if(cnt==2){
            System.out.println(1);
        } else if (cnt<2) {
            System.out.println(0);
        }

        int ans = 0;

        for(int start : starts){
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] isv = new boolean[N];
            q.add(start);
            isv[start] = true;

            while (!q.isEmpty()){
                int cur = q.poll();
                for (int next : tree[cur]) {
                    if(isv[next]) continue;
                    isv[next] = true;
                    if(!isOutdoor[next]) ans++;
                    else q.add(next);
                }
            }
        }

        System.out.println(ans);
    }

}