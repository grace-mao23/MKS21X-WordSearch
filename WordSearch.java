import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception
public class WordSearch{
    private char[][] data;

    //the random seed used to produce this WordSearch
    private int seed;

    //a random Object to unify your random calls
    private Random randgen;

    //all words from a text file get added to wordsToAdd, indicating that they have not yet been added
    private ArrayList<String> wordsToAdd;

    //all words that were successfully added get moved into wordsAdded.
    private ArrayList<String> wordsAdded;

    public WordSearch(int rows, int cols, String fileName) throws FileNotFoundException{
      randgen = new Random();
      seed = randgen.nextInt();
      randgen = new Random(seed);
      data = new char[rows][cols];
      clear();
      File f = new File(fileName);
      Scanner in = new Scanner(f);
      wordsToAdd = new ArrayList<>();
      wordsAdded = new ArrayList<>();
      while (in.hasNext()){
        wordsToAdd.add(in.nextLine().toUpperCase());
      }
      addAllWords();
    }

    public WordSearch( int rows, int cols, String fileName, int randSeed) throws FileNotFoundException{
      seed = randSeed;
      randgen = new Random(seed);
      data = new char[rows][cols];
      clear();
      File f = new File(fileName);
      Scanner in = new Scanner(f);
      wordsToAdd = new ArrayList<>();
      wordsAdded = new ArrayList<>();
      while (in.hasNext()){
        wordsToAdd.add(in.nextLine().toUpperCase());
      }
      addAllWords();
    }

    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
      for (int i = 0; i < data.length; i++){
        for (int j = 0; j < data[0].length; j++){
          data[i][j]='_';
        }
      }
    }

    /**Each row is a new line, there is a space between each letter
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
      String ans = "";
      for (int i = 0; i < data.length; i++){
        ans += "|";
        for (int j = 0; j < data[i].length; j++){
          ans += data[i][j] + " ";
        }
        ans += "|\n";
      }
      ans += "Words: ";
      for (int i = 0; i < wordsAdded.size();i++){
        ans += wordsAdded.get(i);
        if (i + 1 != wordsAdded.size()) ans += ", ";
      }
      ans += " (seed: " + seed + ")";
      return ans;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
      *The word is added in the direction rowIncrement,colIncrement
      *Words must have a corresponding letter to match any letters that it overlaps.
      *
      *@param word is any text to be added to the word grid.
      *@param row is the vertical locaiton of where you want the word to start.
      *@param col is the horizontal location of where you want the word to start.
      *@param rowIncrement is -1,0, or 1 and represents the displacement of each letter in the row direction
      *@param colIncrement is -1,0, or 1 and represents the displacement of each letter in the col direction
      *@return true when: the word is added successfully.
      *        false when: the word doesn't fit, OR  rowchange and colchange are both 0,
      *        OR there are overlapping letters that do not match
      */
     private boolean addWord(String word,int row, int col, int rowIncrement, int colIncrement){
       for (int i = 0; i < word.length(); i++){
         int a = row + i * rowIncrement;
         int b = col + i * colIncrement;
         if (row < 0 ||
             col < 0 ||
             a < 0 ||
             b < 0 ||
             (rowIncrement == 0 && colIncrement == 0) ||
             a >= data.length ||
             b >= data[a].length ||
             (data[a][b] != '_' && data[a][b] != word.charAt(i))) return false;
       }
       for (int i = 0; i < word.length(); i++){
         data[row + i * rowIncrement][col + i * colIncrement] = word.charAt(i);
       }
       wordsAdded.add(word);
       wordsToAdd.remove(word);
       return true;
     }

     private void addAllWords(){
       int l = wordsToAdd.size();
       for (int i = 0; wordsToAdd.size() > 0 && i < l + 100; i++ ){
         String w;
         if (wordsToAdd.size() == 1) w = wordsToAdd.get(0);
         else w = wordsToAdd.get(Math.abs(randgen.nextInt() % (wordsToAdd.size())));
         int r = 0;
         int c = 0;
         while (r == 0 && c == 0){
           r = randgen.nextInt() % 2;
           c = randgen.nextInt() % 2;
         }
         int row = data.length;
         int col = 0;
         if (row > 0) col = data[0].length;
         for (int j = 0; j < 100 && !addWord(w,
                                                Math.abs(randgen.nextInt() % (row + 1)),
                                                Math.abs(randgen.nextInt() % (col + 1)), r, c); j++);
       }
     }

}
