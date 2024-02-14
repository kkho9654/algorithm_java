package algorithm_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2961_도영이가만든맛있는음식 {
	
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] sb = new int[N][];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			sb[i] = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i=1;i<1<<N;i++) {
			int s=1 , b=0;
			for(int k=0;k<N;k++) {
				if((i &1<<k)!=0) {
					s *= sb[k][0];
					b += sb[k][1];
				}
			}
			min = Math.min(min, Math.abs(s-b));
		}
		System.out.println(min);
	}
		
}
