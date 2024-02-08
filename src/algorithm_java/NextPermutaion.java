package algorithm_java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NextPermutaion {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int R = 2;
		int[] input = new int[N];
		int[] p = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
			if(i>=N-R) p[i] = 1;
		}
		// step0 : 오름차순 정렬
		Arrays.sort(input);
		do {
			for(int i=0;i<N;i++) {
				if(p[i]>0) System.out.print(input[i]+" ");
			}
			System.out.println();
		} while (np(p));
	}
	
	// 순열의 뒷쪽부터 작은 변화를 준다
	public static boolean np(int[] p) { // 현 순열의 사전순 다음 순열 생성 (p:현 순열)
		int N = p.length;
		// step1 : 교환위치 찾기 (뒤쪽부터..꼭대기를 찾으면 꼭대기 이전이 교환 위치)
		int i = N-1;
		while(i>0 && p[i-1]>=p[i]) --i;
		
		if(i==0) return false; // 현 순열의 상태가 가장 큰 순열이므로 np 없다.
		
		// step2 : 교환위치 (i-1) 에 넣을 값을 뒤쪽부터 찾는다. (큰 값중 최소값)
		int j = N-1;
		while(p[i-1]>=p[j]) j--;
		
		// step3 : 교환위치 (i-1)값과 찾은 위치 (j) 값을 교환
		swap(p,i-1,j);
		
		// step4 : 꼭대기(i)부터 맨뒤까지 오름차순 정렬
		int k = N-1;
		while(i<k) swap(p,i++,k--);
		
		return true;
	}
	public static void swap(int[] arr, int i , int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
}













