/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmos;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.Random;

/**
 *
 * @author Jesus Moris <contacto@soluciontotal.cl>
 * @version 2016-08-25 
 *
 */
public class ArchivoRandom 
{
    int[] arr;
    Random rnd;
    int n;
    public ArchivoRandom(int n, String nombre) throws FileNotFoundException
    {
        arr = new int[n];
        this.n = n;
        this.rnd = new Random(LocalTime.now().getNano());
        PrintWriter writer = new PrintWriter(nombre+".txt");
        for(int i = 0; i < n; i++)
        {
            int nRand = this.rnd.nextInt(99999);
            writer.print((i!=0) ? "\r\n" : "");
            writer.print(nRand);
            arr[i] = nRand;
        }
        writer.close();
    }
    
    public int[] getArray()
    {
        return this.arr;
    }
}
