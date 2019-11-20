import java.io.*;

public class PrintChars {
    public static void main(String[] args) throws Exception{
        InputStreamReader in = new InputStreamReader(System.in);
        FileWriter out = new FileWriter("out2.txt");
        int c;

        while ((c = in.read()) != (char)0) {
            if (c == 0)
                System.out.println("Ci sono arrivato!");        
                // out.close();

            out.write(c);
        }

        System.out.println("Ci sono arrivato!");
        in.close();
    }
}