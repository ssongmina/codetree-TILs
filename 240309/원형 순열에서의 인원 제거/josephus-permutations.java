import java.util.*;
import java.io.*;

public class Main  {
    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++)
            q.add(i);
        while(!q.isEmpty()){
            for(int i=1; i<k; i++){
                q.add(q.poll());
            }
            System.out.print(q.poll()+" ");
        }
    }
}