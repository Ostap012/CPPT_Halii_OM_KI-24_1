package lab5;

import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Calc {

	public static void main(String[] args){
		
	 try{
	    out.print("Enter file name: ");
	    Scanner in = new Scanner(System.in);
	    String fName = in.nextLine();
	    PrintWriter fout = new PrintWriter(new File(fName));
	 try{
	       try{
	              Equations eq = new Equations();
	              out.print("Enter X: ");
	              fout.print(eq.calculate(in.nextInt()));
	          }
	        finally{
	        // ??? ???? ??????????? ?? ????-???? ????????
	                 fout.flush();
	                 fout.close();
	               }
	     }
	 catch (CalcException ex){
	      // ???? ?????????? ??????? ????????? ??????
	      out.print(ex.getMessage());
	    }
	 }
	 catch (FileNotFoundException ex){
	       // ???? ?????????? ??????? ?????? ? ?????? ?????? ???? ????
	       // ??????? ? ????? finally
	      out.print("Exception reason: Perhaps wrong file path");
	  }
   }
}
	
	class CalcException extends ArithmeticException {
	  public CalcException(){}

	  public CalcException(String cause){
	     super(cause);
	  }
	}
	/**
	 * Class <code>Equations</code> implements method for ?tg(x) expression
	 * calculation
	 * @author Ostap
	 * @version 1.0
	 */
	class Equations{
	 /**
	 * Method calculates the ?tg(x) expression
	 * @param <code>x</code> Angle in degrees
	 * @throws CalcException
	 */
	public double calculate(int x) throws CalcException{
	     double y, rad;
	     rad = x * Math.PI / 180.0;
	      try{
	           y =  1/Math.tan(x);
	           System.out.printf("y = ctg(%d) = %f \n", x , 1/Math.tan(x));
	           
	           // ???? ????????? ?? ? ??????, ?? ????????? ??????????
	            if (y==Double.NaN || y==Double.NEGATIVE_INFINITY ||  y==Double.POSITIVE_INFINITY || x==90 || x== -90)
	            throw new ArithmeticException();
	         }
	      catch (ArithmeticException ex) {
	          // ???????? ?????????? ?????? ????? ? ?????????? ???????
	          // ?????????? ???????
	         if (rad==Math.PI/2.0 || rad==-Math.PI/2.0)
	                throw new CalcException("Exception reason: Illegal value of X for tangent calculation");
	         else if (x==0)
	                throw new CalcException("Exception reason: X = 0");
	         else
	                throw new CalcException("Unknown reason of the exception during exception calculation");
	         }

	     return y;
	    }
	 
    } 

