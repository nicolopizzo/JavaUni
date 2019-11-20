import java.io.*;

public class AddCounter {
    public static void main(String[] args) throws Exception{
        FileReader in = new FileReader("input.txt");
        FileWriter out = new FileWriter("out.txt");
        BufferedReader br = new BufferedReader(in);
        String s;

        for (int i = 0; (s = br.readLine()) != null; i++)
            out.write((i+1) + "\t" + s + "\n");

        in.close();
        out.close();
        br.close();
    }
}