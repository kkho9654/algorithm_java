package hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 메모리:23868KB	시간:	128ms
public class Main {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> deque = new ArrayDeque<>();
		// 제일 위에 카드 바닥에 버림
		// 그다음 위에 카드를 맨 밑으로 넣어버림
		N = Integer.parseInt(br.readLine());
		for(int i=1;i<=N;i++) deque.add(i);
		
		while(deque.size() != 1) {
			deque.pop();
			deque.addLast(deque.pop());
			
		}
		
		System.out.println(deque.pop());
	}
	
}

