import java.util.*;

public class Main {

    public static int[][] arr; // 1이면 뱀이 없다.
    public static int[][] visited = new int[101][101];
    public static int n, m;
    public static int possible = 0; // 1이면 성공
    public static int[] dx = {1,0};
    public static int[] dy = {0,1};

    public static boolean canGo(int x, int y){
        if(0>x || x>=n || 0>y || y>=m)
            return false;
        if(visited[x][y] == 1)
            return false;
        if(arr[x][y] == 0)
            return false;
        return true;
    }

    public static void dfs(int x, int y){
        if((x == n-1 && y == m-1) || possible == 1){
            possible = 1;
            return;
        }
            
        for(int i=0; i<2; i++){
            int a = x + dx[i];
            int b = y + dy[i];
            if(canGo(a,b)){
                visited[a][b] = 1;
                dfs(a,b);
                //visited[a][b] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                arr[i][j] = sc.nextInt();
        
        dfs(0,0);
        System.out.println(possible);
    }

}