package algorithm_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11572KB , 488ms
public class BOJ2023_신기한소수 {
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		// 1의자리 소수 인거중에서 =>2의자리 소수호출 =>3자리 소수 호출 => 4자리 소수 호출
		bt(0,0);
	}
	
	public static void bt(int depth, int before) {
		if(depth == N) {
			System.out.println(before);
			return;
		}
		
		// 소수는 1과 자기 자신만 나누어 떨어지는 친구
		// 기존 수x10 + (0~9) 추가해서도 소수이면 다음 depth(다음 자리수)누적해서 호출
		for(int i=0;i<10;i++) {
			int cur = 10*before + i;
			if(isPrimeNum(cur)) bt(depth+1, cur);
		}
	}
	
	public static boolean isPrimeNum(int num) {
		if(num<2) return false;
		for(int i=2;i<num/2+1;i++) {
			if(num%i == 0) return false;
		}
		return true;
	}
}
