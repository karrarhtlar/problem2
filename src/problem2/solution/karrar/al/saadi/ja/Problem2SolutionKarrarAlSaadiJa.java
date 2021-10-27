/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2.solution.karrar.al.saadi.ja;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import static problem2.solution.karrar.al.saadi.ja.Problem2SolutionKarrarAlSaadiJa.fridge;

/**
 *
 * @author SMART
 */
public class Problem2SolutionKarrarAlSaadiJa {
    
// ************************* intiall value******************
    public  static String [][]fridge={
         {"banana","2"},{"apple","1"},{"egg","4"},
         {"orainge","2"},{"water","5"},{"onion","7"} 
     };
//****************************************************
    
    public static boolean validateRecipe(String [][]ingredients) {
 boolean result=false;
 int count=0;
    for (int i=0;i<ingredients.length;i++){
        for(int j=0;j<fridge.length;j++) {
             if(ingredients[i][0].compareTo(fridge[j][0])==0 ) {
                 int NewNumber=Integer.parseInt(fridge[j][1]) -Integer.parseInt(ingredients[i][1]);
                      if(NewNumber>=0){
                       fridge[j][1]=String.valueOf(NewNumber);
                        count++;
                      j=fridge.length;
                 }
               }
          }
        }
    if(count==ingredients.length)
        result=true;
    return result;
}    

     public static void main(String[] args) {
        // TODO code application logic here
    
     Scanner sc=new Scanner(System.in);
    int done=1;
    boolean result=false;
      
    try{
       BufferedWriter bw=new BufferedWriter(
                                                                 new FileWriter("node problem2-solution-karrar-al-saadi.ja.txt"));
       while(done== 1){
        System.out.println("\n the number of item is");
       int  numberOfItem =sc.nextInt();
       String [][]ingredients=new String[numberOfItem][2];    
      bw.write(" item is  ");  
       for(int i=0;i<numberOfItem;i++){
        System.out.println("\n  item  ["+(i+1)+"]   is:");
        ingredients[i][0]=sc.next();
        System.out.println("\n  number of item  ["+(i+1)+"]   is:");
        ingredients[i][1]=sc.next();

        bw.write( ingredients[i][0]+"\t|  "+ingredients[i][1] +"\t");
       }
        result=  validateRecipe(  ingredients );
         bw.write("Found :  "+String.valueOf(result)+"\n");
         System.out.println("if you need to continue enter 1\n else enter any thing ");
        done=sc.nextInt();
         }
 bw.close();
    }
    catch(Exception e){
        System.out.println(e);
            }
  }

}