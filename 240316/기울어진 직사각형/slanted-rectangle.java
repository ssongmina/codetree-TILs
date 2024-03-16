import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[][] arr;

    public static int getRec(int row, int col){
        int sec=n-col-1;
        int maxNum = 0;
        for(int i=1; i<=sec; i++){
            for(int j=1; j<=row-i; j++){
                if(row-j<0 || col-j<0)
                    continue;
                else{
                    int cnt = 0;
                    int for_r = row-j;
                    int for_c = col-j;
                    for(int a=1; a<=i; a++){ // 1
                        cnt += arr[row-a][col+a];
                        cnt += arr[for_r-a][for_c+a];
                    }
                    int sec_r = row-i;
                    int sec_c = col+i;
                    for(int b=1; b<=j; b++){ // 4
                        cnt += arr[row-b][col-b];
                        cnt += arr[sec_r-b][sec_c-b];
                    }

                    //int cnt = arr[row][col]+arr[row-i][col+i]+arr[row-i-j][col+i-j]+arr[row-j][col-j];
                    maxNum = Math.max(cnt, maxNum);
                }
            }
        }
        return maxNum;

    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int maxNum = 0;

        for(int i=2; i<n; i++){
            for(int j=1; j<n-1; j++){
                int cnt = getRec(i,j);
                maxNum = Math.max(cnt, maxNum);
            }
        }
        System.out.println(maxNum);
    }
}