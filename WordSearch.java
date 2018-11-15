import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class WordSearch{
  private char[][]data;
  private int seed;
  private Random randgen;
  private ArrayList<String> wordsToAdd;
  private ArrayList<String> wordsAdded;

  public WordSearch(int rows, int cols, String fileName, int randSeed) throws FileNotFoundException {
    seed = randSeed;
    randgen = new Random(seed);
    data = new char[rows][cols];
  //  clear();
    File f = new File(fileName);
    Scanner in = new Scanner(f);
    wordsToAdd = new ArrayList<>();
    wordsAdded = new ArrayList<>();
    while (in.hasNext()) {
      wordsToAdd.add(in.nextLine().toUpperCase());
    }
//    addAllWords();
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
    result += " (seed: " + seed + ")";
    return result;
  }

  public static void main(String[] args) {
    int rows = Integer.parseInt(args[0]);
    int cols = Integer.parseInt(args[1]);
    int seed = Integer.parseInt(args[3]);
    WordSearch w = new WordSearch(rows, cols, args[2], seed);
    System.out.println(w);
  }



}
