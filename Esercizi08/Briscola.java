import java.util.*;

public class Briscola {
    private ArrayList<Card> deck;
    private static int counter;
    private ArrayList<Card> cardsCPU;
    private ArrayList<Card> cardsPlayer;
    private boolean turnWon;
    private ArrayList<Card> playerDeck;
    private ArrayList<Card> CPUDeck;
    private Card mainCard;
    private final String briscolaSuit;
    
    public Briscola() {
        deck = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            if (i < 10)
                deck.add(new Card((i%10)+1, "Denari"));
            else if (i < 20)
                deck.add(new Card((i%10)+1, "Spade"));
            else if (i < 30)
                deck.add(new Card((i%10)+1, "Mazze"));
            else if (i < 40)
                deck.add(new Card((i%10)+1, "Coppe"));
        }
        
        Collections.shuffle(deck);
        mainCard = deck.remove(0);
        briscolaSuit = mainCard.getSuit();
        deck.add(mainCard);
        
        playerDeck = new ArrayList<>();
        CPUDeck = new ArrayList<>();
        
        cardsPlayer = new ArrayList<>();
        cardsCPU = new ArrayList<>();
    }
    
    public boolean isBriscola(Card c) {
        return c.getSuit().equals(briscolaSuit);
    }
    
    public void takeCards(Card p, Card c) {
        String mainSuit = turnWon ? p.getSuit() : c.getSuit();
        
        // if the precednt turn was won by the Player
        if (turnWon) {
            if (p.getBriscolaValue() >= c.getBriscolaValue()) {
                //if the cpu has briscola and the player does not, the cards go to the CPU
                if ((isBriscola(c) && !isBriscola(p)) || (c.getSuit().equals(mainSuit) && c.getValue() > p.getValue()))
                    winsCPU(p, c);
                
                else
                    winsPlayer(p, c);
            }
            
            else {
                /* if the player has briscola, or the CPU throws a card whose suit is not
                the one of the card thrown by the player, the player wins the turn */
                if ((isBriscola(p) || !c.getSuit().equals(mainSuit)) && !isBriscola(c))
                    winsPlayer(p, c);
                
                else
                    winsCPU(p, c);
            }
        }
        
        // if the precedent turn was won by the CPU        
        else {
            if (p.getBriscolaValue() > c.getBriscolaValue()) {
                /*  the player wins the turn only if he has a briscola or
                    he throws a card whose suit is equal to the one of the card 
                    thrown by the CPU */
                if (isBriscola(p) || p.getSuit().equals(mainSuit))
                    winsPlayer(p, c);
                
                else
                    winsCPU(p, c);
            }
            
            else {
                if ((isBriscola(p) && !isBriscola(c)) || (p.getSuit().equals(mainSuit) && p.getValue() > c.getValue()))
                    winsPlayer(p, c);
                    
                else
                    winsCPU(p, c);            
            }
        }
    }
    
    private void winsCPU(Card p, Card c) {
        System.out.println("Turno vinto da CPU\n");
        CPUDeck.add(p);
        CPUDeck.add(c);
        turnWon = false;
    }
    
    private void winsPlayer(Card p, Card c) {
        System.out.println("Hai vinto il turno\n");
        playerDeck.add(p);
        playerDeck.add(c);
        turnWon = true;
    }
    
    public Card playerTurn() {
        Scanner scanInt = new Scanner(System.in);
        
        try {
            for (int i = 0; i < cardsPlayer.size(); i++)
                System.out.println((i+1) + ": " + cardsPlayer.get(i));
                
            System.out.print("Scegli una carta: ");
            return cardsPlayer.remove(scanInt.nextInt()-1);
        }
        
        catch (IndexOutOfBoundsException e) {
            System.out.println("You entered a wrong number.");
            return playerTurn();
        }
        
        catch (InputMismatchException e) {
            System.out.println("You entered a wrong number.");
            return playerTurn();
        }
    }
    
    public Card CPUTurn() {
        int n = (int) Math.random()*cardsCPU.size();
        return cardsCPU.remove(n);
    }
    
    public void play() {
        Card p, c;
        // first three cards
        for (int i = 0; i < 3; i++) {
            drawCardTo(cardsPlayer);
            drawCardTo(cardsCPU);
        }
        
        while (!cardsPlayer.isEmpty() && !cardsCPU.isEmpty()) {
            System.out.println("Carte rimanenti: " + this.deck.size() + "\nBriscola: " + mainCard);
            
            if (turnWon) {
                p = playerTurn();
                c = CPUTurn();
                System.out.println("Carta della CPU: " + c);
            }
            
            else {
                c = CPUTurn();
                System.out.println("Carta della CPU: " + c);
                p = playerTurn();
            }
            takeCards(p, c);
            
            if (!this.deck.isEmpty()) {
                if (turnWon) {
                    drawCardTo(cardsPlayer);
                    drawCardTo(cardsCPU);
                }
                
                else {
                    drawCardTo(cardsPlayer);
                    drawCardTo(cardsCPU);
                }
            }
        }        
        displayPoints();
    }
    
    private void drawCardTo(ArrayList<Card> p) {
        p.add(this.deck.remove(0));
    }
    
    private void displayPoints() {
        int s = 0;
        
        for (Card c : playerDeck)
            s += c.getBriscolaValue();
            
        System.out.println("Giocatore: " + s + "\nCPU: " + (120-s));
    }
    
    public static void main(String[] args) {
        Briscola b = new Briscola();
        b.play();
    }
}
