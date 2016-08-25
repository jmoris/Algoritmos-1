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
public class SelectionSort<T>
{
    int i, j, n, minIndex, tmp;
    int[] arr;
    
    public SelectionSort(int[] arr)
    {
        this.arr = arr;
    }
    
    public int[] getArray()
    {
        return this.arr;
    }
    
    public void sort(T[] arr)
    {
        n = this.arr.length;
        for (i = 0; i < n - 1; i++) 
        {
            minIndex = i;
            for (j = i + 1; j < n; j++)
            {
                if (this.arr[j] < this.arr[minIndex])
                {
                      minIndex = j;
                }
            }
            if (minIndex != i) 
            {
                tmp = this.arr[i];
                this.arr[i] = this.arr[minIndex];
                this.arr[minIndex] = tmp;
            }
        }
    }
}
