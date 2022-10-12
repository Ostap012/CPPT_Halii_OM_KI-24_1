package lab3;
import java.io.*;


public class Spaceship {
	
	private Movement movementDevice;
	private RelativePosition pos;
	private Start  st;
	private PrintWriter fout;
	
	 public Spaceship() throws FileNotFoundException
	 {
		movementDevice = new Movement();
		 pos = new RelativePosition();
		 st = new Start();
		 
		fout = new PrintWriter(new File("Lab3.txt"));
	 }

	 public Spaceship(int res) throws FileNotFoundException
	 {
		 movementDevice = new Movement();
		 pos = new RelativePosition();
		 st = new Start();
		 
		 fout = new PrintWriter(new File("Lab3.txt"));
	 }
	 
	 
	 public void clickStart()
	 {
	 st.startButton();
     
	 fout.print("Starting the engines....\n");
	 fout.print("Space ship has: " +
	 st.getShipFuel() + " fuel \n");
	 fout.flush();
	 }

	 public int getStartShipFuel()
	 {
	 return st.getShipFuel();
	 }

	

	 public void MoveUp()
	 {
		 movementDevice.setUpMovement();

	 fout.print("Space Ship moved up\n");
	 fout.flush();
	 }

	 public void MoveDown()
	 {
		 movementDevice.setDownMovement();

	 fout.print("Space Ship moved down\n");
	 fout.flush();
	 }
	 public void MoveRight()
	 {
		 movementDevice.setUpMovement();

	 fout.print("Space Ship moved right\n");
	 fout.flush();
	 }

	 public void MoveLeft()
	 {
		 movementDevice.setDownMovement();

	 fout.print("Space Ship moved left\n");
	 fout.flush();
	 }
	 public void resetMovement()
	 {
		 movementDevice.resetMovement();

	 fout.print("Space Ship did not move anywhere \n");
	 fout.flush();
	 }
	 
	 public Movement.Movements getMovement()
	 {
	 return movementDevice.getMovement();
	 }

	 public void dispose()
	 {
	 fout.close();
	 }
	 
	 
	 public void setShipPosition(int xPos, int yPos)
	 {
	 pos.setXPosition(xPos);
	 pos.setYPosition(yPos);
	 }

	 public int getShipXPosition()
	 {
	 return pos.getXPosition();
	 }

	 public int getShipYPosition()
	 {
	 return pos.getYPosition();
	 }
}


class Movement{

	 enum Movements {NEUTRAL, UP, DOWN,RIGHT,LEFT};


	 private Movements movement;

	 
	 public Movement()
	 {
		 movement = Movements.NEUTRAL;
	 }
	 
	 public void setNeutralMovement()
	 {
		 movement = Movements.NEUTRAL;
	 }
	 public void setUpMovement()
	 {
		 movement = Movements.UP;
	 }

	 public void setDownMovement()
	 {
	 movement = Movements.DOWN;
	 }
	 public void setRightMovement()
	 {
	 movement = Movements.RIGHT;
	 }
	 public void setLeftMovement()
	 {
	 movement = Movements.LEFT;
	 }
	 
	 public void resetMovement()
	 {
	 setNeutralMovement();
	 }
	 
	 public Movements getMovement()
	 {
	 return movement;
	 }
	}

class Start{
	private int fuel;

	 public Start()
	 {
		 fuel= 1000;
	 }

	 
	 public Start(int res)
	 {
		 fuel = res;
	 }

	 public void startButton()
	 {
		 fuel = fuel - 10;
	 }
	 public int getShipFuel()
	 {
	 return fuel;
	 }
}
class RelativePosition{
 
     private int x, y;

      public RelativePosition()
      {
       x = 0;
       y = 0;
      }

      public RelativePosition(int xPos, int yPos)
      {
       x = xPos;
       y = yPos;
      }

      public int getXPosition()
      {
       return x;
      }

      public int getYPosition()
      {
       return y;
      }

      public void getPosition(RelativePosition obj)
      {
       obj.x = x;
       obj.y = y;
      }

      public void setXPosition(int xPos)
      {
       x = xPos;
      }

      public void setYPosition(int yPos)
      {
       y = yPos;
      }

}