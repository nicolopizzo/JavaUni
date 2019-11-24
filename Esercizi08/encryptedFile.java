import java.util.*;

public class encryptedFile {
    String password, message;
    int attempts;
    
    public encryptedFile(String password, String message) {
        Scanner scanString = new Scanner(System.in);
        
        if (checkChars(password))
            this.password = password;
            
        else {
            while(!checkChars(password)) {
                System.out.print("Enter a correct password: ");
                password = scanString.next();
            }
            this.password = password;
        }
        
        this.message = message;
    }
    
    public boolean isCorrect(String password) throws TooManyAttemptsException {
        if (this.attempts > 2)
            throw new TooManyAttemptsException();
        else {
            if (this.password.equals(password)) {
                attempts = 0;
                return true;
            }
            attempts++;
            return false;
        }
    }
    
    private static boolean checkChars(String password) {
        return password.length()>6 && password.matches("(\\w)*[0-9](\\w)*");
    }
    
    public void setPassword(String password) {
        Scanner scanString = new Scanner(System.in);
        if (!checkChars(password)) {
            System.out.println("Incorrect password.");
            return;
        }
        
        System.out.print("Enter the current password: ");
        if (scanString.next().equals(this.password))
            this.password = password;
        else
            System.out.println("Incorrect password.");
    }
    
    public void accessFile(String password) {
        try {
            if(isCorrect(password))
                System.out.println(this.getMessage() + "\n");
            else
                System.out.println("Password not correct\n");
        }
        catch (TooManyAttemptsException e) {
            System.out.println("Too many attempts. You cannot access the file anymore\n");
        }
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public static void main(String... args) {
        Scanner scanString = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        encryptedFile ef = new encryptedFile("carpaInSaccoccia99", "Suca");
        boolean b = true;
        
        do {
            System.out.println("Menu\n0)Exit\n1)Try the password\n2)Set a new password");
            switch(scanInt.nextInt()) {
                case 0:
                    b = false;
                    break;
                case 1:
                    System.out.print("Enter the password: ");
                    ef.accessFile(scanString.next());
                    break;
                case 2:
                    System.out.print("Enter the new password: ");
                    ef.setPassword(scanString.next());
                    break;
                default:
                    System.out.println("Wrong number entered");
            }
        } while(b);
        
        scanString.close();
        scanInt.close();
    }
}

class TooManyAttemptsException extends Exception {
    public TooManyAttemptsException () {
        super ("TooManyAttemptsException.");
    }
}
