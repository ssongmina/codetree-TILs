import java.util.*;

public class Main {

    public static int n;
    public static int[][] arr;

    public static void bomb(int r, int c){
        int a = arr[r][c];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        for(int i=0; i<4; i++){
            int x = r;
            int y = c;
            for(int j=1; j<a; j++){
                x = x + dx[i];
                y = y + dy[i];
                if(x < 1 || x > n || y < 1 || y > n)
                    continue;
                arr[x][y] = 0;
            }
        }
        arr[r][c] = 0;
    }

    public static void check(int a){
        int[] brr = new int[n+1];
        for(int i=1; i<=n; i++)
            brr[i] = arr[i][a];
        int cnt = n;
        for(int i=n; i>=1; i--){
            if(brr[i] == 0)
                continue;
            else{
                arr[cnt][a] = brr[i];
                cnt--;
            }
        }
        for(int i=1; i<=cnt; i++)
            arr[i][a] = 0;
        
    }

    public static void clean(){
        for(int i=1; i<=n; i++){ // 열에 대해서
            check(i);
            
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1][n+1];
        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++)
                arr[i][j] = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        bomb(r, c);
        /*for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }*/
        clean();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
}