import java.util.*;
import java.io.*;

public class Permutations {
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
        if(n==1){
            out.print(1);
        }
        else if(n<=3){
            out.print("NO SOLUTION");
        }
        else{            
            List<Integer> nums=new ArrayList<>(Arrays.asList(3,1,4,2));            
            for(int i=5;i<=n;i+=2){
                nums.add(i);
            }
            Collections.reverse(nums);
            for(int i=6;i<=n;i+=2){
                nums.add(i);
            }
            for(int x:nums){
                out.print(x+" ");
            }
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
