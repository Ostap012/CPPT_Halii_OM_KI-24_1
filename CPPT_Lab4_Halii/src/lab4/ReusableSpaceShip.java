package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

//��������� ��������� Moveable
interface Moveable
{
void move (double x); // �������� ������
}
//��������� ��������� Powered, �� ��������� ��������� Moveable
interface Powered extends Moveable
{
double milesToFueling (); // �������� ������
int SPEEDLIMIT = 100; // ���������
} 

public class ReusableSpaceShip extends Spaceship implements Powered  {
	private PrintWriter fout;
	public ReusableSpaceShip (double lFuel, double lMilesPerGalon) throws FileNotFoundException
	 {
	 fuel = lFuel;
	 milesPerGalon = lMilesPerGalon;
	 distance = 0.0;
	  fout = new PrintWriter(new File("Lab4.txt"));
	 }
	
	public void move (double x)
	 {
	 distance = distance + x;
	 fuel = fuel - distance / milesPerGalon;
	 }
	 public double getDistance()
	 {
	 return distance;
	 }
	 public double milesToFueling ()
	 {
	 return fuel*milesPerGalon;
	 }
	 private double distance;
	 private final double milesPerGalon;
	 private double fuel; 
}
