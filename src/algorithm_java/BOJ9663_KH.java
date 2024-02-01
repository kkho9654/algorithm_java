import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N,cnt;
	static int[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		visited = new int[N];
		for(int i=0; i < N ; i++) {
			visited[i] = -1;
		}
		bt(0);
		
		System.out.println(cnt);
	}
	
	public static void bt(int depth) {
		if(depth==N) {
			cnt++;
			return;
		}

		for(int i = 0; i<N; i++) {
			boolean flag = false;
			if(visited[i]>-1) continue;
			for(int j=0;j<=depth;j++) {
				if(i-j>=0 && visited[i-j]==depth - j) {
					flag = true;
					break;
				}
				if(i+j<N && visited[i+j]==depth - j) {
					flag = true;
					break;
				}
			}
			if(flag) continue;
			
			visited[i]=depth;
			bt(depth+1);
			visited[i]=-1;
		}
	}
}