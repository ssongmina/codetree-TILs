import java.util.*;

public class Main {
    
    public static char[] a;

    public static void shift(){
        char tmp = a[a.length-1];
        for(int i=a.length-1; i>0; i--)
            a[i] = a[i-1];
        a[0] = tmp;
    }

    public static int count(){
        int cnt = 1;
        char first = a[0];
        String s = "";
        for(int i=1; i<a.length; i++){
            char next = a[i];
            if(first == next) cnt++;
            else{
                s += first;
                s += cnt;

                first = next;
                cnt = 1;
            }
        }
        s += first;
        s += cnt;
        return s.length();
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        a = sc.next().toCharArray();
        int min = 100000000;
        for(int i=0; i<a.length; i++){
            shift();
            int cnt = count();
            min = Math.min(cnt, min);
        }
        System.out.println(min);
    }
}