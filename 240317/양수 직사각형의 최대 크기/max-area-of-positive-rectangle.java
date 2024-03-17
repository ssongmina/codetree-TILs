import java.util.*;

public class Main {

    public static int[][] arr;
    public static int n;
    public static int m;

    public static int findMax(){
        int max = 0;
        for(int a=0; a<n; a++)
            for(int b=0; b<m; b++)
                for(int c=0; c<n; c++)
                    for(int d=0; d<m; d++){
                        int cnt = findMax(a,b,c,d);
                        max = Math.max(cnt, max);
                    }
        return max;
    }

    public static int findMax(int a, int b, int c, int d){
        if(a > c || b > d)
            return -1;
        for(int i=a; i<=c; i++){
            for(int j=b; j<=d; j++){
                if(arr[i][j] <=0)
                    return -1;
            }
        }
        return (c-a+1)*(d-b+1);
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        for(int i=0; i<n; i++)  
            for(int j=0; j<m; j++){
                arr[i][j] = sc.nextInt();
            }
        int cnt = findMax();
        System.out.println(cnt);
        
        
    }
}