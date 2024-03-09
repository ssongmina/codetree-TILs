import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch(str){
                case "push":
                    int a = Integer.parseInt(st.nextToken());
                    s.push(a);
                    break;
                case "pop":
                    System.out.println(s.pop());
                    break;
                case "size":
                    System.out.println(s.size());
                    break;
                case "empty":
                    if(s.isEmpty())
                        System.out.println("1");
                    else
                        System.out.println("0");
                    break;
                case "top":
                    System.out.println(s.peek());
                    break;
            }
        }
        
    }
}