package test2;
import java.io.*;
import java.util.*;

public class test{
 
 public static void main(String[] args) throws FileNotFoundException
 {
 int nRows;
 char[][] arr;
 String filler;

 Scanner in = new Scanner(System.in);
 File dataFile = new File("MyFile.txt");
 PrintWriter fout = new PrintWriter(dataFile);

 System.out.print("Введіть розмір квадратної матриці: ");
 nRows = in.nextInt();
 in.nextLine();

 arr = new char[nRows][];
 for(int i = 0; i < nRows/2; i++){ 
       arr[i]= new char[i+1];
 }
 for(int i = nRows/2; i < nRows; i++){ 
	 for(int j = nRows/2; j < i+1; j++){
	   arr[i]= new char[i+1];
	 }
 }

 

 System.out.print("\nВведіть символ-заповнювач: ");
 filler = in.nextLine();

 exit:
	 if(filler.length() == 1){
       for(int i = 0; i < nRows/2; i++){
            for(int j = 0; j < i+1; j++){
            	
             arr[i][j] = (char) filler.codePointAt(0);
             if(i==j) {
          		arr [i][j]=('n');
          	}
             System.out.print(arr[i][j] + " ");
             fout.print(arr[i][j] + " ");  
            }
            System.out.print("\n");
            fout.print("\n");
             
       } 
        for(int i = nRows/2; i < nRows; i++){
    	   fout.print(" ".repeat(nRows));
    	   System.out.print(" ".repeat(nRows) );
	       for(int j = nRows/2; j < i+1; j++){
	    	   arr[i][j] = (char) filler.codePointAt(0);
	    	   if(i==j) {
	          		arr [i][j]=('n');
	          	}
	         System.out.print( arr[i][j] + " ");
	         fout.print( arr[i][j] + " ");
	        }
	       System.out.print("\n");
	       fout.print("\n");
	    }
        
      }
     else if (filler.length() == 0)
     {
        System.out.print("\nНе введено символ заповнювач");
        break exit;
     }
     else
     {
        System.out.print("\nЗабагато символів заповнювачів");
         break exit;
     }

  fout.flush();
  fout.close();

 }
}

