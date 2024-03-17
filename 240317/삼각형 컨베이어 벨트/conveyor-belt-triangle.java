import java.util.*;

public class Main {

    public static int n;
    public static int t;
    public static int[] arr;

    public static void make(){
        int temp = arr[3*n -1];
        for(int i=3*n-2; i>=0; i--)
            arr[i+1] = arr[i];
        arr[0] = temp;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        arr = new int[3*n];
        for(int i=0; i<3*n; i++)
            arr[i] = sc.nextInt();
        
        for(int i=0; i<t; i++)
            make();
        int cnt = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<n; j++){
                System.out.print(arr[cnt]+" ");
                cnt++;
            }
            System.out.println();
        }
    }
}