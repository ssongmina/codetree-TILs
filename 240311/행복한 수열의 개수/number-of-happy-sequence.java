import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                arr[i][j] = sc.nextInt();
        }
        
        if(m == 1){
            System.out.println(2*n);
        }
        else{
            int sum = 0; // 연속하는 m이 있는 갯수
            for(int i=0; i<n; i++){ // 모든 행에 대해서
                int num = arr[i][0];
                int cnt = 1; // 연속하는 수의 갯수
                int max = 1;
                for(int j=1; j<n; j++){
                    if(num == arr[i][j])
                        cnt++;
                    else {
                        if(cnt >= m)   
                            max = cnt; 
                        cnt = 1;
                        num = arr[i][j];
                    }
                }
                if(cnt >= m || max >= m){
                    sum++;
                    //System.out.println("행이다");
                }
            }

            for(int i=0; i<n; i++){ // 모든 열에 대해서
                int num = arr[0][i];
                int cnt = 1;
                int max = 1;
                for(int j=1; j<n; j++){
                    if(num == arr[j][i])
                        cnt++;
                    else{
                        if(cnt >= m)   
                            max = cnt; 
                        cnt = 1;
                        num = arr[j][i];
                    }
                }
                if(cnt >= m || max >= m){
                    sum++;
                    //System.out.println("열이다");
                }
            }
            System.out.println(sum);
        }

    }
}