
import java.util.Random;
/**
 *
 * @author Ayanna Shaheed
 */
public class testarray {
    
    private static final String[] deckOfCards ={ "2h","3h","4h","5h","6h","7h","8h","9h","10h","queenh","kingh","jackh", "Aceh",
                            "2d","3d","4d","5d","6d","7d","8d","9d","10d", "queend","kingd","jackd","Ad",
                            "2s","3s","4s","5s","6s","7s","8s","9s","10s","queens","kings","jacks","As",
                            "2c","ch","4c","5c","6c","7c","8c","9c","10c","queenc","kingc","jackc", "Ac"};
    
    private static arrayList cardDeck = new arrayList(deckOfCards.length);
    private static arrayList a2 = new arrayList();
   
   
        
    
    public static void main(String[] args) {
        
   
        //Fills array with card objects
        for(int i = 0; i < deckOfCards.length; i++)
            cardDeck.add(deckOfCards[i]);
        //Prints cards
        cardDeck.printArray();
        
        //Test add(Object ob)
            System.out.println("\n\na2 before add(Object ob): ");
            a2.printArray();
            //Fills a2 with objects
            for(int i = 0; i < a2.getLength(); i++)
                a2.add(i);
            System.out.println("\n\na2 after add(Object ob): ");
            a2.printArray();
        
        //Test add(Object ob, int x)
            System.out.println("\n\na2 after add(Object ob, int x): ");
            a2.add(4, "Test Object");
            a2.printArray();
            
        //Test get(int index)
            System.out.println("\n\nResult of get(4):" + a2.get(4));
            
        //Test size
            a2.expandCapacity();
            System.out.println("\nLength of a2 after expandCapacity: " + a2.getLength());
            System.out.println("Size of a2: " + a2.size());
            
        //Test is empty
            System.out.println("\nA2 is empty:" + a2.isEmpty());
            
        //Test is in
            System.out.println("\nTest Object is in a2: " + a2.isIn("Test Object"));
            
        //Test find
            System.out.println("\nUse find(Test Object) to find position of object: " + a2.find("Test Object"));
          
        //Test remove
            a2.remove("Test Object");
            System.out.println("\nResult of remove(Test Object):");
            a2.printArray();
            System.out.println("\n");
            
        //Shuffle routine
             Random rand = new Random();
             arrayList shuffledList = new arrayList(52);
             
             Object ob;
             for(int i = 0; i < 250; i++){
                ob = cardDeck.get(rand.nextInt(52));
                
                if (shuffledList.isIn(ob))
                    ob = cardDeck.get(rand.nextInt(52));
                else
                    shuffledList.add(ob);
             }
          
              shuffledList.printArray();
        
        
        }
        
    }
    

