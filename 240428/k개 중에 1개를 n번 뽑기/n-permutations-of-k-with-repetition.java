import java.util.*;

public class Main {

    public static int k,n;
    public static ArrayList<Integer> ans = new ArrayList<>();

    public static void print(){
        for(int i=0; i<ans.size(); i++)
            System.out.print(ans.get(i)+" ");
        System.out.println();
    }

    public static void choose(int num){
        if(num == n+1){
            print();
            return;
        }
        for(int i=1; i<=k; i++){
            ans.add(i);
            choose(num+1);
            ans.remove(ans.size()-1);
        }
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt(); //1부터 k까지
        n = sc.nextInt(); //n번 반복
        choose(1);
    }
}