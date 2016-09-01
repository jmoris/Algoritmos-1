/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmos;

/**
 *
 * @author Jesus Moris <contacto@soluciontotal.cl>
 * @version 2016-08-25 
 *
 */
public class SelectionSort<T extends Comparable<T>>
{
    private T[] arr;
    private long start_time, end_time;
    private int min;
    /**
     * Constructor del algoritmo de ordenamiento por seleccion.
     * @param arr Arreglo de elementos.
     */
    public SelectionSort(T[] arr)
    {
        this.arr = arr;
    }
    
    /**
     * Metodo para sortear los elementos de un arreglo de genericos.
     * @param arr Arreglo de elementos.
     * @return Arreglo ordenado.
     */
    public T[] sort()
    {
        this.start_time = System.currentTimeMillis();
        int n = this.arr.length;
        for (int i = 0; i < n - 1; i++) 
        {
            min = i;
            for (int j = i + 1; j < n; j++)
            {
                if (this.arr[j].compareTo(this.arr[min]) < 0)
                {
                      min = j;
                }
            }
            if (min != i) 
            {
                swap(i, min);
            }
        }
        this.end_time = System.currentTimeMillis();
        return this.arr;
    }
    /**
     * Metodo para hacer un intercambio de posiciones en el arreglo.
     * @param i Indice del primer elemento.
     * @param j Indice del segundo elemento.
     */
    private void swap(int i, int j)
    {
        T tmp = this.arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    /**
     * Metodo que retorna el tiempo de ejecucion de su ultimo ordenamiento.
     * @return Tiempo
     */
    public float getExecutionTime()
    {
        return (this.end_time-this.start_time)/1000f;
    }
}
