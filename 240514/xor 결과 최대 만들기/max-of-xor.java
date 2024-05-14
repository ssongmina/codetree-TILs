import java.util.*;

public class Main {

    public static int n,m, max = 0;
    public static ArrayList<Integer> input = new ArrayList<>();
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

        arr.add(input.get(num-1));
        choose(num+1, cnt+1);
        arr.remove(arr.size()-1);

        choose(num+1, cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            input.add(a);
        }
        choose(1, 0);
       
        System.out.println(max);
    }   
}