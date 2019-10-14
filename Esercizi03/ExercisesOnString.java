import java.util.Scanner;

public class ExercisesOnString {
    public static String iniziali() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Scrivi il nome: ");
        String nome = scan.next();
        System.out.print("Scrivi il cognome: ");
        String cognome = scan.next();
        scan.close();
        return "Iniziali: " + nome.charAt(0) + "&" + cognome.charAt(0);
    }

    public static String stringReverse(String s) {
        String t = "";

        for (int i = s.length()-1; i >= 0; i--)
            t += s.charAt(i);
        
        return t;
    }

    public static int contaOccorrenze(String text, String pattern) {
        String[] s = text.split(pattern);

        return s.length-1;
    }

    public static boolean isValidEmail(String email) {
        return email.matches("(.)*@(.*)\\.(it|com|net|edu|gov|fr|de)");
    }

    public static boolean isValidEmail2(String email) {
        return email.indexOf("@") != 0 && email.contains("@") && !email.contains("@.") && email.endsWith(".it");
    }

    public static String fibonacciWord(int n) {
        String t = "";
        String z = "";
        StringBuilder s = new StringBuilder("");

        for (int i = 1; i <= n; i++) {
            if (i == 1)
                t = "b";
            else if (i == 2)
                z = "a";
            else {
                s = new StringBuilder("");
                s.append(z);
                s.append(t);
                t = z;
                z = s.toString();
            }
        }

        return s.toString();
    }

    public static String randomString(int a, int n) {
        String s = "";

        for (int i = 0; i < n; i++) {
            double f = Math.random()/Math.nextDown(1.0);
            s += (char)('a' + (a*f));
        }
        
        return s;
    }

    public static int sumOfDigits(int n) {
        int sum = 0;

        for (int i = 1; i < n; i *= 10)
            sum += (n/i)%10;

        return sum;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        
        int[] index = new int[s.length()];

        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j != -1 && index[j] != 0)
                j = t.indexOf(s.charAt(i), j+1);
            if (j == -1)
                return false;
            index[j]++;
            j = 0;
        }

        return true;
    }

    public static String eliminaVocali(String s) {
        return s.replaceAll("[aeiou]", "");
    }

    public static String stringCapitalize(String s) {
        StringBuilder t = new StringBuilder(s);

        for(int i = 0; i < t.length()-1; i++)
            if((t.charAt(i) == ' ' || i == 0) && t.charAt(i+1) <= 'z' && t.charAt(i+1) >= 'a')
                t.setCharAt(i+1, (char)(t.charAt(i+1) + 'A'-'a'));

        return t.toString();
    }

    public static String unaryOf(int n) {
        StringBuilder s = new StringBuilder("");

        for (int i = 0; i < n; i++)
            s.append(0);

        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(randomString(6, 10));
    }
}