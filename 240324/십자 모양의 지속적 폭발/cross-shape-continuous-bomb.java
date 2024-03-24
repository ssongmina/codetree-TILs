import java.util.*;

public class Main {

    public static int n,m;
    public static int[][] arr;

    public static void bomb(int col){
        // 해당 열의 값이 있는 맨 윗 행 찾기
        int row = -1;
        for(int i=1; i<=n; i++){
            if(arr[i][col] != 0){
                row = i;
                break;
            }
        }

        // 폭탄 터트리기
        if(row != -1){
            int num = arr[row][col];
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            for(int i=0; i<4; i++){
                int x = row;
                int y = col;
                for(int j=1; j<num; j++){
                    x = x + dx[i];
                    y = y + dy[i];
                    if(x >= 1 && x <= n && y >= 1 && y <= n)
                        arr[x][y] = 0;
                    else 
                        break;
                }
            }
            arr[row][col] = 0;
        }
        

        // 중력으로 인해 발생하는 결과 만들기
        for(int i=1; i<=n; i++)
            gravity(i);

    }

    public static void gravity(int col){
        int[] brr = new int[n+1];
        int cnt = n;
        for(int i=n; i>=1; i--){
            if(arr[i][col] != 0){
                brr[cnt] = arr[i][col];
                cnt--;
            }
        }
        for(int i=1; i<=n; i++)
            arr[i][col] = brr[i];
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n+1][n+1];
        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++)
                arr[i][j] = sc.nextInt();

        for(int i=0; i<m; i++){
            int c = sc.nextInt();
            bomb(c);
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
}