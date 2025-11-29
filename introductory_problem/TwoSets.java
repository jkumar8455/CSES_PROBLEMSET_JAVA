import java.util.*;
import java.io.*;

public class TwoSets {
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
        long sum=0;
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        if((sum&1)==1){
            out.print("NO");
            return;
        }
        out.println("YES");
        sum/=2;
        List<Integer> first=new ArrayList<>();
        List<Integer> second=new ArrayList<>();
        for(int i=n;i>=1;i--){
            if(sum>=i){
                first.add(i);
                sum-=i;
            }
            else{
                second.add(i);
            }
        }        
        out.println(first.size());
        for(int x:first){
            out.print(x+" ");
        }
        out.println("");
        out.println(second.size());
        for(int x:second){
            out.print(x+" ");
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
