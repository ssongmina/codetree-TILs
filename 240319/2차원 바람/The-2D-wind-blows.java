import java.util.*;

public class Main {

    public static int n,m,q;
    public static int[][] arr;
    public static int[][] add;

    public static void check(int r1, int c1, int r2, int c2){
        // 시계방향으로 회전
        change(r1,c1,r2,c2);
        // 평균 값으로 값 변경
        avg(r1, c1, r2, c2);
    }

    public static void forRow(int c1, int c2, int r1){
        for(int i=c1; i<=c2; i++){
            int num = 1;
            int cnt = arr[r1][i];
            if(arr[r1][i-1] != -1){
                num++;
                cnt += arr[r1][i-1];
            }
            if(arr[r1-1][i] != -1){
                num++;
                cnt += arr[r1-1][i];
            }
            if(arr[r1+1][i] != -1){
                num++;
                cnt += arr[r1+1][i];
            }
            if(arr[r1][i+1] != -1){
                num++;
                cnt += arr[r1][i+1];
            }
            add[r1][i] = cnt/num;
        }
    }

    public static void forCol(int r1, int r2, int c1){
        for(int i=r1; i<r2; i++){
            int cnt = arr[i][c1];
            int num = 1;
            if(arr[i][c1-1] != -1){
                cnt += arr[i][c1-1];
                num++;
            }
            if(arr[i][c1+1] != -1){
                cnt += arr[i][c1+1];
                num++;
            }
            if(arr[i-1][c1] != -1){
                cnt += arr[i-1][c1];
                num++;
            }
            if(arr[i+1][c1] != -1){
                cnt += arr[i+1][c1];
                num++;
            }
            add[i][c1] = cnt/num;
        }
    }

    public static void avg(int r1, int c1, int r2, int c2){
        for(int i=r1; i<=r2; i++)
            forRow(c1, c2, i); // r1에 대하여
        //forRow(c1, c2, r2); // r2에 대하여

        for(int i=r1; i<=r2; i++){
            for(int j=c1; j<=c2; j++)
                arr[i][j] = add[i][j];
            
        }
        
    }

    public static void change(int r1, int c1, int r2, int c2){
        int tmp = arr[r1][c1];
        for(int i=r1; i<r2; i++)
            arr[i][c1] = arr[i+1][c1];
        for(int i=c1; i<c2; i++)
            arr[r2][i] = arr[r2][i+1];
        for(int i=r2; i>r1; i--)
            arr[i][c2] = arr[i-1][c2];
        for(int i=c2; i>c1; i--)
            arr[r1][i] = arr[r1][i-1];
        arr[r1][c1+1] = tmp;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        arr = new int[n+2][m+2];
        add = new int[n+1][m+1];
        for(int i=1; i<=n; i++)
            for(int j=1; j<=m; j++)
                arr[i][j] = sc.nextInt();
        for(int i=0; i<n+2; i++){
            arr[i][0] = -1;
            arr[i][m+1]=-1;
        }
        for(int j=0; j<m+2; j++){
            arr[0][j] = -1;
            arr[n+1][j] = -1;
        }

        for(int i=0; i<q; i++){
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();
            check(r1,c1,r2,c2);
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
}