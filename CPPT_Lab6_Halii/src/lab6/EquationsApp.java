package lab6;

import java.util.Scanner;
import java.io.*;

import static java.lang.System.out;


public class EquationsApp {

    public static void main(String[] args) throws IOException {
        try {
            out.print("Enter file name: ");
            Scanner in = new Scanner(System.in);
            String fName = in.nextLine();
            PrintWriter fout = new PrintWriter(new File(fName));
            try {
                try {
                    CalcWFio obj = new CalcWFio();

                    Equations eq = new Equations();
                    out.print("Enter X: ");
                    int step =in.nextInt();

                    
                    for(int i=1; i<=5; i++) {
                    double result = eq.calculate(step);
                	
                    fout.printf("ctg(%d) = %f\n ",step,result); 
                    
                    step = step+25;
                    System.out.println("Result is: " + result);
                    obj.writeResTxt("textRes.txt", result);
                    obj.writeResBin("BinRes.bin", result);
                    
                    obj.readResBin("BinRes.bin");
                    obj.readResTxt("textRes.txt");
                    }
                    
                } finally {
// ��� ���� ���������� �� ����-���� ��������
                    fout.flush();
                    fout.close();
                }
            } catch (CalcException ex) {

// ���� ���������� ������� ��������� ������
                out.print(ex.getMessage());
            }
        } catch (FileNotFoundException ex) {

// ���� ���������� ������� ������ � ������ ����� ���� ����
// ������� � ����� finally
            out.print("Exception reason: Perhaps wrong file path");
        }
    }
}