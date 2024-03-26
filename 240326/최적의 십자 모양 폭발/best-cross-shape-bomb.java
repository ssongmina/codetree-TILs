import java.util.*;

public class Main {

    public static int n;
    public static int[][] arr;
    public static int[][] crr;

    public static void bomb(int row, int col){
        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++)
                arr[i][j] = crr[i][j];
        // 폭탄 터트리기
        int num = arr[row][col];
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            for(int i=0; i<4; i++){
                int x = row;
                int y = col;
                for(int j=1; j<num; j++){
                    x = x + dx[i];
                    y = y + dy[i];
                    if(x >= 1 && x <= n && y >= 1 && y <= n)
                        arr[x][y] = 0;
                    else 
                        break;
                }
            }
            arr[row][col] = 0;

        // 중력으로 인해 발생하는 결과 만들기
        for(int i=1; i<=n; i++)
            gravity(i);


    }

    public static void gravity(int col){
        int[] brr = new int[n+1];
        int cnt = n;
        for(int i=n; i>=1; i--){
            if(arr[i][col] != 0){
                brr[cnt] = arr[i][col];
                cnt--;
            }
        }
        for(int i=1; i<=n; i++)
            arr[i][col] = brr[i];
    }

    public static int check(){
        int cnt = 0;
        for(int i=1; i<=n; i++){ // 행
            for(int j=1; j<n; j++){ // 열
                if(arr[i][j] == 0)
                    continue;
                else{
                    if(arr[i][j] == arr[i][j+1]){ 
                        cnt++;
                        //System.out.println("행: "+i+" "+j);
                    }
                    if(arr[j][i] == arr[j+1][i]) {
                        cnt++;
                        //System.out.println("열: "+j+" "+i);
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n+1][n+1];
        crr = new int[n+1][n+1];
        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++){
                arr[i][j] = sc.nextInt();
                crr[i][j] = arr[i][j];
            }

        // 모든 행과 열에 대해서 폭탄을 터트리고, 쌍의 수가 최대인 경우 찾기
        int max = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                bomb(i,j);
                int cnt = check();
                if(cnt > max)
                    System.out.println(i+" "+j);
                max = Math.max(cnt, max);
                /*if(i==2 && j==3){
                    bomb(i,j);
                    int cnt = check();
                    max = Math.max(cnt, max);
                }*/
            }
        }
        System.out.println(max);
    }
}