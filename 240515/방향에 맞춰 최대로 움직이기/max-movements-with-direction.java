import java.util.*;

public class Main {

    public static int n,r,c,max,cnt;
    public static int[][] arr = new int[5][5];
    public static int[][] dir = new int[5][5];
    public static int[][] pos = {{0,0}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};

    public static boolean range(int dx, int dy){
        if(0<dx && dx<=n && 0<dy && dy<=n)
            return true;
        return false;
    }

    public static void choose(int r, int c){
        int a = dir[r][c];
        for(int i=1; i<n; i++){
            int dx = r + i*pos[a][0];
            int dy = c + i*pos[a][1];
            if(range(dx, dy))
                if(arr[dx][dy] > arr[r][c]){
                    cnt++;
                    max = Math.max(max, cnt);
                    choose(dx, dy);
                    cnt--;  
                }
        }  
                
            
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++)
                arr[i][j] = sc.nextInt();
        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++)
                dir[i][j] = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        choose(r,c);
        System.out.println(max);
    }
}