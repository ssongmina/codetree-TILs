import java.util.*;

public class Main {
    
    public static int n,m,k;
    public static int[][] arr;

    public static int find(){
        for(int i=n; i>=1; i--){
            int cnt = 0;
            for(int j=k; j<=k+m-1; j++){
                if(arr[i][j] == 0)
                    cnt++;
            }
            if(cnt == m)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt(); // k열 부터 k_m-1열까지
        arr = new int[n+1][n+1];
        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++)
                arr[i][j] = sc.nextInt();

        int row = find();
        for(int i=k; i<=k+m-1; i++){
            arr[row][i] = 1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }

    }
}