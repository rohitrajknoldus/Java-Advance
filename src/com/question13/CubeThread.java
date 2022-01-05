package com.question13;

class CubeThread extends Thread{
    int number;
    CubeThread(int number){
        this.number = number;
    }
    public void run(){
        System.out.println("Cube of "+number+" : "+number*number*number);
    }
}