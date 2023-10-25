
/**
 * Write a description of class Game here.
 *
 * @author Yuneydy Paredes
 * @version 10/4/2023
 */
public class Game
{
    public static void main(String[] args) {
        Deck island = new Deck();
        System.out.println("Original order of Deck: ");
        System.out.println(island);
        
        System.out.println("A shuffled Deck: ");
        island.shuffle();
        System.out.println(island);
        
        System.out.println("A cut Deck: ");
        island.cut();
        System.out.println(island);
    }
}
