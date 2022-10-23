
package lab4;
import static java.lang.System.out;
import java.io.FileNotFoundException;



public class ReusableSpaceShipApp {
	public static void main(String[] args) throws FileNotFoundException
	 {
	  Movement.Movements dir = null;
	  ReusableSpaceShip megaship = new ReusableSpaceShip(10, 100);
		
		megaship.clickStart();
		out.print(megaship.getStartShipFuel() + "\n");
		
		megaship.move(10);
		out.print(megaship.getDistance() + "\n");
		out.print(megaship.milesToFueling() + "\n");
	 
	    
		megaship.MoveRight();
		
		 dir = megaship.getMovement();
		 if (dir == Movement.Movements.UP)
		 out.print ("Down" + "\n");
		 else if (dir == Movement.Movements.DOWN)
		 out.print ("Up" + "\n");
		 else if (dir == Movement.Movements.RIGHT)
	     out.print ("Right" + "\n");
		 else if (dir == Movement.Movements.LEFT)
		 out.print ("Left" + "\n");
		 else
		 out.print ("Neutral" + "\n");

		 megaship.dispose();
		 
		
	 }
}
