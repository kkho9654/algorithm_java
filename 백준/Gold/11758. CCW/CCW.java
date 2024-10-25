import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p1_x =Integer.parseInt(st.nextToken());
        int p1_y =Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p2_x =Integer.parseInt(st.nextToken());
        int p2_y =Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p3_x =Integer.parseInt(st.nextToken());
        int p3_y =Integer.parseInt(st.nextToken());

        int result = (p1_x*p2_y + p2_x*p3_y + p3_x*p1_y) - (p2_x*p1_y + p3_x*p2_y + p1_x*p3_y);
        if(result>0) System.out.println(1);
        else if (result<0) System.out.println(-1);
        else System.out.println(0);


    }
}