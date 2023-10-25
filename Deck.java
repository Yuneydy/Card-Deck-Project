import java.util.Random;

/**
 * Write a description of class Deck here.
 *
 * @author Yuneydy Paredes
 * @version 10/2/2023
 */
public class Deck
{
    // instance variable
    private int counter;
    private int constant;
    private Card[] cards;
    
    String[] suits = {"Hearts","Diamonds","Spades", "Clubs"};
    int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    
    /**
     * Constructor for objects of class Deck
     * 
     * Constructs an array of cards (Each unique, with no repeats)
     */
    public Deck()
    {
        
        counter = 0;
        constant = 52;
        cards = new Card[constant];
        
        //Create a card and update it as we change the suit
        //and value
        
        Card currentCard = new Card(suits[0],values[0]);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
            currentCard = new Card(suits[i], values[j]);
            cards[counter] = currentCard;
            counter++;
            }
        }
    }
    
    /**
     * This prints the Cards in the Deck in 
     * a neat representation
     */
    public String toString() {
        String s = "In our deck, we currently have: \n";
        for (int i = 0; i < cards.length; i++) {
            s = s + cards[i].toString() + "\n";
        }
        return s;
    }
    
    
    /**
     *  It picks at random a number between 1 and the number of cards in the Deck and it 
     *  splits the deck in two piles. It then changes the order of these two piles 
     *  in the Deck: the top pile goes to the bottom of the Deck. The Cards of the Deck 
     *  remain the same but their order in the collection change to reflect the cut. 
     */
    public void cut() {
        Random r = new Random();
        int slice = r.nextInt(constant);
        
        Card[] topHalf = new Card[slice];
        Card[] bottomHalf = new Card[constant - slice];
        
        //Create topHalf 
        for (int i = 0; i < slice; i++) {
            topHalf[i] = cards[i];
        }
        
        //Create bottomHalf
        for (int i = slice; i < constant; i++) {
            bottomHalf[i-slice] = cards[i];
        }
        
        Card[] combined = new Card[constant];
        
        // Create combined version of bottomHalf and topHalf
        for (int i = 0; i < constant; i++) {
            if (i < (constant-slice)) {
               combined[i] = bottomHalf[i]; 
            } else {
               combined[i] = topHalf[i-(constant-slice)]; 
            }
        }
        
        cards = combined;
    }
    
    
    
    /**
     * It picks at random a card from the Deck and adds it to a new pile repeatedly until 
     * there are no cards left in the Deck. Then, the new pile becomes the collection of 
     * cards in the Deck.
     */
    public void shuffle() {
        Random r = new Random();
        int upperBound = counter; // random values are chosen from 0 to upperBound
        
        Card[] copy = new Card[counter]; // to be filled with randomly selected cards from our original deck
        
        int putTo = 0; // next available spot in copy array
        
        while (putTo < copy.length) { // copy is not filled up
            int pickFrom = r.nextInt(upperBound); // random value used to pick a card
            copy[putTo] = cards[pickFrom]; // takes open spot
            putTo++;
            
            cards[pickFrom] = cards[upperBound-1]; //fills the hole in cards with upperbound value to gain access to new card
            upperBound--;
        }
        counter = copy.length;
        cards = copy;
    }
    
    
}
