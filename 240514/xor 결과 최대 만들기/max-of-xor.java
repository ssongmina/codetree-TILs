import java.util.*;

public class Main {

    public static int n,m, max = 0;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void choose(int num, int cnt){
        if(num == n+1){
                if(cnt == m){
                    int sum = arr.get(0);
                    for(int i=1; i<arr.size(); i++)
                        sum ^= arr.get(i);
                    max = Math.max(max, sum);
                }
                return;
        }

        arr.add(num);
        choose(num+1, cnt+1);
        arr.remove(arr.size()-1);

        choose(num+1, cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        choose(1, 0);
        if(n==m && m==1)
            System.out.println("0");
        else
            System.out.println(max);
    }   
}