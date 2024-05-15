import java.util.*;

public class Main {

    public static int n, sum1, sum2, min = 1000000000;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void choose(int num, int cnt1, int cnt2){
        if(cnt1 == n/2){
            for(int i=num; i<arr.size(); i++)
                sum2 += arr.get(i);
            min = Math.min(min, Math.abs(sum1-sum2));
            return;
        }
        else if(cnt2 == n/2){
            for(int i=num; i<arr.size(); i++)
                sum1 += arr.get(i);
            min = Math.min(min, Math.abs(sum1-sum2));
            return;
        }
        if(num == n){
            min = Math.min(min, Math.abs(sum1-sum2));
            return;
        }
        // num번째 수를 내가 선택하는 경우
        sum1 += arr.get(num);
        choose(num+1,cnt1+1, cnt2);
        sum1 -= arr.get(num);

        // num번째 수를 내가 선택 안하는 경우
        sum2 += arr.get(num);
        choose(num+1, cnt1, cnt2+1);
        sum2 -= arr.get(num);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            arr.add(a);
        }
        choose(0,0,0);
        System.out.println(min);
    }
}