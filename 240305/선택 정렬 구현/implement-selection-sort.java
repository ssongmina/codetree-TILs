import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        for(int i=0; i<n; i++){
            int min = i;
            for(int j=i; j<n; j++){
                if(arr[min] > arr[j])
                    min = j;
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
        for(int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }
}