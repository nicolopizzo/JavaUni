import java.util.*;
import java.io.*;

public class PrintLines {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fOut = new FileWriter("out.txt");
        String s;
        int c;
        System.out.println("Press :Q to exit.");

        while (!((s = in.readLine()).equals(":Q"))) {
            fOut.write(s+"\n");
        }

        fOut.close();
        in.close();
    }
}