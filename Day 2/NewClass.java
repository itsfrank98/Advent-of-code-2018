/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoc2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author Francesco
 */
public class NewClass {
    public Vector<String> read() throws FileNotFoundException, IOException
    {
        FileReader f=new FileReader("A.txt");
        BufferedReader fIN=new BufferedReader(f);
        Vector<String> elementi=new Vector<String>(100);
        String p=fIN.readLine();
        while(p!=null){
            elementi.addElement(p);
            p=fIN.readLine();
        }
        elementi.trimToSize();
        
        return elementi;
    }
    
    public int count_occurrences(char c, String s){             //Conta il numero di occorrenze di una lettera in una parola
        int occ=0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==c)
                occ++;
        }
        return occ;
    }
    
    public boolean contains(char letters[], char c){
        boolean t=false;
        int i=0;
        while(t==false && i<letters.length){
            if(letters[i]==c)
                t=true;
            i++;
        }
        return t;
    }
    
    //This function verifies if in the string there is at least one letters who repeats exactly twice
    public int count_letters_repeat_two(String s){
        int flag=0;                                 //flag that indicates if we have found any letter who repeats exactly twice 
        int cont=0;                                 //It increases every time we examine a new letter
        int i=0;
        char letters[] = new char[s.length()];      //array of the letters we already examinated
        while(i<s.length()&&flag==0){
            if(contains(letters,s.charAt(i))!=true){    //if the letter has already been examinated, we proceed to the next
                if(count_occurrences(s.charAt(i),s)==2)
                    flag++;
            }
            else{
                letters[cont]=s.charAt(i);
                cont++;
            }
            i++;
        }
        return flag;
    }
    
    //This function verifies if in the string there is at least one letters who repeats exactly three times
    public int count_letters_repeat_three(String s){
        int flag=0;                                 //flag that indicates if we have found any letter who repeats exactly twice 
        int cont=0;                                 //It increases every time we examine a new letter
        int i=0;
        char letters[] = new char[s.length()];      //array of the letters we already examinated
        while(i<s.length()&&flag==0){
            if(contains(letters,s.charAt(i))!=true){    //if the letter has already been examinated, we proceed to the next
                if(count_occurrences(s.charAt(i),s)==3)
                    flag++;
            }
            else{
                letters[cont]=s.charAt(i);
                cont++;
            }
            i++;
        }
        return flag;
    }
    
    public String find_similar(String s, String exam){
        String s1=s;    //To avoid editing the strings given in input, I create one internal string which I can edit
        
        int c =0;       //It increases every time I find two different letters at the same position
        for(int i=0; i<s.length() && i<exam.length() && c<2;i++){
            if(s.charAt(i)!=exam.charAt(i)){
                c++;
                s1=s1.replace(s.charAt(i), '<');   //If I find two matching chars, I replace them with an other symbol which I will delete at the end
            }
        }
        if(c==2)
            return "";
        else{
            s1=s1.replace("<", "");        //Before returning the string I remove the flag char I had used
            return s1;
        }
    }
        
    
    
}
