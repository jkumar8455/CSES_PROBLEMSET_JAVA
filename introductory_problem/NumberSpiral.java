import java.util.*;
import java.io.*;

public class NumberSpiral {
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

    public static void solve() throws Exception {
        long x=in.nextLong();
        long y=in.nextLong();
        long ans=0;
        if(x>=y){
            if((x&1)==1){
                ans=(x-1)*(x-1)+y;
            }
            else{
                ans=x*x-y+1;
            }
        }
        else{
            if((y&1)==0){
                ans=(y-1)*(y-1)+x;
            }
            else{
                ans=y*y-x+1;
            }
        }
        out.print(ans);
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
