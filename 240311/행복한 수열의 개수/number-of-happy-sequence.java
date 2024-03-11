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
        
        if(m == 1){
            System.out.println(2*n);
        }
        else{
            int sum = 0; // 연속하는 m이 있는 갯수
            for(int i=0; i<n; i++){ // 모든 행에 대해서
                int num = arr[i][0];
                int cnt = 1; // 연속하는 수의 갯수
                for(int j=1; j<n; j++){
                    if(num == arr[i][j])
                        cnt++;
                    else {
                        cnt = 1;
                        num = arr[i][j];
                    }
                }
                if(cnt >= m)
                    sum++;
            }
            for(int i=0; i<n; i++){ // 모든 열에 대해서
                int num = arr[0][i];
                int cnt = 1;
                for(int j=1; j<n; j++){
                    if(num == arr[j][i])
                        cnt++;
                    else{
                        cnt = 1;
                        num = arr[j][i];
                    }
                }
                if(cnt >= m)
                    sum++;
            }
            System.out.println(sum);
        }

    }
}