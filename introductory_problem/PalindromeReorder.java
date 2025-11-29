import java.util.*;
import java.io.*;

public class PalindromeReorder {
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
        String s=in.next();
        Map<Character,Integer> freq=new HashMap<>();
        for(int i=0;i<s.length();i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0)+1);
        }
        int cnt_odd=0;
        char ch='a';
        StringBuilder left=new StringBuilder();
        StringBuilder right=new StringBuilder();
        for(Map.Entry<Character,Integer> entry:freq.entrySet()){
            int cnt=entry.getValue();
            if((cnt&1)==1){
                cnt_odd++;
                ch=entry.getKey();
            }
            cnt/=2;
            while(cnt-->0){
                left.append(entry.getKey());
                right.append(entry.getKey());
            }
        }
        if(cnt_odd>1){
            out.print("NO SOLUTION");
        }
        else{
            if(cnt_odd>0) left.append(ch);
            right=right.reverse();
            left.append(right);
            out.print(left.toString());
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
