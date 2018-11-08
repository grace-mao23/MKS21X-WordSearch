public class Driver{
  public static void main(String[] args) {
    WordSearch ary = new WordSearch(8,8);

    System.out.println("Testing the constructor and toString:");
    System.out.println(ary);

    System.out.println();

    System.out.println("Testing addWordHorizontal (should print true)");
    System.out.println(ary.addWordHorizontal("woah",3,2));
    System.out.println(ary);

    System.out.println();

    System.out.println("Testing addWordHorizontal (should print false)");
    System.out.println(ary.addWordHorizontal("beeeees",2,2));
    System.out.println(ary);

    System.out.println();

    System.out.println("Testing addWordHorizontal with overlaps");
    System.out.println(ary.addWordHorizontal("eww",3,0));
    System.out.println(ary);
    System.out.println(ary.addWordHorizontal("b", 3,0));
    System.out.println(ary);

    System.out.println();

    System.out.println("Testing addWordVertical (should print true)");
    System.out.println(ary.addWordVertical("bruh",0,7));
    System.out.println(ary);

    System.out.println();

    System.out.println("Testing addWordVertical (should print false)");
    System.out.println(ary.addWordVertical("bruh",1,7));
    System.out.println(ary);

    System.out.println();

    System.out.println("Testing addWordVertical with overlaps");
    System.out.println(ary.addWordVertical("hello",3,7));
    System.out.println(ary);
    System.out.println(ary.addWordVertical("nahh", 2,7));
    System.out.println(ary);
  }

}
