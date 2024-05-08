import java.util.*;

class Pair {
    int x,y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    public static int n, max;
    public static int[][] arr;
    public static boolean[][] original;
    public static int[][][] burst = {{{-2,0},{-1,0},{1,0},{2,0}}, {{1,0},{-1,0},{0,-1},{0,1}}, {{1,1},{1,-1},{-1,1},{-1,-1}}};

    public static ArrayList<Pair> bomb = new ArrayList<>();

    // 총 폭탄이 터질 위치 계산하기
    public static int check(){
        int cnt = 0;
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                if(arr[i][j] > 0)
                    cnt++;
        return cnt;
    }

    public static boolean range_check(int x, int y){
        if(0<=x && x<n && 0<=y && y<n)
            return true;
        return false;
    }

    public static void fill(int x, int y, int number){
        for(int i=0; i<4; i++){
            int dx = burst[number][i][0];
            int dy = burst[number][i][1];
            int row = x + dx;
            int col = y + dy;
            if(range_check(row, col)){
                arr[row][col]++;
            }
        }
        return;
    }

    public static void delete(int x, int y, int number){
        for(int i=0; i<4; i++){
            int dx = burst[number][i][0];
            int dy = burst[number][i][1];
            int row = x + dx;
            int col = y + dy;
            if(range_check(row, col)){
                arr[row][col]--;
            }
        }
        return;
    }

    // 백트래킹..
    public static void choose(int num){
        if(num == (int)bomb.size()){
            max = Math.max(max, check());
            return;
        }
        int x = bomb.get(num).x;
        int y = bomb.get(num).y;
        arr[x][y]++;

        for(int i=0; i<3; i++){
            fill(x,y,i);
            choose(num+1);
            delete(x,y,i);
        }


    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        original = new boolean[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++){
                int a = sc.nextInt();
                if(a > 0){
                    bomb.add(new Pair(i,j));
                }
                arr[i][j] = 0;

            }
        choose(0);
        System.out.println(max);
    }
}