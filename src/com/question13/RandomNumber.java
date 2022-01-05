package com.question13;

import java.util.Random;
import java.util.Scanner;

class RandomNumber extends Thread {   // extended class to Thread

    public void run() {
        Scanner scanner=new Scanner(System.in);   // taking input from user
        System.out.println("Please enter the number up to  you want to generate square and cube of Random number");
        int numOfRandom= scanner.nextInt();
        Random random = new Random();
        for(int i = 0; i < numOfRandom; i++){
            int randomNumber = random.nextInt(100);
            System.out.print("Wait a while, it's Generating");
            for (int j = 0; j < 5; j++){
                //   we are printing . every half second for waiting
                System.out.print(".");
                try {                       // try & catch block used
                    Thread.sleep(500);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            System.out.println();
            if(randomNumber % 2 == 0){
                SquareThread squareThread=new SquareThread(randomNumber);
                squareThread.start();
            }else{
                CubeThread cubeThread=new CubeThread(randomNumber);
                cubeThread.start();
            }
            try {
                Thread.sleep(1500);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}