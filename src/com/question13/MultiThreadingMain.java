package com.question13;

public class MultiThreadingMain {
    // main method called
    public static void main(String[] args) {
        RandomNumber rn=new RandomNumber();
        rn.start();
    }
}
