package algorithm_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ12891_DNA비밀번호 {
	static int S,P;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
	
		int[] arr = br.readLine().chars().map(o->{
					if(o==(int)'A') o=0;
					else if(o==(int)'C') o=1;
					else if(o==(int)'G') o=2;
					else o=3;
					return o;
				}).toArray();
		
		int[] answer = Arrays.stream(br.readLine().split(" ")).mapToInt(o->Integer.parseInt(o)).toArray();
//		System.out.println(Arrays.toString(answer));
		int cnt = 0;
		// 부분문자열의 acgt의 개수를 센다
		int[] acgt = {0,0,0,0};
		int start=0;
		for(int i=0;i<S;i++) {
			if(i>=P) {
				acgt[arr[start++]]--;
			}
			acgt[arr[i]]++;
//			System.out.println(Arrays.toString(acgt));
			boolean flag = true;
			for(int j=0;j<4;j++) {
				if(acgt[j] - answer[j] < 0) {
					flag =false;
					break;
				}
			}
			if(i>=P-1 && flag) cnt++;
		}
		
		System.out.println(cnt);
		
	}
}
