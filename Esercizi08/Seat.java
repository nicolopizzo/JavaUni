public class Seat {
    private final String id;
    private boolean available;
    private Person passenger;
    
    public Seat(String id) {
        this.id = id;
        this.available = true;
        this.passenger = null;
    }
    
    public void setPassenger(Person p) throws IsNotAvailableException{
        if (this.available == false)
            throw new IsNotAvailableException();
        this.passenger = p;
        this.available = false;
    }
    
    public Person getPassenger() {
        return this.passenger;
    }
    
    public void deletePassenger() throws IsAvailableException{
        if (this.available == true)
            throw new IsAvailableException();
        this.passenger = null;
        this.available = true;
    }
    
    public boolean isAvailable() {
        return this.available;
    }
    
    public String getID() {
        return this.id;
    }
    
    public String toString() {
        return this.id +(this.passenger == null ? "" : ": " + this.passenger);
    }
}

class IsAvailableException extends Exception {
    public IsAvailableException() {
        super();
    }
}

class IsNotAvailableException extends Exception {
    public IsNotAvailableException() {
        super();
    }
}
