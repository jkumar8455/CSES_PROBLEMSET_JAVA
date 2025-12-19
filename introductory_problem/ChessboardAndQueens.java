import java.util.*;
import java.io.*;

public class ChessboardAndQueens {
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
                try {
                    String line =br.readLine(); 
                    if(line==null) return null;
                    st = new StringTokenizer(line); 
                }
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

    public static long func(int i,int n,char[][]arr,boolean[][] queenPlaced){
        if(i==n) return 1;
        long ans=0;
        int[][] paths={{-1,-1},{-1,1},{-1,0}};
        for(int j=0;j<n;j++){
            if(arr[i][j]=='*') continue;
            boolean violated=false;
            for(int k=1;k<=n;k++){
                for(int a=0;a<3;a++){
                    int x=paths[a][0]*k+i;
                    int y=paths[a][1]*k+j;
                    if(isvalid(x,y,n) && queenPlaced[x][y]){
                        violated=true;
                    }
                }
            }
            if(!violated){
                queenPlaced[i][j]=true;
                ans+=func(i+1, n, arr, queenPlaced);
                queenPlaced[i][j]=false;
            }
        }
        return ans;
    }
    private static boolean isvalid(int x, int y, int n) {
        if(x>=0 && y>=0 && x<n && y<n) return true;
        return false;
    }
    public static void solve() throws Exception {
        List<String> list=new ArrayList<>();
        String s=in.next();
        while(s!=null){
            list.add(s);
            s=in.next();
        }
        if(list.isEmpty()){
            return;
        }
        int n=list.size();        
        char[][] arr=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=list.get(i).charAt(j);                
            }            
        }
        boolean[][] queenPlaced=new boolean[n][n];
        out.print(func(0,n,arr,queenPlaced));
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
