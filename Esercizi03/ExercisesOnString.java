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
        int count = 0;
        int l = pattern.length();

        for (int i = 0; i < text.length() - l + 1; i++)
            if (pattern.equals(text.substring(i, i+l)))
                count++;

        return count;
    }

    public static boolean isValidEmail(String email) {
        return email.matches("(\\w+)@(\\w+)(\\.\\w+)*\\.([a-z]{2}|com|edu|gov)");
    }

    public static boolean isValidEmail2(String email) {
        return email.indexOf("@") != 0 && email.contains("@") && !email.contains("@.") && email.endsWith(".it");
    }

    public static String fibonacciWord(int n) {
        String t = "";
        String z = "";
        StringBuilder s = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (i == 1)
                t = "b";
            else if (i == 2)
                z = "a";
            else if (i == 3)
                s.append(z+t);
            else {
                t = s.toString();
                s.append(z);
                z = t;
            }
        }

        return s.toString();
    }

    public static String randomString(int a, int n) {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < n; i++)
            s.append((char)('0' + Math.random()*a));

        return s.toString();
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
        
        StringBuilder t1 = new StringBuilder(t);
        for (int i = 0; i < s.length(); i++)
            if (t1.indexOf(s.substring(i,i+1)) != -1)
                t1.deleteCharAt(t1.indexOf(s.substring(i,i+1)));
            else
                return false;

        return true;
    }

    public static String eliminaVocali(String s) {
        return s.replaceAll("[aeiou]", "");
    }

    public static String stringCapitalize(String s) {
        StringBuilder t = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++)
            if (i == 0 || s.charAt(i-1) == ' ')
                t.replace(i, i+1, s.substring(i, i+1).toUpperCase());

        return t.toString();
    }

    public static String unaryOf(int n) {
        StringBuilder s = new StringBuilder(3);

        for (int i = 0; i < n; i++)
            s.append(0);

        return s.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String pattern = scan.nextLine();
        System.out.println(contaOccorrenze(text, pattern));
    }
}