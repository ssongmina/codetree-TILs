import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                arr[i][j] = sc.nextInt();

        int max = 0;
        for(int i=0; i<n; i++){ // 1*3에 대하여(행에 대하여)
            for(int j=0; j<m-2; j++){
                int cnt = (arr[i][j]+arr[i][j+1]+arr[i][j+2]);
                if(max < cnt)
                    max = cnt;
            }
        }
        for(int j=0; j<m; j++){ // 3*1에 대하여(열에 대하여)
            for(int i=0; i<n-2; i++){
                int cnt = (arr[i][j]+arr[i+1][j]+arr[i+2][j]);
                if(max < cnt)
                    max = cnt;
            }
        }
        for(int i=0; i<n-1; i++){ // 10&11에 대해서
            for(int j=0; j<m-1; j++){
                int cnt = (arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i][j+1]);
                //System.out.println(cnt);
                if((cnt - arr[i][j]) > max) max = cnt-arr[i][j];
                if((cnt - arr[i][j+1]) > max) max = cnt-arr[i][j+1];
                if((cnt - arr[i+1][j]) > max) max = cnt-arr[i+1][j];
                if((cnt - arr[i+1][j+1]) > max) max = cnt-arr[i+1][j+1];
            }
        }
        System.out.println(max);
       


    }
}