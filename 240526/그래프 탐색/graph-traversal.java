import java.util.*;

public class Main {

    public static int n,m,cnt;
    public static ArrayList<Integer>[] graph = new ArrayList[1001];
    public static boolean[] visited = new boolean[1001];

    // num번째 시작이다.
    public static void dfs(int num){
        for(int i=0; i<graph[num].size(); i++){
            int a = graph[num].get(i);
            if(!visited[a]){
                visited[a] = true;
                cnt++;
                dfs(a);
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph[start].add(end);
            graph[end].add(start);
        }

        visited[1] = true;
        dfs(1);
        System.out.println(cnt);
    }
}