import java.util.*;

public class Main {

    public static int n;
    public static int[] arr;
    public static int num;

    public static void minus(int f, int l){
        int[] brr = new int[n];
        int k=0;
        for(int i=1; i<= num; i++){
            if(f<=i && i<=l)
                continue;
            else{
                k++;
                brr[k] = arr[i];
                
            }
        }
        for(int i=1; i<=k; i++)
        arr[i] = brr[i];
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = n;
        arr = new int[n+1];
        for(int i=1; i<=n; i++)
            arr[i] = sc.nextInt();
        for(int i=0; i<2; i++){
            int first = sc.nextInt();
            int last = sc.nextInt();
            minus(first, last);
            num -= (last-first+1);
        }
        System.out.println(num);
        for(int i=1; i<=num; i++)
            System.out.println(arr[i]);

    }
}