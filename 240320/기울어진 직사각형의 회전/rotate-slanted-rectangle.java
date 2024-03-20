import java.util.*;

public class Main {

    public static int n,r,c,m1,m2,m3,m4,dir;
    public static int[][] arr;

    public static void clock(){
        int tmp = arr[r][c];
        for(int i=0; i<m1; i++){ //1번 방향에 대해
            arr[r-i][c+i] = arr[r-i-1][c+i+1];
        }
        for(int i=0; i<m2; i++){ //2번 방향에 대해
            arr[r-m1-i][c+m1-i] = arr[r-m1-i-1][c+m1-i-1];
        }
        for(int i=0; i<m3; i++){ //3번 방향에 대해
            arr[r-m1-m2+i][c+m1-m2-i] = arr[r-m1-m2+i+1][c+m1-m2-i-1];
        }
        for(int i=0; i<m4; i++){ //4번 방향에 대해
            arr[r-m4+i][c-m4+i] = arr[r-m4+i+1][c-m4+i+1];
        }
        arr[r-1][c-1] = tmp;
    }

    public static void clockOther(){
        int tmp = arr[r][c];
        for(int i=0; i<m4; i++){ //4번 방향에 대해 
            arr[r-i][c-i] = arr[r-i-1][c-i-1];
            //System.out.println(arr[r-i][c-i]);
        }
        for(int i=0; i<m3; i++){ //3번 방향에 대해 
            arr[r-m4-i][c-m4+i] = arr[r-m4-i-1][c-m4+i+1];
            //System.out.println(arr[r-m4-i][c-m4+i]);
        }
        for(int i=0; i<m2; i++){ //2번 방향에 대해
            arr[r-m4-m3+i][c-m4+m3+i] = arr[r-m4-m3+i+1][c-m4+m3+i+1];
        }
        for(int i=0; i<m1; i++){ //1번 방향에 대해
            arr[r-m1+i][c+m1-i] = arr[r-m1-i+1][c+m1+i-1];
        }
        arr[r-1][c+1] = tmp;
    }

    public static void check(){
        if(dir == 1) // 시계 방향으로 1칸씩 이동
           clock();
        else
            clockOther(); // 반시계 방향으로 1칸씩 이동
        // 출력
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1][n+1];
        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++)
                arr[i][j] = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt(); // r행 c열에서 시작
        m1 = sc.nextInt(); // 1번 방향으로 m1만큼 이동
        m2 = sc.nextInt();
        m3 = sc.nextInt();
        m4 = sc.nextInt();
        dir = sc.nextInt(); // 1이면 시계방향, 0이면 반시계방향
        check();
    }
}