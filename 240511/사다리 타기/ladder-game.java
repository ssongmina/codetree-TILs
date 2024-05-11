import java.util.*;

class Pair implements Comparable<Pair> {
    int a, b;

    public Pair(int a, int b) {
        this.a = b;
        this.b = a;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(this.a, other.a);
    }
}


public class Main {

    public static int n,m;
    public static int min = 100;
    public static ArrayList<Pair> linear = new ArrayList<>();
    public static int[] ans = new int[12];
    public static int[] arr = new int[12];

    public static void check(int cnt){
        for(int i=1; i<=n; i++){
            if(arr[i] != ans[i])
                return ;
        }
        min = Math.min(min, cnt);
        return ;
    }

    public static void change(int cnum){
        int tmp = arr[cnum];
        arr[cnum] = arr[cnum+1];
        arr[cnum+1] = tmp;
    }

    public static void choose(int num, int cnt){
        // 더 이상 진행 할 수 없기에 check() 후 종료.
        if(num == (int)linear.size()){
            check(cnt);
            return ;
        }
        int k = linear.get(num).b;
        change(k); // 바꿈
        check(cnt+1);
        for(int i=num+1; i<=linear.size(); i++)
            choose(i, cnt+1);
        change(k); // 복원
    }
    
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            linear.add(new Pair(a,b));
        }

        Collections.sort(linear);

        for(int i=1; i<=n; i++){
            ans[i] = i;
            arr[i] = i;
        }

        // 정답 제작
        for(int i=0; i<linear.size(); i++){
            int a = linear.get(i).b;
            int tmp = ans[a];
            ans[a] = ans[a+1];
            ans[a+1] = tmp; 
        }
        int count = 0;
        for(int i=1; i<=n; i++){
            if(ans[i] == i)
                count++;
        }
        
        // 재귀 실행
        for(int i=0; i<n; i++){
            int cnt = 0;
            choose(i, cnt);
        }
        // 최소 선분 수 출력
        if(count == n)
            System.out.println("0");
        else
            System.out.println(min);
    }
}