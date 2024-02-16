package algorithm_java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1202_보석도둑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int K = Integer.parseInt(st.nextToken()); 
		
		Jewelry[] js = new Jewelry[N];
		int[] bags = new int[K];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			js[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for(int i=0;i<K;i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(js);
		Arrays.sort(bags);
		
		long ans = 0;
		// 가방 보다 작은 모든 보석들을 보석순으로 정렬해서 pq에 저장
		Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		int idx=0;
		for(int i=0;i<K;i++) {
			// 현재 가방보다 작은 무게의 보석들을 가방에 넣는다.
			while(idx<N && bags[i] >= js[idx].m) {
				pq.add(js[idx++].v);
			}
			
			if(!pq.isEmpty()) ans+= pq.poll();
		}
		System.out.println(ans);
		
	}
	
	static class Jewelry implements Comparable<Jewelry>{
		int m,v;

		public Jewelry(int m, int v) {
			super();
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(B1202_보석도둑.Jewelry o) {
			// TODO Auto-generated method stub
			return this.m - o.m;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ""+v;
		}
	}
}