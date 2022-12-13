package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class DataUpdater {
    public static void guardarUsuario(String usuario, String pass, String filepath, int id){
        BufferedWriter bw = null;
        FileWriter fichero = null;

        try {
            File file = new File(filepath);
            fichero = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fichero);
            if(id == 1){
                bw.write(usuario+","+pass);
            }
            else {
                bw.write("\n" + usuario + "," + pass);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null)
                    bw.close();
                if (fichero != null)
                    fichero.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void guardarCliente(String nombre,String correo,String numero,String rut, String filepath, int id){
        BufferedWriter bw = null;
        FileWriter fichero = null;

        try {
            File file = new File(filepath);
            fichero = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fichero);
            if(id == 1){
                bw.write(nombre+","+correo+","+numero+","+rut);
            }
            else {
                bw.write("\n" + nombre + "," + correo + "," + numero + "," + rut);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null)
                    bw.close();
                if (fichero != null)
                    fichero.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void guardarMascota(String nombre,String tipo,int peso, String filepath, int id){
        BufferedWriter bw = null;
        FileWriter fichero = null;

        try {
            File file = new File(filepath);
            fichero = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fichero);
            if(id == 1){
                bw.write(nombre+","+tipo+","+peso);
            }
            else {
                bw.write("\n" + nombre + "," + tipo + "," + peso);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Cierra instancias de FileWriter y BufferedWriter
                if (bw != null)
                    bw.close();
                if (fichero != null)
                    fichero.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }




}
