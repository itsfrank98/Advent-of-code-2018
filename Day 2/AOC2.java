
package aoc2;
import java.io.*;
import java.util.Vector;

public class AOC2 {

    public static void main(String[] args) throws IOException {
        NewClass A = new NewClass();
     //First task
        Vector<String> el = new Vector<String>(100);
        el = A.read();
        int letters_who_repeat_two=0;
        int letters_who_repeat_three=0;
        for(int i=0; i<el.size();i++){
            letters_who_repeat_two+=A.count_letters_repeat_two(el.get(i));
            letters_who_repeat_three+=A.count_letters_repeat_three(el.get(i));
        }
        System.out.println("Checksum: "+letters_who_repeat_two*letters_who_repeat_three);
        
     //Second task
        for(int i=0; i<el.size();i++){
            for(int j=i+1; j<el.size();j++){
                if(j!=i){        //By making this check I avoid the situazion in whic I compare a String with herself
                    String ST=A.find_similar(el.get(i), el.get(j));
                    if(ST!="")
                        System.out.println("Common letters between the two correct box IDs: "+ST);
                }
            }
                
        }
        
    }
    
}
