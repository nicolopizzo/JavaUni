import java.util.*;

public class Airplane {
    private Seat[] seats;
    private boolean full;
    
    public Airplane(int rows) {
        this.seats = new Seat[rows*6];
        for (int i = 0; i < rows*6; i++)
            this.seats[i] = new Seat(String.valueOf((1 + i/6)) + (char)('A' + i%6));
    }
    
    public void displayPassengers() {
        for (int i = 0; i < this.seats.length; i++)
            if (!this.seats[i].isAvailable())
                System.out.println(this.seats[i]);
    }
    
    public ArrayList<Seat> getFreeSeats() {
        ArrayList<Seat> arr = new ArrayList<>();
        
        for (int i = 0; i < this.seats.length; i++)
            if (this.seats[i].isAvailable())
                arr.add(this.seats[i]);
                
        return arr;
    }
    
    public void removeSeat(String id) {
        try {
            this.seats[getPosition(id)].deletePassenger();
            this.full = false;
        }
        
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You entered a wrong ID");
        }
        
        catch (IsAvailableException e) {
            System.out.println("There is no passenger in the seat you entered.");
        }
    }
    
    public void setSeat(Person p) {
        if (this.full) {
            System.out.println("The Airplane is full.");
            return;
        }
    
        try {
            this.seats[(int)(Math.random()*this.seats.length)].setPassenger(p);
            this.full = this.isFull();
        }
        
        catch (IsNotAvailableException e) {
            setSeat(p);
        }
    }
    
    public void setSeat(Person p, String id) {
        int lastChar = id.length()-1;
    
        try {
            if (!Character.isAlphabetic(id.charAt(lastChar)) || id.charAt(lastChar) < 'A' || id.charAt(lastChar) > 'F')
                throw new IndexOutOfBoundsException();
            this.seats[getPosition(id)].setPassenger(p);
        }
        
        catch (IndexOutOfBoundsException e) {
            System.out.println("You entered a wrong ID");
        }
        
        catch (NumberFormatException e) {
            System.out.println("You entered a wrong ID");
        }
        
        catch (IsNotAvailableException e) {
            System.out.println("The seat is already taken");
        }
    }
    
    private int getPosition(String id) {
        int val = (Integer.parseInt(id.substring(0, id.length()-1)) - 1)*6;
        int alph = id.charAt(id.length()-1) - 'A';
        return val + alph;
    }
    
    public boolean isFull() {
        for (Seat s : this.seats)
            if (s.isAvailable())
                return false;
        
        return true;
    }
    
    public static void main(String... args) {
        Airplane a = new Airplane(2);
        Scanner scanInt = new Scanner(System.in);
        Scanner scanString = new Scanner(System.in);
        Scanner scanLine = new Scanner(System.in);
        
        do {
            System.out.println("Menu\n0)Exit\n1)See the passengers\n2)See the free seats\n3)Remove prenotation\n4)Assign seat");
            
            switch(c = scanInt.nextInt()) {
                case 1:
                    a.displayPassengers();
                    break;
                case 2:
                    System.out.println(a.getFreeSeats());
                    break;
                case 3:
                    System.out.print("Enter the ID of the seat you want to be free: ");
                    a.removeSeat(scanLine.nextLine());
                    break;
                case 4:
                    try {
                        System.out.print("Enter the name: ");
                        String firstName = scanLine.nextLine();
                        if (firstName.equals(""))
                            throw new Exception();
                        System.out.print("Enter the last name: ");
                        String lastName = scanLine.nextLine();
                        if (lastName.equals(""))
                            throw new Exception();
                        System.out.print("Do you want a random seat? [Y/n] ");
                        if (scanLine.nextLine().toUpperCase().equals("Y"))
                            a.setSeat(new Person(firstName, lastName));
                        else {
                            System.out.print("Enter the ID of the seat: ");
                            String id = scanString.next();
                            a.setSeat(new Person(firstName, lastName), id);
                        }
                    }
                    
                    catch (Exception e) {
                        System.out.println("You entered a wrong passenger.");
                    }
            }
        } while (c != 0);
    }
}
