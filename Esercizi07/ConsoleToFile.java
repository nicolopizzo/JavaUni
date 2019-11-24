import java.io.*;

public class ConsoleToFile {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        FileWriter f = new FileWriter("out.txt");
        PrintWriter out = new PrintWriter(new BufferedWriter(f));
        
        String s;
        
        System.out.println("Type CTRL+D to quit");
        while ((s = in.readLine()) != null)
            out.println(s);
        
        out.close();
        in.close();
    }
}
