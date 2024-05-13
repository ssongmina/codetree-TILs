import java.util.*;

public class Main {

    public static int n,m;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static void choose(int num){ //num은 arr의 size()와 동일.
        if(num == m){
            for(int i=0; i<arr.size(); i++)
                System.out.print(arr.get(i)+" ");
            System.out.println();
        }
        int lastNum = arr.get(num-1);
        for(int i=1; i<=n; i++){
            if(i <= lastNum)
                continue;
            arr.add(i);
            choose(num+1);
            arr.remove(arr.size()-1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i=1; i<=n; i++){
            arr.add(i);
            choose(1);
            arr.remove(arr.size()-1);
        }
        
    }
}