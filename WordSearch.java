import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class WordSearch{
    private char[][]data;
    private int seed;
    private Random randgen;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;

    /**Initialize the grid to the size specified

     *and fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */
    public WordSearch(int rows,int cols){
      data = new char[rows][cols];
      clear();
    }

    public WordSearch(int rows, int cols, String fileName) {

    }

    public WordSearch(int rows, int cols, String fileName, int randSeed) {

    }

    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
      for (int i = 0; i < data.length; i++) {
        for (int x = 0; x < data[i].length; x++) {
          data[i][x] = '_';
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
      return result;
    }


    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned

     * and the board is NOT modified.

     */
    public boolean addWordHorizontal(String word,int row, int col){
      boolean check = true;
      if (row > data.length || col > data[row].length || word.length() > data[row].length - col) {
        return false;
      }
      for (int i = 0; i < word.length(); i++) {
        if (data[row][col + i] != '_' && data[row][col + i] != word.charAt(i)) {
          check = false;
        } else if(data[row][col + i] != word.charAt(i) && data[row][col + i] != '_') {
          check = false;
        }
      }
      if (check) {
        for (int x = 0; x < word.length(); x++) {
          data[row][col + x] = word.charAt(x);
        }
      }
      return check;
    }


   /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     *and the board is NOT modified.

     */
    public boolean addWordVertical(String word,int row, int col){
      boolean check = true;
      if (row > data.length || col > data[row].length || word.length() > data.length - row) {
        return false;
      }
      for (int i = 0; i < word.length(); i++) {
        if (data[row + i][col] != '_' && data[row + i][col] != word.charAt(i)) {
          check = false;
        } else if(data[row + i][col] != word.charAt(i) && data[row + i][col] != '_') {
          check = false;
        }
      }
      if (check) {
        for (int x = 0; x < word.length(); x++) {
          data[row + x][col] = word.charAt(x);
        }
      }
      return check;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top left to bottom right, must fit on the WordGrid,
     *and must have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordDiagonal(String word,int row, int col){
      boolean check = true;
      if (row > data.length || col > data[row].length ||
          word.length() > data.length - row || word.length() > data[row].length - col) {
        return false;
      }
      int column = 0;
      for (int i = 0; i < word.length(); i++) {
        if (data[row + i][col + column] != '_' && data[row + i][col + column] != word.charAt(i)) {
          check = false;
        } else if(data[row + i][col + column] != word.charAt(i) && data[row + i][col + column] != '_') {
          check = false;
        }
        column++;
      }
      column = 0;
      if (check) {
        for (int x = 0; x < word.length(); x++) {
          data[row + x][col + column] = word.charAt(x);
          column++;
        }
      }
      return check;
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
 public boolean addWord(String word,int row, int col, int rowIncrement, int colIncrement){
   boolean check = true;
   if (rowIncrement == 0 && colIncrement == 0) {
     return false;
   }
   int column = col;
   int wordI = 0;
   int rowI = row;
   while (wordI < word.length()) {
     if (rowI < 0 || rowI >= data.length || column < 0 || column >= data[rowI].length) {
       check = false;
     } else if (data[rowI][column] != '_' && data[rowI][column] != word.charAt(wordI)) {
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
   }
   return check;
 }

 /*[rowIncrement,colIncrement] examples:
  *[-1,1] would add up and the right because (row -1 each time, col + 1 each time)
  *[ 1,0] would add downwards because (row+1), with no col change
  *[ 0,-1] would add towards the left because (col - 1), with no row change
  */

}
