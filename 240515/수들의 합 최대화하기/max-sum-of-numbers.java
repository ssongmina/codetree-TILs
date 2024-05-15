import java.util.*;

public class Main {

    public static int n, max;
    public static int[][] arr = new int[11][11];
    public static boolean[] row = new boolean[11];
    public static boolean[] col = new boolean[11];
    public static ArrayList<Integer> sum = new ArrayList<>();

    // num회 색칠할 위치 선택
    public static void choose(int num){
        if(num == n+1){
            int cnt = 0;
            for(int i=0; i<sum.size(); i++){
                cnt += sum.get(i);
                //System.out.print(sum.get(i)+" ");
            }
            //System.out.println();
            max = Math.max(max, cnt);
            return ;
        }

        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++)
                if(row[i]==false && col[j]==false){
                    sum.add(arr[i][j]);
                    row[i] = true;
                    col[j] = true;
                    choose(num+1);
                    sum.remove(sum.size()-1);
                    row[i] = false;
                    col[j] = false;
                }
            

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++)
                arr[i][j] = sc.nextInt();

        choose(1);
        System.out.println(max);
    }
}