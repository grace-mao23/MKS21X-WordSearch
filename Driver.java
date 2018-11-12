import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class Driver{
  public static void main(String[]args){
    try{
      WordSearch grid0 = new WordSearch(0,0, "words.txt");
      WordSearch grid1 = new WordSearch(10, 10, "words.txt");
      WordSearch grid2 = new WordSearch(28, 28, "words.txt", 1128);
      WordSearch grid3 = new WordSearch(20, 20, "words.txt", 128);
      WordSearch grid4 = new WordSearch(110, 80, "words.txt");

      System.out.println("TESTING CONSTRUCTORS");

      System.out.println();
      System.out.println("grid0");
      System.out.println(grid0);
      /* should print:
      grid0
      Words:
      */
      System.out.println();
      System.out.println("grid1");
      System.out.println(grid1);
      // should print "grid1" followed by a 10 x 10 grid (the words and grid changes every time the program runs)

      System.out.println();
      System.out.println("grid2");
      System.out.println(grid2);
      // should print "grid2" followed by a 28 x 28 grid (the grid does not change)

      System.out.println();
      System.out.println("grid3");
      System.out.println(grid3);
      // should print "grid3" followed by a 20 x 20 grid (the grid does not change)

      System.out.println();
      System.out.println("grid4");
      System.out.println(grid4);
      // should print "grid4" followed by a 80 x 110 grid (the words and grid change every time the program runs)

      /*System.out.println();
      System.out.println("TESTING addWord");
      System.out.println();
      if (grid0.addWord("HELLO", 0, 3, 0 ,1)) System.out.println("Successfully added HELLO to grid0");
      else System.out.println("Failed to add HELLO to grid0");
      // should print "Failed to add HELLO to grid0"
      if (grid0.addWord("HELLO", 3, 0, 0 ,1)) System.out.println("Successfully added HELLO to grid0");
      else System.out.println("Failed to add HELLO to grid0");
      // should print "Failed to add HELLO to grid0"
      if (grid1.addWord("HELLO", 0, 0, 0 ,1)) System.out.println("Successfully added HELLO to grid1");
      else System.out.println("Failed to add HELLO to grid1");
      // should print "Successfully added HELLO to grid1"
      if (grid1.addWord("LOOP", 0, 3, 0 ,1)) System.out.println("Successfully added LOOP to grid1");
      else System.out.println("Failed to add LOOP to grid1");
      // should print "Successfully added LOOP to grid1"
      if (grid1.addWord("LAUGH", 0, 2, 0 ,1)) System.out.println("Successfully added LAUGH to grid1");
      else System.out.println("Failed to add LAUGH to grid1");
      // should print "Failed to add LAUGH to grid1"
      if (grid2.addWord("DURIAN", 2, 8, 0 ,1)) System.out.println("Successfully added DURIAN to grid2");
      else System.out.println("Failed to add DURIAN to grid2");
      // should print "Successfully added DURIAN to grid2"
      System.out.println();
      System.out.println("grid1");
      System.out.println(grid1);
      /* should print :
      grid1
      |H E L L O O P _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ |
      Words: HELLO, LOOP
      */
      /*System.out.println();
      System.out.println("grid2");
      System.out.println(grid2);
      /* should print:
      grid2
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ D U R I A N _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      Words: DURIAN
      */

      /*System.out.println();
/*      if (grid0.addWord("HOLA", 0, 3, 1, 0)) System.out.println("Successfully added HOLA to grid0");
      else System.out.println("Failed to add HOLA to grid0");
      // should print "Failed to add HOLA to grid0"
      if (grid0.addWord("HAPPY", 3, 0, 1, 0)) System.out.println("Successfully added HAPPY to grid0");
      else System.out.println("Failed to add HAPPY to grid0");
      // should print "Failed to add HAPPY to grid0"
      if (grid1.addWord("HAPPY", 0, 0, 1, 0)) System.out.println("Successfully added HAPPY to grid1");
      else System.out.println("Failed to add HAPPY to grid1");
      // should print "Successfully added HAPPY to grid1"
      if (grid1.addWord("PYTHON", 3, 0, 1, 0)) System.out.println("Successfully added PYTHON to grid1");
      else System.out.println("Failed to add PYTHON to grid1");
      // should print "Successfully added PYTHON to grid1"
      if (grid1.addWord("LIVE", 10, 5, 1, 0)) System.out.println("Successfully added LIVE to grid1");
      else System.out.println("Failed to add LIVE to grid1");
      // should print "Failed to add LIVE to grid1"
      if (grid2.addWord("APPLE", 2, 12, 1, 0)) System.out.println("Successfully added APPLE to grid2");
      else System.out.println("Failed to add APPLE to grid2");
      // should print "Successfully added APPLE to grid2"
      if (grid2.addWord("CAULIFLOWER", 2, 8, 1, 0)) System.out.println("Successfully added CAULIFLOWER to grid2");
      else System.out.println("Failed to add CAULIFLOWER to grid2");
      // should print "Failed to add CAULIFLOWER to grid2"
      System.out.println();
      System.out.println("grid1");
      System.out.println(grid1);
      /* should print :
      grid1
      |H E L L O O P _ _ _ |
      |A _ _ _ _ _ _ _ _ _ |
      |P _ _ _ _ _ _ _ _ _ |
      |P _ _ _ _ _ _ _ _ _ |
      |Y _ _ _ _ _ _ _ _ _ |
      |T _ _ _ _ _ _ _ _ _ |
      |H _ _ _ _ _ _ _ _ _ |
      |O _ _ _ _ _ _ _ _ _ |
      |N _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ |
      Words: HELLO, LOOP, HAPPY, PYTHON
      */
/*      System.out.println();
      System.out.println("grid2");
      System.out.println(grid2);
      /* should print:
      grid2
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ D U R I A N _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ P _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ P _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ L _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ E _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      Words: DURIAN, APPLE
      */

      System.out.println();

/*      if (grid0.addWord("WHAATTTT", -2, 4, 1, 1)) System.out.println("Successfully added WHAATTTT to grid0");
      else System.out.println("Failed to add WHAATTTT to grid0");
      // should print "Failed to add WHAATTTT to grid0"
      if (grid0.addWord("NOOOOOO", 0, 0, 1, 1)) System.out.println("Successfully added NOOOOOO to grid0");
      else System.out.println("Failed to add NOOOOOO to grid0");
      // should print "Failed to add NOOOOOO to grid0"
      if (grid1.addWord("LIVE", 2, 2, 1, 1)) System.out.println("Successfully added LIVE to grid1");
      else System.out.println("Failed to add LIVE to grid1");
      // should print "Successfully added LIVE to grid1"
      if (grid1.addWord("PACE", 0, 6, 1, 1)) System.out.println("Successfully added PACE to grid1");
      else System.out.println("Failed to add PACE to grid1");
      // should print "Successfully added PACE to grid1"
      if (grid1.addWord("HA", 8, 0, 1, 1)) System.out.println("Successfully added HA to grid1");
      else System.out.println("Failed to add HA to grid1");
      // should print "Failed to add HA to grid1"
      if (grid2.addWord("ORANGE", 12, 12, 1, 1)) System.out.println("Successfully added ORANGE to grid2");
      else System.out.println("Failed to add ORANGE to grid2");
      // should print "Successfully added ORANGE to grid2"
      if (grid2.addWord("KALE", 30, 7, 1, 1)) System.out.println("Successfully added KALE to grid2");
      else System.out.println("Failed to add KALE to grid2");
      // should print "Failed to add KALE to grid2"
      System.out.println();
      System.out.println("grid1");
      System.out.println(grid1);
      /* should print :
      grid1
      |H E L L O O P _ _ _ |
      |A _ _ _ _ _ _ A _ _ |
      |P _ L _ _ _ _ _ C _ |
      |P _ _ I _ _ _ _ _ E |
      |Y _ _ _ V _ _ _ _ _ |
      |T _ _ _ _ E _ _ _ _ |
      |H _ _ _ _ _ _ _ _ _ |
      |O _ _ _ _ _ _ _ _ _ |
      |N _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ |
      Words: HELLO, LOOP, HAPPY, PYTHON, LIVE, PACE
      */
/*      System.out.println();
      System.out.println("grid2");
      System.out.println(grid2);
      /* should print:
      grid2
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ D U R I A N _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ P _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ P _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ L _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ E _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ O _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ R _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ A _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ N _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ G _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ E _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      Words: DURIAN, APPLE, ORANGE
      */

/*      System.out.println();
      if (grid0.addWord("YAY", 2, 4, 0, 0)) System.out.println("Successfully added YAY to grid0");
      else System.out.println("Failed to add YAY to grid0");
      // should print "Failed to add YAY to grid0"
      if (grid0.addWord("NOOOOOO", 0, 0, -1, 1)) System.out.println("Successfully added NOOOOOO to grid0");
      else System.out.println("Failed to add NOOOOOO to grid0");
      // should print "Failed to add NOOOOOO to grid0"
      if (grid1.addWord("LOVE", 8, 7, 0, -1)) System.out.println("Successfully added LOVE to grid1");
      else System.out.println("Failed to add LOVE to grid1");
      // should print "Successfully added LOVE to grid1"
      if (grid1.addWord("PIECE", 9, 9, -1, -1)) System.out.println("Successfully added PIECE to grid1");
      else System.out.println("Failed to add PIECE to grid1");
      // should print "Successfully added PIECE to grid1"
      if (grid1.addWord("HAHHHHH", 8, 0, 0, 0)) System.out.println("Successfully added HAHHHHH to grid1");
      else System.out.println("Failed to add HAHHHHH to grid1");
      // should print "Failed to add HAHHHHH to grid1"
      if (grid2.addWord("JACKFRUIT", 18, 18, -1, 1)) System.out.println("Successfully added JACKFRUIT to grid2");
      else System.out.println("Failed to add JACKFRUIT to grid2");
      // should print "Successfully added JACKFRUIT to grid2"
      if (grid2.addWord("DRAGONFRUIT", 18, 2, -1, 0)) System.out.println("Successfully added DRAGONFRUIT to grid2");
      else System.out.println("Failed to add DRAGONFRUIT to grid2");
      // should print "Successfully added DRAGONFRUIT to grid2"
      System.out.println();
      System.out.println("grid1");
      System.out.println(grid1);
      /* should print :
      grid1
      |H E L L O O P _ _ _ |
      |A _ _ _ _ _ _ A _ _ |
      |P _ L _ _ _ _ _ C _ |
      |P _ _ I _ _ _ _ _ E |
      |Y _ _ _ V _ _ _ _ _ |
      |T _ _ _ _ E _ _ _ _ |
      |H _ _ _ _ _ C _ _ _ |
      |O _ _ _ _ _ _ E _ _ |
      |N _ _ _ E V O L I _ |
      |_ _ _ _ _ _ _ _ _ P |
      Words: HELLO, LOOP, HAPPY, PYTHON, LIVE, PACE, LOVE, PIECE
      */
/*      System.out.println();
      System.out.println("grid2");
      System.out.println(grid2);
      /* should print:
      grid2
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ D U R I A N _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ P _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ P _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ L _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ E _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ T _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ I _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ U _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ T _ |
      |_ _ R _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ I _ _ |
      |_ _ F _ _ _ _ _ _ _ _ _ O _ _ _ _ _ _ _ _ _ _ _ U _ _ _ |
      |_ _ N _ _ _ _ _ _ _ _ _ _ R _ _ _ _ _ _ _ _ _ R _ _ _ _ |
      |_ _ O _ _ _ _ _ _ _ _ _ _ _ A _ _ _ _ _ _ _ F _ _ _ _ _ |
      |_ _ G _ _ _ _ _ _ _ _ _ _ _ _ N _ _ _ _ _ K _ _ _ _ _ _ |
      |_ _ A _ _ _ _ _ _ _ _ _ _ _ _ _ G _ _ _ C _ _ _ _ _ _ _ |
      |_ _ R _ _ _ _ _ _ _ _ _ _ _ _ _ _ E _ A _ _ _ _ _ _ _ _ |
      |_ _ D _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ J _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      |_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ |
      Words: DURIAN, APPLE, ORANGE, JACKFRUIT, DRAGONFRUIT
      */

      WordSearch nogrid = new WordSearch(20, 20, "imaginary.txt");
    }catch(FileNotFoundException e){
      e.printStackTrace();
      // should print stack trace saying that imaginary.txt could not be found
    }
  }
}
