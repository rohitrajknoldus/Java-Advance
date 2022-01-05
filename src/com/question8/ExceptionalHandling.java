package com.question8;

public class ExceptionalHandling {
    // main method called
    public static void main(String[] args) {
        //try block
        try {
            int data = 100 / 4;
            System.out.println("Result = " + data);
        }
        // multi- catch block
        catch (NullPointerException e) {
            System.out.println("exception message " +e.getMessage());
        }
        catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception :: Divide by zero!!");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds :: Accessed index out of bounds");
        }
        catch (Exception e) {
            System.out.println("Exception :: " + e.getMessage());

        }
        //finally block
        finally {
            System.out.println("No Exception::finally block succesfully executed");
        }
        System.out.println("BYE BYE");
    }
}
