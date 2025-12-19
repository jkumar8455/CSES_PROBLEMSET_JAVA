import java.util.*;
import java.io.*;

public class MexGridConstruction {
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
        int[][] arr=new int[n][n];
        Map<Integer,Set<Integer>> row=new HashMap<>();
        Map<Integer,Set<Integer>> col=new HashMap<>();
        for(int i=0;i<n;i++){
            row.put(i, new TreeSet<>());
            col.put(i, new TreeSet<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int cur=0;
                while(row.get(i).contains(cur) || col.get(j).contains(cur)){
                    cur++;
                }                
                arr[i][j]=cur;
                row.get(i).add(cur);
                col.get(j).add(cur);                
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                out.print(arr[i][j]+" ");
            }
            out.println("");
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
