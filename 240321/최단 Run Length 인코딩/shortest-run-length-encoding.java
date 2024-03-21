import java.util.*;

public class Main {

    public static char[] a;

    public static void shift(){
        char[] aa = new char[10];
        aa[0] = a[a.length-1];
        for(int i=1; i<a.length; i++)
            aa[i] = a[i-1];
        for(int i=0; i<a.length; i++)
            a[i] = aa[i];
        //System.out.println(aa);
    }

    public static int count(){
        int cnt = 2;
        for(int i=0; i<a.length-1; i++){
            if(a[i] != a[i+1]) cnt += 2;
        }
        return cnt;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        a= sc.next().toCharArray();
        int len = a.length;
        int min = 10000;
        boolean bool = true;
        char abc = a[0];
        for(int i=1; i<len; i++){
            if(abc != a[i]){
                bool = false;
                break;
            }
        }
        if(!bool){
            for(int i=1; i<=len; i++){
            shift();
            int cnt = count();
            min = Math.min(cnt, min);
            }
            System.out.println(min);
        }
        else{
            System.out.println("3");
        }
        
        
    }
}