import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class WordSearch{
  private char[][]data;
  private int seed;
  private Random randgen;
  private ArrayList<String> wordsToAdd;
  private ArrayList<String> wordsAdded;

  // OFFICIAL CONSTRUCTOR
  public WordSearch(int rows, int cols, String fileName, int randSeed, boolean ans) throws FileNotFoundException {
    seed = randSeed;
    randgen = new Random(seed);
    data = new char[rows][cols];
    clear();
    File f = new File(fileName);
    Scanner in = new Scanner(f);
    wordsToAdd = new ArrayList<>();
    wordsAdded = new ArrayList<>();
    while (in.hasNext()) {
      wordsToAdd.add(in.nextLine().toUpperCase());
    }
    addAllWords();
    if (!ans) {
      fillRandLetters();
    }
  }

  // Filling in random letters for the puzzle
  private void fillRandLetters() {
    int letter = 0;
    for (int i = 0; i < data.length; i++) {
      for (int x = 0; x < data[0].length; x++) {
        if (data[i][x] == ' ') {
          letter = Math.abs(randgen.nextInt() % 26);
          data[i][x] = (char)('A' + letter);
        }
      }
    }
  }

  /**Set all values in the WordSearch to underscores'_'*/
  private void clear(){
    for (int i = 0; i < data.length; i++) {
      for (int x = 0; x < data[i].length; x++) {
        data[i][x] = ' ';
      }
    }
  }

  /**Each row is a new line, there is a space between each letter
   *@return a String with each character separated by spaces, and rows
   *separated by newlines.
   */
  public String toString(){
    String result = "";
    for (int i = 0; i < data.length; i++) {
      result += "|";
      for (int x = 0; x < data[i].length; x++) {
        result += data[i][x];
        if (x != data[i].length - 1) {
          result += " ";
        }
      }
      result += "|\n";
    }

    result += "Words: ";
    for (int y = 0; y < wordsAdded.size(); y++) {
      result += wordsAdded.get(y);
      if (y != wordsAdded.size() - 1) {
        result += ", ";
      }
    }
    result += "(seed: " + seed + ")";
    return result;
  }

  private boolean addWord(String word,int row, int col, int rowIncrement, int colIncrement){
    boolean check = true;
    if (rowIncrement == 0 && colIncrement == 0) {
      return false;
    }
    if (word.length() == 0) {
      return false;
    }
    int column = col;
    int wordI = 0;
    int rowI = row;
    while (wordI < word.length()) {
      if (rowI < 0 || rowI >= data.length || column < 0 || column >= data[rowI].length) {
        check = false;
      } else if (data[rowI][column] != ' ' && data[rowI][column] != word.charAt(wordI)) {
        check = false;
      }
      column += colIncrement;
      wordI++;
      rowI += rowIncrement;
    }
    column = col;
    wordI = 0;
    rowI = row;
    if (check) {
      while (wordI < word.length()) {
        data[rowI][column] = word.charAt(wordI);
        rowI += rowIncrement;
        column += colIncrement;
        wordI++;
      }
      wordsToAdd.remove(word);
      wordsAdded.add(word);
    }
    return check;
  }

  private void addAllWords() {
    int size = wordsToAdd.size();
    for (int i = 0; i < size + 100 && wordsToAdd.size() > 0; i++) {
      String w = "";
      if (wordsToAdd.size() == 1) {
        w = wordsToAdd.get(0);
      } else {
        w = wordsToAdd.get(Math.abs(randgen.nextInt() % (wordsToAdd.size())));
      }
      int rows = 0;
      int columns = 0;
      while (rows == 0 && columns == 0) {
        rows = randgen.nextInt() % 2;
        columns = randgen.nextInt() % 2;
      }
      int row = data.length;
      int col = 0;
      if (row > 0) {
        col = data[0].length;
      }
      for (int j = 0; j < 100 && !addWord(w,
                                            Math.abs(randgen.nextInt() % (row + 1)),
                                            Math.abs(randgen.nextInt() % (col + 1)), rows, columns); j++);
    }
  }

  // MAIN FUNCTION BELOW
  public static void main(String[] args) {
    // argument format: rows columns fileName randomSeed answers(key)
    try {
      if (args.length < 3) {
        System.out.println("Please enter three arguments at least. First enter the" +
                            "number of rows, then the number of columns, then an existing file" +
                            "to make your puzzle. You can also enter a seed to view a specific puzzle" +
                            "and the word key to show an answer key. An example would be:" +
                            "java WordSearch 10 10 words.txt 128 key");
      }
      int rows = Integer.parseInt(args[0]);
      int cols = Integer.parseInt(args[1]);
      String fileN = args[2];
      Random s = new Random();
      int seed = s.nextInt();
      boolean answer = false;
      WordSearch w = new WordSearch(10,10,"blehh.txt",1,false);
    } catch (FileNotFoundException e) {
      System.out.println("Please enter three arguments at least. First enter the" +
                          "number of rows, then the number of columns, then an existing file" +
                          "to make your puzzle. You can also enter a seed to view a specific puzzle" +
                          "and the word key to show an answer key. An example would be:" +
                          "java WordSearch 10 10 words.txt 128 key");
    } catch (NumberFormatException f) {
      System.out.println("Please enter three arguments at least. First enter the" +
                          "number of rows, then the number of columns, then an existing file" +
                          "to make your puzzle. You can also enter a seed to view a specific puzzle" +
                          "and the word key to show an answer key. An example would be:" +
                          "java WordSearch 10 10 words.txt 128 key");
    }
  }
}
