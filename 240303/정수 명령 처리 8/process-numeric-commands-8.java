public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> list = new LinkedList<>();
        StringBuilder s = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken;
            switch(str){
                case "push_front":
                    int a = Integer.parseInt(st.nextToken);
                    list.addFirst(a);
                    break;
                case "push_back":
                    int a = Integer.parseInt(st.nextToken);
                    list.addLast(a);
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
                    s.append(list.peekFirst());
                    break;
                case "back":
                    s.append(list.peekLast());
                    break;
            }
        }
        s.flush();
    }
}