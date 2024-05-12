import java.util.*;

public class Main {

    public static int k, n;
    public static ArrayList<Integer> ans = new ArrayList<>();

    public static boolean check(int cnt){
        if(ans.size() <= 1)
            return true;
        if(ans.get(ans.size()-1) == cnt && ans.get(ans.size()-2) == cnt)
            return false;
        return true;
    }

    public static void printOut(){
        for(int i=0; i<ans.size(); i++)
            System.out.print(ans.get(i)+" ");
        System.out.println();
    }

    public static void choose(int num){
        if(num == n){
            printOut();
            return;
        }
        for(int i=1; i<=k; i++){
            if(check(i)){
                ans.add(i);
                choose(num+1);
                ans.remove(ans.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        
        choose(0);
    }
}