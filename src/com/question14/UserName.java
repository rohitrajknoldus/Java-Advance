package com.question14;

import javax.lang.model.element.Name;
import java.util.Scanner;
import java.util.Vector;

class UserName {
        // main method
        public static void main(final String[] args) {
            Scanner sc = new Scanner(System.in);
            Vector<Name> vector = new Vector<>();
            int option;
            do {
                System.out.println("########### Enter your choice ############"
                        + "\n Press 1: to Enter First name and last Name"
                        + "\n Press 2: to print the number of Total names"
                        + "\n Press 3: for exit application");
                option = sc.nextInt();
                if (option == 1) {
                    System.out.println("Enter Your First Name");
                    sc.next();
                    System.out.println("Enter Your Middle or Last Name");
                    sc.next();

                    vector.add(null);
                } else if (option == 2) {
                    System.out.println("Total Names: " + vector.size());
                }
            } while (option != 3);
            System.out.println("Application Closed, BYE BYE");
        }
}
