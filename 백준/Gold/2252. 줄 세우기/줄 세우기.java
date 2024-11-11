import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Student[] adjList = new Student[N];
		int[] degrees = new int[N];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from-1] = new Student(to-1, adjList[from-1]);
			
			degrees[to-1]++;
		}
		
		topologicalSort(adjList, degrees);
		
	}
	
	private static void topologicalSort(Student[] adjList, int[] degrees) {
		Queue<Integer> q = new ArrayDeque<Integer>();
		Queue<Integer> result = new ArrayDeque<Integer>();
		for(int i=0;i<N;i++) {
			// 차수가 0인 것들 넣는다
			if(degrees[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int v = q.poll();
			result.add(v+1);
			for(Student temp = adjList[v]; temp!=null; temp = temp.next) {
				degrees[temp.v]-=1;
				if(degrees[temp.v] == 0) q.add(temp.v);
			}
		}
			
		while(!result.isEmpty()) {
			System.out.print(result.poll()+" ");
		}
		System.out.println();
	}

	public static class Student{
		int v;
		Student next;
		
		Student(int v, Student next){
			this.v = v;
			this.next = next;
		}
		
		Student(int v){
			this.v = v;
			this.next = null;
		}
	}
}