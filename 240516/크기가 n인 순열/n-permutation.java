import java.util.*;

public class Main {

    public static int n;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static boolean[] use = new boolean[9];

    // num번째 자리 숫자를 선택하는 함수
    public static void choose(int num){
        if(num == n+1){
            for(int i=0; i<arr.size(); i++)
                System.out.print(arr.get(i)+" ");
            System.out.println();
        }

        for(int i=1; i<=n; i++){
            if(use[i] == false){
                arr.add(i);
                use[i] = true;
                choose(num+1);
                arr.remove(arr.size()-1);
                use[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        choose(1);
    }
}