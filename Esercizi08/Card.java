public class Card {
    private final int value;
    private final String suit;
    
    public Card (int value, String suit) {
        this.value = value;
        this.suit = suit;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public String getSuit() {
        return this.suit;
    }
    
    public int getBriscolaValue() {
        switch (this.value) {
            case 1:
                return 11;
            case 3:
                return 10;
            case 8:
                return 2;
            case 9:
                return 3;
            case 10:
                return 4;
            default:
                return 0;
        }
    }
    
    public boolean isEqualSuit(Card c) {
        return this.suit.equals(c.suit);
    }
    
    public boolean equals(Card c) {
        return this.value == c.value && this.suit == c.suit;
    }
    
    public String toString() {
        return this.value + " di " + this.suit;
    }
}
