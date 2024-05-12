import java.util.*;

public class Main {

    public static int n, m, k, max;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int[][] horse;

    public static int move(int cnt, int pos){
        int it=0;
        for(int i=1; i<=m; i++)
            if(horse[cnt][i] == 1){
                it = i;
                break;
            }
        horse[cnt][it] = 0;
        if(it+pos<=m){
            horse[cnt][it+pos] = 1;
            return 0;
        }
        else{
            horse[cnt][m] = 1;
            return it+pos-m;
        }

    }

    public static void remove(int cnt, int pos, int left){
        int it=0;
        for(int i=1; i<=m; i++)
            if(horse[cnt][i] == 1){
                it = i;
                break;
            }
        horse[cnt][it] = 0;
        if(left == 0)
            horse[cnt][it-pos] = 1;
        else
            horse[cnt][it-pos+left] = 1;
    }

    public static void check(){
        int cnt = 0;
        for(int i=1; i<=k; i++)
            if(horse[i][m] == 1)
                cnt++;
        max = Math.max(max, cnt);
    }

    public static void choose(int num){
        if(num == n){
            check();
            return;
        }
        for(int i=1; i<=k; i++){
            //i번째 말을 arr.get(num)의 수 만큼 옮기기
            int a = arr.get(num);
            int p = move(i,a);
            choose(num+1);
            remove(i,a, p);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            arr.add(a);
        }
        horse = new int[k+1][m+1];
        for(int i=1; i<=k; i++)
            horse[i][1] = 1;
        choose(0);
        System.out.println(max);
    }
}