package data;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;

public class FileReader {
    public static ArrayList<String> leerArchivo(String filepath) {
        String line=null;
        ArrayList<String> lines = new ArrayList<>();
        try {
            File archivo = new File(filepath);
            java.io.FileReader fr = new java.io.FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null){
                lines.add(line);
            }
            fr.close();
        } catch (Exception e) {
            System.out.println("Documento no disponible, por favor contactar con administrador.");
        }
        return lines;
    }
}

