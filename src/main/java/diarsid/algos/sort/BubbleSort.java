/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diarsid.algos.sort;

import static java.util.Arrays.stream;

/**
 *
 * @author Diarsid
 */
public class BubbleSort {
    
    public BubbleSort() {
    }
    
    public static void main(String[] args) {
        int[] data = {5, 2, 1, 8, 4, 12, 2, 6};
        sort(data);
        stream(data).forEach(i -> System.out.println("" + i + " "));
    }
    
    public static void sort(int[] data) {
        
        if ( data.length < 2 ) {
            return;
        } else if ( data.length == 2 ) {
            if ( data[0] > data[1] ) {
                int swap = data[0];
                data[0] = data[1];
                data[1] = swap;
            }
            return;
        }
        
        boolean dataIsUnsorted = true;
        int current;
        int next;
        int dataLength = data.length;
        
        while ( dataIsUnsorted ) {
            dataIsUnsorted = false;
            for (int i = 0; i < dataLength - 1; i++) {
                current = data[i];
                next = data[i + 1];
                if ( current > next ) {
                    data[i] = next;
                    data[i + 1] = current;
                    dataIsUnsorted = true;                    
                }
            }
        }
    }
    
}
