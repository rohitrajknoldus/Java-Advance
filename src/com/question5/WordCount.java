package com.question5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// public class created as name WordCount
public class WordCount {
    // main method called
    public static void main(String[] args)
    {
        BufferedReader reader = null;

        int Char_Count   = 0, Word_Count  = 0, Line_Count = 0;

        try
        {
            reader = new BufferedReader(new FileReader("src/question5/Rohit.txt"));
            String present_Line = reader.readLine();

            while (present_Line != null)
            {
                //Updating the lineCount
                Line_Count ++;
                //Getting number of words in currentLine
                String[] words = present_Line.split(" ");

                Word_Count = Word_Count + words.length;

                //Iterating words
                for (String word : words)
                {
                    //Updating the charCount

                    Char_Count = Char_Count + word.length();
                }

                //Reading next line into currentLine

                present_Line = reader.readLine();
            }
            System.out.println("No. of Lines     : "+ Line_Count);
            System.out.println("No. of Words     : "+ Word_Count);
            System.out.println("No. of Character : "+ Char_Count);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                assert reader != null;
                reader.close();// Closing reader
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
