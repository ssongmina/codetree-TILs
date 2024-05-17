import java.util.*;

public class Main {

    public static int n, min = 100000;
    public static int[][] arr = new int[11][11];
    public static boolean[] visit = new boolean[11];
    public static ArrayList<Integer> sum = new ArrayList<>();

    // row는 내가 지금 방문할 곳이고 cnt는 몇번이나 방문했는지를 나타냄
    public static void choose(int row, int cnt){
        if(cnt == n-1){
            int add = 0;
            for(int i=0; i<sum.size(); i++)
                add += sum.get(i);
            if(arr[row][1] != 0){
                add += arr[row][1];
                min = Math.min(min, add);
            }
            else
                return;
        }
        
        for(int i=1; i<=n; i++){
            if(visit[i] == false && arr[row][i] != 0){
                visit[i] = true;
                sum.add(arr[row][i]);
                choose(i, cnt+1);
                sum.remove(sum.size()-1);
                visit[i] = false;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++)
                arr[i][j] = sc.nextInt();
        
        visit[1] = true;
        for(int i=2; i<=n; i++){
            if(arr[1][i] == 0)
                continue;
            visit[i] = true;
            sum.add(arr[1][i]);
            choose(i, 1);
            sum.remove(sum.size()-1);
            visit[i] = false;
        }

        System.out.println(min);
    }
}