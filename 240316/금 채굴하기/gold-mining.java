import java.util.*;
import java.io.*;

public class Main {
    
    public static final int MAX_NUM = 20;
    public static int n,m;
    public static int[][] arr = new int[MAX_NUM][MAX_NUM];
    
    // 채굴 비용 반환
    public static int getCost(int k){
        return k*k + (k+1)*(k+1);
    }

    // k에 대해 채굴 가능한 금의 개수 반환
    public static int getNumOfGold(int row, int col, int k){
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(Math.abs(row-i)+Math.abs(col-i) <= k)
                    cnt += arr[i][j];
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int maxGold = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                arr[i][j] = sc.nextInt();

        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<=2*(n-1); k++){
                    int cnt = getNumOfGold(i,j,k);
                    if(cnt * m >= getCost(k))
                        maxGold = Math.max(maxGold, cnt);
                }
            }
        }
        System.out.println(maxGold);

    }
}