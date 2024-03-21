import java.util.*;

public class Main {
    
    public static char[] a;

    public static void shift(){
        char[] aa = new char[a.length];
        aa[0] = a[a.length-1];
        for(int i=1; i<a.length; i++)
            aa[i] = a[i-1];
        for(int i=0; i<a.length; i++)
            a[i] = aa[i];
        //System.out.println(a);
    }

    public static int count(){
        int cnt = 0;
        int num = 1;
        for(int i=0; i<a.length-1; i++){
            if(a[i] == a[i+1]){
                num++;
            }
            /*else if(i == a.length-2 && a[i] == a[i+1]){
                cnt += (num/10)+2;
            }
            else if(i == a.length-2 && a[i] != a[i+1]){
                cnt += (num/10)+4;
            }*/
            else{
                cnt += (num/10)+1+1;
                num = 1;
            }
            
        }
        if(a[a.length-2] == a[a.length-1]){
            cnt += (num/10)+1;
        }
        else{
            cnt += (num/10)+1;
            cnt += 2;
        }
        return cnt;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        a = sc.next().toCharArray();
        int min = 100000000;
        for(int i=0; i<a.length; i++){
            shift();
            int cnt = count();
            min = Math.min(cnt+1, min);
        }
        System.out.println(min);
    }
}