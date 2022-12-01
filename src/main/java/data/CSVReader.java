package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


//**Clase en Posible uso en futuro**



public class CSVReader {
    private static String line="";



    public static void readCSV(String path){
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line= br.readLine())!=null){
                String[] values= line.split(";");
                System.out.println(values[3]);

            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
