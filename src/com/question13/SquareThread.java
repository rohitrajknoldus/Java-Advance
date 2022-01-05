package com.question13;

class SquareThread extends Thread {
    int num;
    SquareThread(int number){
        this.num = number ;
    }
    public void run(){
        System.out.println("Square of "+num+" : "+num * num);
    }
}