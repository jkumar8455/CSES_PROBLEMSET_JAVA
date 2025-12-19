import java.util.*;
import java.io.*;

public class KnightMovesGrid {
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
    static class Element{
        public int dist;
        public int x;
        public int y;
        public Element(int dist,int x,int y){
            this.dist=dist;
            this.x=x;
            this.y=y;
        }
    }
    public static void solve() throws Exception {
        int n=in.nextInt();
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0;
        Queue<Element> queue=new LinkedList<>();
        queue.add(new Element(0, 0, 0));
        int[][] moves={{-2,1},{-2,-1},{2,1},{2,-1},{1,2},{1,-2},{-1,2},{-1,-2}};
        while (!queue.isEmpty()) {
            Element current=queue.poll();
            for(int i=0;i<8;i++){
                int x=moves[i][0]+current.x;
                int y=moves[i][1]+current.y;
                if(x>=0 && y>=0 && x<n && y<n && dist[x][y]==Integer.MAX_VALUE){
                    dist[x][y]=current.dist+1;
                    queue.add(new Element(current.dist+1, x, y));
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                out.print(dist[i][j]+" ");
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
