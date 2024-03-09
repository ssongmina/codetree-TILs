import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args){
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();
        Stack<Character> stack = new Stack<>();
        char[] c = str.toCharArray();
        boolean empty = false;
        for(int i=0; i<n; i++){
            if(c[i] == '(')
                stack.push('(');
            else if(stack.size() == 0){
                empty = true;
                break;
            }
            else
                stack.pop();
        }
        if(stack.isEmpty() && empty == false)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}