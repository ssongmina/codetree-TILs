import java.util.*;

public class Main {

    public static int n;
    public static int t;
    public static int[][] arr;

    public static void make(){
        int temp1 = arr[0][n-1];
        int temp2 = arr[1][n-1];
        for(int j=n-2; j>=0; j--){
            arr[0][j+1] = arr[0][j];
            arr[1][j+1] = arr[1][j];
        }
        arr[0][0] = temp2;
        arr[1][0] = temp1;
        
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        arr = new int[2][n];
        for(int i=0; i<2; i++)
            for(int j=0; j<n; j++)
                arr[i][j] = sc.nextInt();
        
        for(int i=0; i<t; i++)
            make();
        
        for(int i=0; i<2; i++){
            for(int j=0; j<n; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
}