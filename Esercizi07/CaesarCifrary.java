import java.io.*;

public class CaesarCifrary {
    public static int encrypt(int c, int key) {
        return (c == ' ' || c == '\t' || c == '\n') ? c : c + key;
    }

    public static int decrypt(int c, int key) {
        return (c == ' ' || c == '\t' || c == '\n') ? c : c - key;
    }

    public static void main(String[] args) throws Exception{
        FileReader in = new FileReader("out.txt");
        FileWriter out = new FileWriter("input.txt");
        BufferedReader br = new BufferedReader(in);
        int c, key = 24;

        while ((c = br.read()) != -1)
            out.write(decrypt(c, key));

        in.close();
        out.close();
        br.close();
    }
}