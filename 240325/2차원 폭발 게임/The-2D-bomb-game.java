import java.util.*;

public class Main {

    public static int n,m,k;
    public static int[][] arr;

    // m개의 연속된 폭탄을 터트리고 90도로 회전하기
    public static void bomb(){ 
        for(int i=0; i<n; i++){ // 각 열에 대해서 계산.
            for(int j=0; j<n; j++){
                if(arr[j][i] == 0)
                    continue;
                else{
                    int have = have(i, j); // m개의 연속된 폭탄이 있으면 폭탄의 갯수
                    if(have == -1)
                        continue;
                    else{
                        makeNull(i,j,have);
                    }

                }
            }
        }
        shift(); // 폭탄 터트린거 중력의 힘으로~
        rotate(); // 90도로 회전하기
        shift();
        for(int i=0; i<n; i++){ // 각 열에 대해서 계산.
            for(int j=0; j<n; j++){
                if(arr[j][i] == 0)
                    continue;
                else{
                    int have = have(i, j); // m개의 연속된 폭탄이 있으면 폭탄의 갯수
                    if(have == -1)
                        continue;
                    else{
                        makeNull(i,j,have);
                    }

                }
            }
        }
        shift();
        
    }

    // 폭탄 터트린거 중력의 힘으로~
    public static void shift(){
        for(int i=0; i<n; i++){
            int[] brr = new int[n];
            int cnt = n-1;
            for(int j=n-1; j>=0; j--){
                if(arr[j][i] != 0){
                    brr[cnt] = arr[j][i];
                    cnt--;
                }
            }
            for(int j=0; j<n; j++)
                arr[j][i] = brr[j];
        }
    }

    // 90도로 회전하기
    public static void rotate(){
        int[][] crr = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                crr[i][j] = arr[i][j];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                arr[i][j] = crr[n-j-1][i];
        }
    }

    public static void makeNull(int col, int row, int cnt){
        for(int i=row; i<cnt+row; i++)
            arr[i][col] = 0;
    }

    // m개의 연속된 폭탄이 있으면 폭탄의 갯수
    public static int have(int col, int row){
        int num = arr[row][col];
        int cnt = 1;
        for(int i=row+1; i<n; i++){
            if(arr[i][col] == num){
                cnt++;
            }
            else{
                break;
            }
        }
        if(cnt >= m)
            return cnt;
        else 
            return -1;
    }

    // 남아있는 폭탄의 개수 세기
    public static int numOfBomb(){ 
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] != 0)
                    cnt++;
            }
        }
        return cnt;
    }   
    
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt(); // m개의 연속된 폭탄
        k = sc.nextInt(); // k번 반복
        arr = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                arr[i][j] = sc.nextInt();
        
        for(int i=0; i<k; i++){
            bomb();
        }

       System.out.println(numOfBomb());
    }
}