package java_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1;t<=10;t++) {
			LinkedList<String> lst = new LinkedList<>();
			int N = Integer.parseInt( br.readLine());
			StringTokenizer  st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				lst.push(st.nextToken());
			}
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i<M;i++) {
				st.nextToken();
				int idx = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				LinkedList<String> tmpLst = new LinkedList<String>();
				for(int j=0;j<k;j++) {
					tmpLst.push(st.nextToken());
				}
				lst.combineList(idx, tmpLst);
			}
			System.out.print("#"+t+" ");
			Node<String> prtNode = lst.head.next;
			for(int i=0;i <10;i++) {
				System.out.print(prtNode.data+" ");
				prtNode = prtNode.next;
			}
			System.out.println();
		}
	}
	public static class LinkedList<T>{
		Node<T> head;
		Node<T> tail;
		LinkedList(){
			head = new Node<T>(null);
			tail = new Node<T>(null);
			head.next = tail;
			tail.prev = head;
		}
		
		void push(T data) {
			Node<T> node= new Node<T>(data);
			Node<T> tmp = tail.prev;
			
			tail.prev = node;
			node.next = tail;
			
			tmp.next = node;
			node.prev = tmp;
		}
		
		void combineList(int idx, LinkedList<T> lst) {
			Node<T> node = head;
			for(int i=0;i<idx;i++) {
				node = node.next;
			}
			Node<T> startNode = lst.head.next;
			Node<T> endNode = lst.tail.prev;
			Node<T> tmpNode = node.next;
			
			node.next = startNode;
			startNode.prev = node;
			
			tmpNode.prev = endNode;
			endNode.next = tmpNode;
		}
	}
	public static class Node<T>{
		T data;
		Node<T> prev;
		Node<T> next;
		Node(T data){
			super();
			prev = null;
			next = null;
			this.data = data;
		}
		Node(T data, Node<T> link){
			super();
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return data.toString();
		}
	}

}
