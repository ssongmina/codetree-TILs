import java.util.*;
import java.io.*;

public class Main {

    public static int[][] arr; 

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i=0; i<n-2; i++){
            for(int j=0; j<n-2; j++){
                int cnt = sum(i,j);
                if(cnt > max)
                    max = cnt;
            }
        }
        System.out.println(max);
    }

    public static int sum(int i, int j){
        int cnt = 0;
        for(int a = i; a<i+3; a++){
            cnt += arr[a][j];
            cnt += arr[a][j+1];
            cnt += arr[a][j+2];
        }
        return cnt;
    }
}