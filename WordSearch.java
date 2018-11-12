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
      /*
      result += "Words: ";
      for (int y = 0; y < wordsAdded.size(); y++) {
        result += wordsAdded.get(y);
        if (y != wordsAdded.size() - 1) {
          result += ", ";
        }
      }*/
      return result;
    }

}
