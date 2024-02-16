package algorithm_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B11657_타임머신 {
	static final long INF = Long.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
		List<Pair>[] graph = new ArrayList[N]; 
		long[] dist = new long[N];
		for(int i=0;i<N;i++) {
			dist[i] = INF;
			graph[i] = new ArrayList<>();
		}
		dist[0] = 0;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			graph[A-1].add(new Pair(B-1,C));
		}
		long min=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				for(Pair p :graph[j]) {
					int next = p.next; int cost = p.cost;
					if(dist[j]!=INF && dist[next] > dist[j] + cost) {
						dist[next] =  dist[j] + cost;
					}
				}
			}
			if(i==N-2) {
				min = Arrays.stream(dist).sum();
			}
			if(i==N-1) {
				if(min>Arrays.stream(dist).sum()) {
					System.out.println(-1);
					return;
				}
			}
		}
		for(int i=1;i<N;i++) {
			System.out.println(dist[i]==INF?-1:dist[i]);
		}
		
	}
	
	public static class Pair{
		int next, cost;
		
		Pair(int next, int cost){
			this.next = next;
			this.cost = cost;
		}
	}
}
