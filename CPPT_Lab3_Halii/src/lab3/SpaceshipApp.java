/**
 * 
 */
package lab3;
import static java.lang.System.out;
import java.io.*;


/**
 * @author ostap
 *
 */
public class SpaceshipApp {
	public static void main(String[] args) throws FileNotFoundException
	 {
		Movement.Movements dir = null;
		Spaceship ship = new Spaceship();
		
		ship.clickStart();;
		out.print(ship.getStartShipFuel() + "\n");
		 
		ship .setShipPosition(1, 1);
	
		
		ship.MoveRight();
		
		 dir = ship.getMovement();
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

		 ship.dispose();
	 }
}
