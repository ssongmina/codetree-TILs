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
        
        for(int i=1; i<n; i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && key < arr[j]){
                if(key < arr[j]){
                    int tmp = arr[j];
                    arr[j] = key;
                    arr[j+1] = tmp;
                    j--;
                }
            }
        }

        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}