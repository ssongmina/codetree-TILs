import java.util.*;

class Pair{
    int x1, x2;
    public Pair(int x1, int x2){
        this.x1 = x1;
        this.x2 = x2;
    }
}

public class Main {

    public static int n, max, max_num, max_linear, result;
    public static int[] arr = new int[1001];

    public static ArrayList<Pair> linear = new ArrayList<>();

    public static int check(){
        int cnt = 0;
        for(int i=1; i<=max_num; i++){
            //System.out.print(arr[i]+" ");
            if(arr[i] > 0)
                cnt++;
        }
        //System.out.println();
        result = Math.max(result, max_linear);
        return cnt;
    }

    public static boolean fill(int x1, int x2){
        boolean can = true;
        for(int i=x1; i<=x2; i++)
            if(arr[i] == 1){
                can = false;
                break;
            }
        if(can){
            for(int i=x1; i<=x2; i++)
                arr[i] = 1;
            max_linear++;
            return true;
        }
        else
            return false;
    }

    public static void delete(int x1, int x2){
        for(int i=x1; i<=x2; i++)
            arr[i] = 0;
        max_linear--;
    }

    public static void choose(int num){
        if(num == (int)linear.size()){
            max = Math.max(max, check());
            //result = Math.max(result, max_linear);
            return ;
        }
        int x1 = linear.get(num).x1;
        int x2 = linear.get(num).x2;
        max = Math.max(max, check());
        boolean bool = fill(x1,x2);
        choose(num+1);
        if(bool)
            delete(x1,x2);
        
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i=0; i<n; i++){
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            linear.add(new Pair(x1,x2));
            max_num = Math.max(max_num, Math.max(x2, x1));
        }
        for(int i=0; i<n; i++){
            choose(i);
        }
        System.out.println(result);
    }
}