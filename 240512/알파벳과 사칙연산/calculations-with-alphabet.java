import java.util.*;

public class Main {

    public static int n,max = -1000000000;
    public static String str;
    public static char c = 'a';
    public static int[] alphabet = new int[6];
    public static char[] arr;

    public static void check(){
        // arr로 값 계산해서 max에 값 담기
        char fir = arr[0];
        int sum = alphabet[(int)(fir-'a')];
        int cnt = 1;
        for(int i=0; i<(n-1)/2; i++){
            char a = arr[cnt+1];
            switch(arr[cnt]){
                case '+':
                    sum += alphabet[(int)(a-'a')];
                    break;
                case '-':
                    sum -= alphabet[(int)(a-'a')];
                    break;
                case '*':
                    sum *= alphabet[(int)(a-'a')];
                    break;
            }
            cnt += 2;
        }
        max = Math.max(max, sum);
    }

    public static void find(int num){
        if((c-'a')+1 == num){
            check();
            return;
        }
        for(int i=1; i<=4; i++){
            alphabet[num] = i;
            find(num+1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();
        n = str.length();
        arr = new char[n];
        for(int i=0; i<n; i++){
            arr[i] = str.charAt(i);
            if((int)arr[i] > c)
                c = arr[i];
        }
        if(n == 1)
            System.out.println("4");
        else{
            find(0);
            System.out.println(max);
        }
    }
}