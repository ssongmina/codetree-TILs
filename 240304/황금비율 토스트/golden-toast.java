import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
  	 public static void main(String[] args){
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int m = sc.nextInt();
	        String str1 = sc.next();

	        LinkedList<Character> I = new LinkedList<>();
	        for(int i=0; i<str1.length(); i++){
	            I.add(str1.charAt(i));
	        }
	        

	        ListIterator<Character> it = I.listIterator(I.size());
//	        it.previous();
//	        char str2 = sc.next().charAt(0);
//	        it.add(str2);
//	        it.next();
//	        it.previous();
//	        it.next();
//	        it.remove();
//	        it = I.listIterator();
//	        while(it.hasNext()){
//	            System.out.print(it.next());
//	        }
	        
	       	        
	        for(int i=0; i<=m; i++){
	            String[] str2 = sc.nextLine().split(" ");
	            if(str2[0].equals("L")){
	                if(it.hasPrevious()){
	                    it.previous();
	                }
	            }
	            else if(str2[0].equals("R")){
	                if(it.hasNext()){
	                    it.next();
	                }
	            }
	            else if(str2[0].equals("D")){
                    if(!I.isEmpty()){
	                    it.remove();
                    }
	            }
	            else if(str2[0].equals("P")){
	            	char ch = str2[1].charAt(0);
	                it.add(ch);
	        		it.next();
	            }
	           }
	          
	        it = I.listIterator();
	        while(it.hasNext()){
	            System.out.print(it.next());
	        }
	    }
}