import java.util.*;

public class Main {

    public static int n, min=100, cnt;
    public static int[] arr;

    public static void choose(int num){
        if(num >= n-1){
            //System.out.println("num: "+num+" cnt: "+cnt);
            min = Math.min(min, cnt);
            return;
        }
        int a = arr[num];
        for(int i=1; i<=a; i++){
            cnt++;
            choose(num+i);
            cnt--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        
        choose(0);
        if(min == 100)
            System.out.println("-1");
        else
            System.out.println(min);
    }

}