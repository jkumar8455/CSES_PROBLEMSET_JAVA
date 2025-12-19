import java.util.*;
import java.io.*;

public class CreatingStrings {
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

    static void func(int n,int[] freq,Collection<String> result,StringBuilder sb){
        if(n==0){
            result.add(sb.toString());
            return;
        }
        else{
            for(int i=0;i<26;i++){
                for(int j=1;j<=freq[i];j++){
                    freq[i]--;                    
                    sb.append((char) (i+'a'));
                    func(n-1, freq, result, sb);
                    freq[i]++;
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }

    public static void solve() throws Exception {
        String s=in.next();
        // out.println(s);
        Collection<String> result=new TreeSet<>();
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }        
        func(s.length(), freq, result,new StringBuilder());
        out.println(result.size());
        for(String x:result){
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
