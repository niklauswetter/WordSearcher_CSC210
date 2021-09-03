import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class WordSearch {

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
        //Create found words list
        List<String> foundWords = new ArrayList<String>();
        //Begin searching for words
        int counter =0;
        searchLeftToRight(puzzleChars,dictionary,foundWords,rows,cols);
        System.out.println("Left to right!");
        for(int i=counter;i<foundWords.size();i++)
        {
            System.out.println(foundWords.get(i));
            counter++;
        }
        searchRightToLeft(puzzleChars,dictionary,foundWords,rows,cols);
        System.out.println("Right to left!");
        for(int i = counter;i<foundWords.size();i++)
        {
            System.out.println(foundWords.get(i));
            counter++;
        }
        searchTopToBottom(puzzleChars,dictionary,foundWords,rows,cols);
        System.out.println("Top to bottom!");
        for(int i = counter;i<foundWords.size();i++)
        {
            System.out.println(foundWords.get(i));
            counter++;
        }
        searchBottomToTop(puzzleChars,dictionary,foundWords,rows,cols);
        System.out.println("Bottom to top!");
        for(int i = counter;i<foundWords.size();i++)
        {
            System.out.println(foundWords.get(i));
            counter++;
        }
    }
    //Declare search methods here
    public static void searchLeftToRight(char[][] chars,List<String> dictionary,List<String> foundWords, int rows,int cols)
    {
        String hold = "";
        for(int i = 0;i < rows; i++)
        {
            for(int j = 0; j< cols; j++)
            {
                for(int k=0+j;k<cols;k++)
                {
                    hold += chars[i][k];
                    if(hold.length()<3)
                        continue;
                    if(dictionary.contains(hold))
                        foundWords.add(foundWords.size(),hold);
                }
                hold="";
            }
            hold="";
        }
    }

    public static void searchRightToLeft(char[][] chars,List<String> dictionary,List<String> foundWords, int rows,int cols)
    {
        String hold="";
        for(int i = 0;i<rows;i++)
        {
            for(int j = cols;j>-1;j--)
            {
                for(int k=j-1;k>-1;k--)
                {
                    hold += chars[i][k];
                    if(hold.length()<3)
                        continue;
                    if(dictionary.contains(hold))
                        foundWords.add(foundWords.size(),hold);
                }
                hold="";
            }
            hold="";
        }
    }

    public static void searchTopToBottom(char[][] chars,List<String> dictionary,List<String> foundWords, int rows,int cols)
    {
        String hold = "";
        for(int i=0;i<cols;i++)
        {
            for(int j = 0; j< rows;j++)
            {
                for(int k = 0+j;k<rows;k++)
                {
                    hold += chars[k][i];
                    if(hold.length()<3)
                        continue;
                    if(dictionary.contains(hold))
                        foundWords.add(foundWords.size(),hold);
                }
                hold="";
            }
            hold="";
        }
    }

    public static void searchBottomToTop(char[][] chars,List<String> dictionary,List<String> foundWords, int rows,int cols)
    {
        String hold = "";
        for(int i = 0;i<cols;i++)
        {
            for(int j = rows; j>-1;j--)
            {
                for(int k = j-1;k>-1;k--)
                {
                    hold += chars[k][i];
                    if(hold.length()<3)
                        continue;
                    if(dictionary.contains(hold))
                        foundWords.add(foundWords.size(),hold);
                }
                hold="";
            }
            hold="";
        }
    }
}
