import java.util.*;

public class Main {

    public static int n, result;
    public static int[][] cost = new int[11][11];
    public static ArrayList<Integer> sum = new ArrayList<>();
    public static boolean[] row = new boolean[11];
    public static boolean[] col = new boolean[11];

    // num행에 대해서 열 선택하기
    public static void choose(int num){
        if(num == n+1){
            int small = sum.get(0);
            for(int i=1; i<sum.size(); i++)
                small = Math.min(small, sum.get(i));
            result = small;
            return;
        }
        
        row[num] = true;
        for(int i=1; i<=n; i++){
            if(col[i] == false){
                col[i] = true;
                sum.add(cost[num][i]);
                choose(num+1);
                sum.remove(sum.size()-1);
                col[i] = false;
            }
        }
        row[num] = false;


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++)
                cost[i][j] = sc.nextInt();
    
        choose(1);
        System.out.println(result);
    }
}