import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                arr[i][j] = sc.nextInt();
        
        int max = 0;
        for(int i=0; i<n-2; i++){
            for(int j=0; j<n-2; j++){
                int cnt = sum(arr, i,j);
                if(cnt > max)
                    max = cnt;        
            }
        }
        System.out.println(max);
    }

    public static int sum(int[][] arr, int i, int j){
        int sum = 0;
        for(int a = i; a<i+3; i++){
            for(int b = j; b<j+3; j++){
                if(arr[a][b] == 1)
                    sum++;
            }
        }
        return sum;
    }
}