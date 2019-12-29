/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codequiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darne
 */
public class CodeQuiz {
  
   int grade;
   String msg;
     private static ArrayList<String> QL = new ArrayList<>();
     private static ArrayList<String> AL = new ArrayList<>();
     Scanner sc;
    public static void main(String[] args) {
        
    }
    public ArrayList<String> getQuestions(String choice) {
        String test = "";
        
        try{
         sc = new Scanner(new File("src/codequiz/Quizes/"+choice+".txt"));
           
             while(sc.hasNextLine()){
                test = sc.nextLine();
                if(test.startsWith("Q.")){
                    QL.add(test.replace("Q.", ""));
                }
                if(test.startsWith("A.")){
                    AL.add(test.replace("A.", ""));
                }
                if(test.startsWith("M.")){
                    
                }
               
             }
             sc.close();
     }catch(IOException e){
         
     }
      return QL;
    }
    public ArrayList<String> getAnswers(){
      return AL;  
    }
    public String[] getFileNames(){
        File folder = new File("src/codequiz/Quizes");
        File[] check = folder.listFiles();
        String [] files = new String[check.length];
        for(int i=0;i< check.length;i++){
            if(check[i].isFile()){
                files[i] = check[i].getName().replace(".txt", "");
            }
        }
        return files;
    }

   
}
