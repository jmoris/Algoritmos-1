/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmos;

import java.io.FileNotFoundException;

/**
 *
 * @author Jesus Moris <contacto@soluciontotal.cl>
 * @version 20160825 
 *
 */
public class Main 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException 
    {
        long time_start, time_end;
        int numeros = 25;
        int i = 1;
        //incio iempo
        while(numeros <= 100000000)
        {
            time_start = System.currentTimeMillis();
            System.out.println("--------------Archivo " + i + " --------------");
            ArchivoRandom rnd = new ArchivoRandom(numeros, "archivo-"+i);
            SelectionSort ss = new SelectionSort(rnd.getArray());
            time_end = System.currentTimeMillis();
            System.out.println("El archivo-" + i + " tomo " + (( time_end - time_start ) / 1000.0) +" segundos.");
            /*for (int n : ss.getArray()) {
                System.out.println(n);
            }*/

            System.out.println("-------------- FIN --------------");
            numeros *= 2;
            i++;
        }
        //termino tiempo
    }

}
    