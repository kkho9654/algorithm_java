import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        char[] initStr = new char[K];
        for (int i = 0; i < K; i++) {
            initStr[i] = (char)('A'+i);
        }
        char[] target = new char[K];
        String str = br.readLine();
        for (int i = 0; i < K; i++) {
            target[i] = str.charAt(i);
        }

        int[][] ladder = new int[N][K-1];
        int m = -1;
        for (int i = 0; i < N; i++) {
            str = br.readLine();
            if(str.contains("?")) {
                m = i;
                continue;
            }
            for (int j = 0; j < K-1; j++) {
                ladder[i][j] = str.charAt(j)=='-'?1:2;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < K-1; j++) {
                if(ladder[i][j] == 1){
                    char tmp = initStr[j];
                    initStr[j] = initStr[j+1];
                    initStr[j+1] = tmp;
                }
            }
        }
        for (int i = N-1; i >m ; i--) {
            for (int j = 0; j < K-1; j++) {
                if(ladder[i][j] == 1){
                    char tmp = target[j];
                    target[j] = target[j+1];
                    target[j+1] = tmp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K-1; i++) {
            if(initStr[i] != target[i]){
                if(initStr[i] == target[i+1]){
                    if(i==K-2){
                        sb.append("-");
                    }
                    else{
                        sb.append("-*");
                        i++;
                    }
                }
                else{
                    sb = new StringBuilder();
                    for (int j = 0; j < K - 1; j++) {
                        sb.append("x");
                    }
                    break;
                }
            }else{
                sb.append("*");
            }
        }
        System.out.println(sb);

    }
}