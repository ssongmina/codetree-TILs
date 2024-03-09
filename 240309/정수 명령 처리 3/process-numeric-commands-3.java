import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch(str){
                case "push_front":
                    int a = Integer.parseInt(st.nextToken());
                    dq.addFirst(a);
                    break;
                case "push_back":
                    int b = Integer.parseInt(st.nextToken());
                    dq.addLast(b);
                    break;
                case "pop_front":
                    System.out.println(dq.pollFirst());
                    break;
                case "pop_back":
                    System.out.println(dq.pollLast());
                    break;
                case "size":
                    System.out.println(dq.size());
                    break;
                case "empty":
                    if(dq.isEmpty())
                        System.out.println("1");
                    else
                        System.out.println("0");
                    break;
                case "front":
                    System.out.println(dq.peekFirst());
                    break;
                case "back":
                    System.out.println(dq.peekLast());
                    break;
            }
        }
    }
}