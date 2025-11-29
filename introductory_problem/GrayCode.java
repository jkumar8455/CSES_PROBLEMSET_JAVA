import java.util.*;
import java.io.*;

public class GrayCode {
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
        int n=in.nextInt();        
        List<String> list=new ArrayList<>();
        list.add("");
        while(n-->0){
            List<String> next=new ArrayList<>();
            int m=list.size();
            for(int i=m-1;i>=0;i--){
                String cur=list.get(i);
                list.set(i, "0"+cur);
                next.add("1"+cur);
            }         
            for(String x:next){
                list.add(x);
            }
        }
        for(String x:list){
            out.println(x);
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
