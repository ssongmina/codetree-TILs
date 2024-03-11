import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for(int i=0; i<n; i++){
            int sum = 1;
            for(int j=0; j<n-1; j++){
                if(arr[i][j] == arr[i][j+1])
                    sum++;
                else
                    sum = 1;
            }
            if(arr[i][n-2] == arr[i][n-1])
                sum++;
            if(sum >= m)
                cnt++;
        }
        for(int i=0; i<n; i++){
            int sum = 1;
            for(int j=0; j<n-1; j++){
                if(arr[j][i] == arr[j+1][i])
                    sum++;
                else
                    sum = 1;
            }
            if(arr[n-1][i] == arr[n-2][i])
                sum++;
            if(sum >= m)
                cnt++;
        }
        if(n==1 && m==1)
            System.out.println("1");
        else
            System.out.println(cnt);
    }
}