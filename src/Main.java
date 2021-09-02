import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException
    {
        //Initialize variables
	    String dictPath, puzzlePath;
        int rows, cols;
        //Store CL args
        dictPath = args[0];
        puzzlePath = args[1];
        //DEBUG DELETE
        System.out.println(dictPath+" "+puzzlePath);
        //File Objects
        File dict = new File(dictPath);
        File puzzle = new File(puzzlePath);
        //Scanner Objects
        Scanner dictScanner = new Scanner(dict);
        Scanner puzzleScanner = new Scanner(puzzle);
        //Get grid dimensions
        rows = puzzleScanner.nextInt();
        cols = puzzleScanner.nextInt();
        //DEBUG DELETE
        System.out.println(rows+" "+cols);
        //Create char array
    }
}
