import java.util.*;

public class Main {

    public static int n, min = 100000;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static ArrayList<Integer> sum1 = new ArrayList<>();
    public static ArrayList<Integer> sum2 = new ArrayList<>();

    public static void choose(int num){
        if(num == 2*n){
            if(sum1.size() != sum2.size()){
                return;
            }
            int s1=0, s2=0;
            for(int i=0; i<n; i++){
                s1 += sum1.get(i);
                s2 += sum2.get(i);
            }
            min = Math.min(min, Math.abs(s1-s2));
            return;
        }
        int a = arr.get(num);

        sum1.add(a);
        choose(num+1);
        sum1.remove(sum1.size()-1);

        sum2.add(a);
        choose(num+1);
        sum2.remove(sum2.size()-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0; i<2*n; i++){
            int a = sc.nextInt();
            arr.add(a);
        }
        choose(0);
        System.out.println(min);
    }
}