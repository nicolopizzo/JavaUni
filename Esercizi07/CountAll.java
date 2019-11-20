import java.util.Scanner;
import java.io.*;


public class CountAll {
    public static void main(String[] args) throws Exception{
        FileReader fIn = new FileReader("input.txt");
        FileWriter out = new FileWriter("out.txt");
        BufferedReader scanIn = new BufferedReader(fIn);
        int nLines = 0, nWords = 0, nChars = 0, nAlphChars = 0, c, flag = 1;
        String s;
        String[] t;

        while ((s = scanIn.readLine()) != null) {
            t = s.split("(\\s)");

            for (String s1 : t) {
                if (!s1.matches("")) {
                    nChars += s1.length();
                    nAlphChars += s1.replaceAll("[^a-zA-Z]", "").length();
                    nWords++;
                }
            }

            nLines++;
        }


        out.write("Lines: " + nLines + "\nWords: " + nWords + "\nChars: " + nChars + "\nAlphabetic chars: " + nAlphChars);

        fIn.close();
        out.close();
        scanIn.close();

    }
}