import java.util.*;

public class Main {

    public static int n,r,c;
    public static int[][] arr;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        arr = new int[n+1][n+1];
        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++)
                arr[i][j] = sc.nextInt();
        // 상 하 좌 우 우선 순위
        int[] dx = {-1, 1, 0, 0}; 
        int[] dy = {0, 0, -1, 1};
        boolean bool = true;
        System.out.print(arr[r][c]+" ");
        while(bool){
            boolean change = false;
            for(int i=0; i<4; i++){
                int x = r + dx[i];
                int y = c + dy[i];
                if(x>=1 && x<=n && y>=1 && y<=n){
                    if(arr[r][c] < arr[x][y]){
                    r = x;
                    c = y;
                    System.out.print(arr[r][c]+" ");
                    change = true;
                    break;
                }
                }
                
            }
            if(change == false)
                bool = false;
            
        }
    }
}