package algorithm_java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ14719_빗물 {
	static int H,W;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		int[] blocks = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<W;i++) {
			blocks[i] = Integer.parseInt(st.nextToken());
		}
		int tmpSum = 0, sum = 0;
		for(int i=0;i<W;i++) {
			loop1:for(int j=blocks[i];j>=0;j--) {
				tmpSum =0;
				for(int k=i+1;k<W;k++) {
					if(blocks[k]<j) tmpSum+= j-blocks[k];
					else {
						i=k-1;
						break loop1;
					}
				}
			}
			sum+=tmpSum;
		}
		
		System.out.println(sum);
	}
}
