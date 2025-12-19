import java.util.*;
import java.io.*;

public class RaabGameI {
    static FastReader in = new FastReader();
    static FastWriter out = new FastWriter();

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        long nextLong() { return Long.parseLong(next()); }
        int nextInt() { return Integer.parseInt(next()); }
    }

    static class FastWriter {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        void print(Object o) throws IOException { bw.append(String.valueOf(o)); }
        void println(Object o) throws IOException { print(o); bw.append("\n"); }
        void close() throws IOException { bw.close(); }
    }

    static void printCollection(Collection<Integer> collection) throws IOException{
        for(Object object:collection){
            out.print(object+" ");
        }        
    }

    public static void solve() throws Exception {
        int n=in.nextInt();
        int a=in.nextInt();
        int b=in.nextInt();
        if((a==0 && b!=0) ||(a!=0 && b==0) || a+b>n){
            out.print("NO");
            return;
        }
        List<Integer> first = new ArrayList<>(),second=new ArrayList<>();
        int k=n-a-b;
        while((k--)>0){
            first.add(n);
            second.add(n--);            
        }
        int mini=Math.min(a, b);
        int start=n,end=n-mini;
        while(start!=0){
            first.add(start);
            second.add(end);
            start--;
            end--;
            if(end==0) end=n;
        }
        out.print("YES");
        out.println("");
        if(a>=b){
            printCollection(first);
            out.println("");
            printCollection(second);
        }
        else{
            printCollection(second);
            out.println("");
            printCollection(first);
        }
    }

    public static void main(String[] args) {
        try {
            int tc=1;
            tc = in.nextInt();
            while (tc--> 0) {
                solve();
                out.print("\n");
            }
            out.close();
        } catch (Exception e) {
            // ignore
        }
    }
}


/*
Solution for n n-1 1
n n-1
n-1 n-2
n-2 n-3
.
.
.
1 n

No solution for n 0 b , n a 0 , n a b where a>=n || b>=n

Solution for n a b where a+b=n-k
n n
n-1 n-2
n-2 n-3
.
.
1 n-1

*/