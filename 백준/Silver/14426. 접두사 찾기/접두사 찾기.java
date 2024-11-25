import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] S = new String[N];
        String[] prefixes = new String[M];

        Trie root = new Trie();

        for (int i = 0; i < N; i++) {
            S[i] = br.readLine();
            Trie localRoot = root;
            for (int j = 0; j < S[i].length(); j++) {
                localRoot = localRoot.addChild(S[i].charAt(j));
            }
            localRoot.value = S[i];
        }

        int x = 0;
        for (int i = 0; i < M; i++) {
            prefixes[i] = br.readLine();
            Trie localRoot = root;
            for (int j = 0; j < prefixes[i].length(); j++) {
                localRoot = localRoot.hasChild(prefixes[i].charAt(j));
                if(localRoot==null) break;
            }
            if(localRoot!=null){
                x++;
            }
        }
        System.out.println(x);

    }

    public static class Trie{
        Map<Character,Trie> children;
        String value;

        Trie(){
            children = new HashMap<>();
        }

        Trie addChild(char ch){
            if(!children.containsKey(ch)){
                children.put(ch, new Trie());
            }
            return children.get(ch);
        }

        Trie hasChild(char ch){
            return children.get(ch);
        }

    }
}
