import java.util.*;
import java.io.*;

public class Main {

    static boolean ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            ans = true;
            int[] isv = new int[V+1];
            List<Integer>[] adjList = new ArrayList[V+1];
            for (int i = 1; i < V+1; i++) {
                adjList[i] = new ArrayList<Integer>();
            }

            // dfs -> 주변 노드중 방문 안한 노드 탐색
            // 현재 내 그룹이 1이면 주변노드 2그룹으로 dfs호출
            // 현재 내 그룹이 1인데 주변노드에 2 있으면 false
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                adjList[x].add(y);
                adjList[y].add(x);
            }
            isv[1] = 1;
            dfs(1,1,isv,adjList);
            if(V!=1){
                for (int i = 2; i < V+1; i++) {
                    if(isv[i]==0) {
                        isv[i] = 1;
                        dfs(i,1,isv,adjList);
                    }
                }
            }

            sb.append(ans?"YES":"NO").append("\n");
        }
        System.out.print(sb.toString());
    }

    static void dfs(int cur, int curGroup, int[] isv, List<Integer>[] adjList){
        if(!ans) return;
        for (int next : adjList[cur]){
            if(isv[next]==curGroup) ans=false;
            else if (isv[next]==0) {
                isv[next] = curGroup==1?2:1;
                dfs(next,curGroup==1?2:1,isv,adjList);
            }
        }
    }

}