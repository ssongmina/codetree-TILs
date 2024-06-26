import java.util.*;

public class Main {

    public static int n, people_num;
    public static int[][] arr =  new int[25][25];
    public static int[][] visited = new int[25][25];
    public static ArrayList<Integer> people = new ArrayList<>();
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};

    public static boolean canGo(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= n)
            return false;
        if(visited[x][y] == 1 || arr[x][y] == 0)
            return false;
        return true;
    }

    public static void dfs(int x, int y){
        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(canGo(newX, newY)){
                visited[newX][newY] = 1;
                people_num++;
                dfs(newX, newY);

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                arr[i][j] = sc.nextInt();
        
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                if(canGo(i,j)){
                    visited[i][j] = 1;
                    people_num = 1;
                    dfs(i,j);

                    people.add(people_num);
                }

        Collections.sort(people);
        System.out.println(people.size());
        for(int i=0; i<people.size(); i++)
            System.out.println(people.get(i));
    }
}