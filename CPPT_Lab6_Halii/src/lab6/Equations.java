package lab6;

class Equations {

    public double calculate(int x) throws CalcException {
        double y, rad;
	     rad = x * Math.PI / 180.0;
	      try{
	           y =  1/Math.tan(rad);
	           System.out.printf("y = ctg(%d) = %f \n", x , 1/Math.tan(rad));
	           
	           // Якщо результат не є числом, то генеруємо виключення
	            if (y==Double.NaN || y==Double.NEGATIVE_INFINITY ||  y==Double.POSITIVE_INFINITY || x==90 || x== -90)
	            throw new ArithmeticException();
	         }
	      catch (ArithmeticException ex) {
	          // створимо виключення вищого рівня з поясненням причини
	          // виникнення помилки
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