/*
 * Programación III - TPE
 */
package TPE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * Ejemplo de cómo leer un archivo CSV
 * 
 * @author Mariano A. Fernandez <fernandez.mariano.a@gmail.com>
 */
public class CSVReader {

    public String[] reader(String path)  {
    	String[] lineas = new String[10000];   	
        String line = "";
        int numLine = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
            	if(numLine > 0){
            		lineas[numLine]= line;
                    }
            	}
            	numLine++;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineas;
    }
   
}