import java.util.*;
import java.io.*;

public class AppleDivision {
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
    private static long func(int index,int[] arr,long sum,long cur_sum){        
        if(cur_sum>sum/2 || index==arr.length){
            return Math.abs(sum-2*cur_sum);            
        }
        long skipped=func(index+1, arr, sum, cur_sum);
        long picked=func(index+1, arr, sum, cur_sum+arr[index]);
        return Math.min(skipped, picked);
    }
    public static void solve() throws Exception {
        int n=in.nextInt();
        int[] arr=new int[n];
        long sum=0;
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
            sum+=arr[i];
        }
        long ans=Long.MAX_VALUE;
        for(int mask=0;mask<(1<<n);mask++){
            long cur_sum=0;
            for(int i=0;i<n;i++){
                int ithBit=mask&(1<<i);
                if(ithBit!=0){
                    cur_sum+=arr[i];
                }
            }
            ans=Math.min(ans, Math.abs(sum-2*cur_sum));
        }        
        // out.print(func(0,arr,sum,0));
        out.println(ans);
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
