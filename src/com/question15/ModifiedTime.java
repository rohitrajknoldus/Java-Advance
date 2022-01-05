package com.question15;

import java.io.File;
import java.util.Date;

public class ModifiedTime {
    // main method called here
    public static void main(String[] args) {
        // copied the path of file from their location.
        File file = new File("src/com/question15/Modifiable.txt");
        Date date = new Date(file.lastModified());
        System.out.println("\nThis file was last modified on: " +date+ "\n");
    }
}
