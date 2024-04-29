import java.util.*;

public class Main {

    public static int n;
    public static int cnt = 0;
    public static ArrayList<Integer> ans = new ArrayList<>();

    public static boolean check(){
        int arr[] = {0,0,0,0,0};
        int last = ans.get(0);
        arr[last]++;
        if(ans.size() == 1){
            if(last == 1)
                return true;
            else
                return false;

        }
        for(int i=1; i<ans.size(); i++){
            int a = ans.get(i);
            if(a != last){
                int b = arr[last];
                if(b%last != 0)
                    return false;
            }
            arr[a]++;
            last = a;
        }
        if(arr[last]%last != 0)
            return false;
        return true;
    }

    public static void choose(int num){
        if(num == n){
            boolean bool = check();
            if(bool){
                cnt++;
            }
            return;
        }
        for(int i=1; i<=4; i++){
            ans.add(i);
            choose(num+1);
            ans.remove(ans.size()-1);
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        choose(0);
        System.out.println(cnt);
    }
}