/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmos;

import java.time.LocalTime;
import java.util.Random;


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
    public static void main(String[] args) 
    {
        /* Creamos los archivos de prueba */
        Random rnd = new Random(LocalTime.now().getNano());
        int n = 20,
            c = 0,
            i = 0;
        while(n < 1000000){
            Fichero<Integer> f = new Fichero<Integer>("archivo-"+c+".txt", true);
            for(i = 0; i < n; i++){
                f.escribir(rnd.nextInt(Integer.MAX_VALUE));
            }
            f.cerrar();
            c++;
            n*=2;
        }
        /* Cargamos los archivos de prueba para su ordenamiento */
        int tmp = c;
        c = 0;
        while(c < tmp){
            Fichero<Integer> f2 = new Fichero<Integer>("archivo-"+c+".txt", false);
            String[] src = f2.leer();
            Integer[] dst = new Integer[src.length];
            i = 0;
            for (String str : src) {
                dst[i] = Integer.valueOf(str);
                i++;
            }
            /* Ordenamos el arreglo de enteros */
            SelectionSort<Integer> ss = new SelectionSort<Integer>(dst);
            Integer[] dst2 = ss.sort();
            System.out.println(ss.getExecutionTime());
            
            /* Quitar comentarios para guardar los archivos.
            Fichero<Integer> f3 = new Fichero<Integer>("orden-"+c+".txt", true);
            for (Integer integer : dst2) {
                f3.escribir(integer);
            }
            f3.cerrar();*/
            f2.cerrar();
            c++;

        }
        System.out.println(c);
    }

}
    