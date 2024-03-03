import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        StringBuilder s = new StringBuilder();
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            String str = sc.next();
            switch(str){
                case "push_front":
                    int a = sc.nextInt();
                    list.addFirst(a);
                    break;
                case "push_back":
                    int b = sc.nextInt();
                    list.addLast(b);
                    break;
                case "pop_front":
                    s.append(list.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    s.append(list.pollLast()).append("\n");
                    break;
                case "size":
                    s.append(list.size()).append("\n");
                    break;
                case "empty":
                    boolean bool = list.isEmpty();
                    if(bool) s.append("1\n");
                    else s.append("0\n");
                    break;
                case "front":
                    s.append(list.peekFirst()).append("\n");
                    break;
                case "back":
                    s.append(list.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(s);
    }
}