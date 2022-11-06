/**
 * 
 */
package lab6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class CalcWFio {
//
    public void writeResTxt(String fName, double result) throws FileNotFoundException {
        PrintWriter f = new PrintWriter(fName);
        f.printf("%f ", result);
        f.close();
    }

    public void readResTxt(String fName) {
        try {
            File f = new File(fName);
            if (f.exists()) {
                Scanner s = new Scanner(f);
                result = s.nextDouble();
                s.close();
            } else
                throw new FileNotFoundException("File " + fName + "not found");

        } catch (FileNotFoundException ex) {
            System.out.print(ex.getMessage());
        }
    }

    public void writeResBin(String fName, double result) throws FileNotFoundException, IOException {

        DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
        f.writeDouble(result);
        f.close();

    }

    public void readResBin(String fName) throws FileNotFoundException, IOException {

        DataInputStream f = new DataInputStream(new FileInputStream(fName));
        result = f.readDouble();
        f.close();
    }

    private double result;
}