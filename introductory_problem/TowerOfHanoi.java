import java.util.*;
import java.io.*;

public class TowerOfHanoi {
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
    public static void toh(int n,int a,int b,int c,List<String>answer){
        if(n>=1){
            toh(n-1,a,c,b,answer);
            answer.add(a+" "+c);
            toh(n-1,b,a,c,answer);
        }        
    }
    public static void solve() throws Exception {
        int n=in.nextInt();
        List<String> answer=new ArrayList<>();
        toh(n,1,2,3,answer);
        out.println(answer.size());
        for(String s:answer){
            out.println(s);
        }
    }

    public static void main(String[] args) {
        try {
            int tc=1;
            // tc = in.nextInt();
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
