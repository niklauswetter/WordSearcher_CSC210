import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class  Main {

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
        //Create dictionary list
        List<String> dictionary = new ArrayList<String>();
        while(dictScanner.hasNext())
            dictionary.add(dictScanner.nextLine().trim().toLowerCase());
        dictScanner.close();
        //Create char array
        char[][] puzzleChars = new char[rows][cols];
        //Store puzzle characters in array
        puzzleScanner.nextLine();
        for(int i = 0; i<rows;i++)
        {
            String rowLine = puzzleScanner.nextLine().toLowerCase().replaceAll("\\s","");
            char[] temp = rowLine.toCharArray();
            for(int j=0;j<cols;j++)
                puzzleChars[i][j]=temp[j];
        }
        puzzleScanner.close();
        //DEBUG DELETE
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
                System.out.print(puzzleChars[i][j]);
            System.out.println();
        }
        //Begin searching for words
    }
    //Declare search methods here
}
