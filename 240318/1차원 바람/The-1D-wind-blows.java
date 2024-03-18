import java.util.*;

public class Main {
    public static int n,m,q;
    public static int[][] arr;

    public static void check(int row, String direction){
        if(direction.equals("L")){
            left(row);
        }
        else if(direction.equals("R")){
            right(row);
        }
        for(int i=row-1; i>=0; i--){ // 위로
            boolean bool = checkSame(i);
            if(bool){
                if(((row-i)%2==1) && direction.equals("L"))
                    right(i);
                else if(((row-i)%2==1) && direction.equals("R"))
                    left(i);
                else if(((row-i)%2==0) && direction.equals("L"))
                    left(i);
                else if(((row-i)%2==0) && direction.equals("R"))
                    right(i);
            }
            else
                break;
        }
        for(int i=row+1; i<n; i++){ // 아래로
            boolean bool = checkSameDown(i);
            if(bool){
                if(((i-row)%2==1) && direction.equals("L"))
                    right(i);
                else if(((i-row)%2==1) && direction.equals("R"))
                    left(i);
                else if(((i-row)%2==0) && direction.equals("L"))
                    left(i);
                else if(((i-row)%2==0) && direction.equals("R"))
                    right(i);
            }
            else
                break;
        }
    }

    public static boolean checkSame(int row){
        for(int i=0; i<m; i++){
            if(arr[row][i] == arr[row+1][i])
                return true;
        }
        return false;
    }
    public static boolean checkSameDown(int row){
        for(int i=0; i<m; i++){
            if(arr[row][i] == arr[row-1][i])
                return true;
        }
        return false;
    }

    public static void left(int row){
        int tmp = arr[row][m-1];
        for(int i=m-1; i>0; i--)
            arr[row][i] = arr[row][i-1];
        arr[row][0] = tmp;
    }

    public static void right(int row){
        int tmp = arr[row][0];
        for(int i=0; i<m-1; i++)
            arr[row][i] = arr[row][i+1];
        arr[row][m-1] = tmp;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        arr = new int[n][m];
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                arr[i][j] = sc.nextInt();
        for(int i=0; i<q; i++){
            int r = sc.nextInt();
            String d = sc.next();
            check(r-1, d);
            
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
    }
}