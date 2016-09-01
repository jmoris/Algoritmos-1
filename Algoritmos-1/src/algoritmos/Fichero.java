/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Jesus Moris <contacto@soluciontotal.cl>
 * @version 2016-08-30 
 *
 */
public class Fichero<T extends Comparable<T>>
{
    private Boolean mode;
    private Boolean append;
    private BufferedWriter escritor;
    private BufferedReader lector;
    /**
     * Constructor del objeto Fichero
     * @param path Ruta del archivo.
     * @param mode True para escritura, False para lectura
     */
    public Fichero(String path, Boolean mode)
    {
        this.append = false;
        this.mode = mode;
        try{
            if(mode)
            {
                escritor = new BufferedWriter(new FileWriter(path, this.append), 32768);
            }else{
                lector = new BufferedReader(new FileReader(path), 32768);
            }   
        }catch(Exception e){
            System.out.println("ERROR: No se pudo acceder al fichero.");
        }
    }
    /**
     * Metodo para cambiar la sobreescritura.
     * @param append True sobreescribe.
     */
    public void setAppend(Boolean append)
    {
        this.append = append;
    }
    /**
     * Metodo de lectura de linea.
     * @return T informacion.
     */
    public String[] leer()
    {
        ArrayList<String> arrlst = new ArrayList<String>();
        if(this.mode)
        {
            System.out.println("ERROR: Fichero abierto en modo escritura.");
        }else{
            try{
                int i=0;
                String[] arr;
                String line;
                while((line = lector.readLine()) != null){
                    arrlst.add(line);
                    i++;
                }
                arr = new String[arrlst.size()];
                arrlst.toArray(arr);
                return arr;
            }catch(Exception e){
                System.out.println("ERROR: No se pudo leer la linea.");
            }
        }
        return null;
    }
    /**
     * Metodo de escritira de linea.
     * @param data informacion.
     */
    public void escribir(T data)
    {
        if(this.mode)
        {
            try{
                this.escritor.write(String.valueOf(data)+"\r\n");
                this.escritor.flush();
            }catch(Exception e){
                System.out.println("ERROR: No se pudo escribir la linea.");
            }
        }else{
            System.out.println("ERROR: Fichero abierto en modo escritura.");
        }
    }
    /**
     * Metodo para cerrar el fichero.
     */
    public void cerrar()
    {
        try{
            if(this.escritor != null){ this.escritor.close(); }
            if(this.lector != null){ this.lector.close(); }
        }catch(Exception e){
            System.out.println("ERROR: No se pudo cerrar el fichero.");
        }
    }
}
