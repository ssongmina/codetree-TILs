import java.util.*;

public class Main {

    public static int n,m,k;
    public static int[][] arr;

    public static boolean find(int row){
        int cnt = 0;
        int empty = 0;
        for(int i=k; i<=k+m-1; i++){
            if(arr[row][i] == 1) cnt++;
            if(arr[row+1][i] == 1) empty++;
        }
        if(cnt == 0 && empty != 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.

        // 입력
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt(); // k번 ~ k+m-1번
        arr = new int[n+1][n+1];
        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++)
                arr[i][j] = sc.nextInt();

        // 넣을 수 있는 row 값 찾기
        int row = -1;
        for(int i=1; i<=n; i++){
            boolean row1 = find(i);
            if(row1){
                row = i;
                break;
            }
        }
        // 그 row에 값을 1로 변경
        for(int i=k; i<=k+m-1; i++)
            arr[row][i] = 1;
        // 출력
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
        
    }
}