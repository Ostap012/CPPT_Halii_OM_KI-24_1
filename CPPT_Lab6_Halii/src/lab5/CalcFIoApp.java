/**
 * 
 */
package lab5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author ostap
 *
 */
public class CalcFIoApp {
	
	public static void main(String[] args) throws FileNotFoundException, IOException
	 {
	  // TODO Auto-generated method stub
	  CalcWFio calc = new CalcWFio();
	  Scanner s = new Scanner(System.in);
	  System.out.print("Enter data: ");
	  double data = s.nextDouble();
	  calc.calculate(data);
	  System.out.println("Result is: " + calc.getResult());
	  calc.writeResTxt("textRes.txt");
	  calc.writeResBin("BinRes.bin");

	  calc.readResBin("BinRes.bin");
	  System.out.println("Result is: " + calc.getResult());
	  calc.readResTxt("textRes.txt");
	  System.out.println("Result is: " + calc.getResult());
	 }
}

class CalcWFio{
	
  public void writeResTxt(String fName) throws FileNotFoundException{
      PrintWriter f = new PrintWriter(fName);
      f.printf("%f ",result);
      f.close();
 }

  public void readResTxt(String fName){
    try{
        File f = new File (fName);
          if (f.exists()){
              Scanner s = new Scanner(f);
              result = s.nextDouble();
              s.close();
          }
         else
            throw new FileNotFoundException("File " + fName + "not found");
      }
    catch (FileNotFoundException ex){
       System.out.print(ex.getMessage());
      }
  }

  public void writeResBin(String fName) throws FileNotFoundException, IOException{
     DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
     f.writeDouble(result);
     f.close();
  }

  public void readResBin(String fName) throws FileNotFoundException, IOException{
     DataInputStream f = new DataInputStream(new FileInputStream(fName));
     result = f.readDouble();
     f.close();
  }
  
  //Method calculates the ñtg(x) expression
  public void calculate(double x){
   result = x * Math.PI / 180.0;
  }

  public double getResult(){
	  
   return result;
  }
 
  private double result;
 
}