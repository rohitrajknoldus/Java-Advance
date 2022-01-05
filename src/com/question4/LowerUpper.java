package com.question4;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Scanner;
import static java.nio.file.StandardOpenOption.*;

// public class created as name LowerAndUpper_App
public class LowerUpper {

    // main method called
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
        int stdID=0, cred_Hrs=0, record_Len=0;
        String name, SurName, IDString="", credString="", fullEntry, selection;
        boolean b=false, done=false;

        String delimiter=",";
        StringBuilder nameFormat;
        DecimalFormat ID=new DecimalFormat("0000000");
        DecimalFormat creds=new DecimalFormat("000");
        Path lower, upper;

        lower=Paths.get("Lower_classmen.txt");
        upper=Paths.get("Upper_classmen.txt");

        try{
            OutputStream lowStr=new BufferedOutputStream(Files.newOutputStream(lower, CREATE, WRITE));
            BufferedWriter writeLower=new BufferedWriter(new OutputStreamWriter(lowStr));

            OutputStream upStr=new BufferedOutputStream(Files.newOutputStream(upper, CREATE, WRITE));
            BufferedWriter writeUpper=new BufferedWriter(new OutputStreamWriter(upStr));

            do{
                //master file writing loop
                b=false;
                do{
                    System.out.print("Enter the student's 7-digit ID number > ");
                    try{
                        stdID=input.nextInt();
                        input.nextLine();

                        if(stdID<0 || stdID>9999999)
                            throw(new Exception());
                        else{
                            b=true;
                            IDString=ID.format(stdID)+"";
                        }
                    }
                    catch(Exception error){
                        System.out.println("That's not a valid ID.");
                        input.nextLine();
                    }
                }while(!b);    //takes student ID number

                System.out.print("Please enter the student's first name > ");
                name=input.nextLine();
                nameFormat=new StringBuilder(name);
                nameFormat.setLength(20);
                name=nameFormat.toString();

                System.out.print("Enter the student's last name > ");
                SurName=input.nextLine();//takes student name
                nameFormat=new StringBuilder(SurName);
                nameFormat.setLength(20);
                SurName=nameFormat.toString();

                b=false;
                do{
                    System.out.print("Enter the student's total earned credits > ");
                    try{
                        cred_Hrs=input.nextInt();
                        input.nextLine();

                        if(cred_Hrs<0 || cred_Hrs>999)
                            throw(new Exception());
                        else{
                            b=true;
                            credString=creds.format(cred_Hrs)+"";
                        }
                    }
                    catch(Exception error){
                        System.out.println("That's not a valid number of hours.");
                    }
                }while(!b);//takes credit hours

                fullEntry="ID "+IDString+delimiter +SurName +delimiter +name +delimiter+
                        credString+" credits"+System.getProperty("line.separator");

                if(record_Len==0)
                    record_Len=fullEntry.length();
                if(cred_Hrs<60){
                    System.out.println("This student's credit hours sorts them with the "+
                            "lowerclassmen.");
                    writeLower.write(fullEntry, 0, fullEntry.length());
                }
                else{
                    System.out.println("This student's credit hours sorts them with the "+
                            "upperclassmen.");
                    writeUpper.write(fullEntry, 0, fullEntry.length());
                }

                b=false;
                do{
                    System.out.print("Would you like to enter another student? (Y/N) > ");
                    selection=input.nextLine().charAt(0)+"";

                    if(selection.equalsIgnoreCase("Y"))
                        b=true;
                    else if(selection.equalsIgnoreCase("N")){
                        done=true;
                        b=true;
                    }
                }while(!b);//enter another record or quit
            }while(!done);//end master write loop

            writeLower.close();
            writeUpper.close();

            System.out.println("\nThe records have been stored.");
        }
        catch(Exception error){
            System.out.println("Error: "+error.getMessage());
        }

        //below this line is the expansion pack

        String[]array;
        String data;
        int credit;
        StringBuilder extract;
        final int GRAD_CREDITS=120;

        try{
            InputStream lowIn=new BufferedInputStream(Files.newInputStream(lower, READ));
            BufferedReader readLower=new BufferedReader(new InputStreamReader(lowIn));

            InputStream uppIn=new BufferedInputStream(Files.newInputStream(upper, READ));
            BufferedReader readUpper=new BufferedReader(new InputStreamReader(uppIn));

            System.out.println("Lowerclassman records:");
            data=readLower.readLine();
            while(data!=null){
                array=data.split(delimiter);//ID, surname, name, credits
                extract=new StringBuilder(array[3]);
                extract.setLength(3);//takes ### of credits out of "### credits"
                credit=Integer.parseInt(extract.toString());//credit hours, as integer

                System.out.println(array[0]+delimiter+" Name "+array[1]+delimiter+" "+
                        array[2]+delimiter+" "+array[3]+delimiter+" "+(GRAD_CREDITS-credit)+
                        " credit hours remain for graduation eligibility.");
                data=readLower.readLine();
            }
            System.out.println();

            System.out.println("Upperclassman records:");
            data=readUpper.readLine();
            while(data!=null){
                array=data.split(delimiter);//ID, surname, name, credits
                extract=new StringBuilder(array[3]);
                extract.setLength(3);//takes ### of credits out of "### credits"
                credit=Integer.parseInt(extract.toString());//credit hours, as integer

                System.out.println(array[0]+delimiter+" Name "+array[1]+delimiter+" "+
                        array[2]+delimiter+" "+array[3]+delimiter+" "+(GRAD_CREDITS-credit)+
                        " credit hours remain for graduation eligibility.");

                data=readUpper.readLine();
            }
            readLower.close();
            readUpper.close();

            System.out.println("\nAll stored records have been displayed.");
        }
        catch(Exception error){
            System.out.println("Error: "+error.getMessage());
        }
    }
}
