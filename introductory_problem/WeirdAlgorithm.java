import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// Weird Algorithm
public class WeirdAlgorithm{
    static BufferedReader bf;
    public static void main(String[] args) throws NumberFormatException, IOException{
        bf = new BufferedReader(new InputStreamReader(System.in));
        Long num=Long.parseLong(bf.readLine());
        while(true){
            System.out.print(num+" ");
            if(num==1){
                break;
            }
            if((num&1)==1){
                num=num*3+1;
            } 
            else {
                num>>=1;
            }            
        }
    }
}