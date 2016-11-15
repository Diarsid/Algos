/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diarsid.algos.sort;

import java.util.Stack;

import static java.lang.String.valueOf;


/**
 *
 * @author Diarsid
 */
public class QuickSort {
    
    static Stack<Partition> stack = new Stack<>();
    
    public QuickSort() {        
    }
    
    public static void main(String[] args) {
        int[] data = new int[]{8, 2, 18, 6, 54, 1, 7, -2};
        printArry("", data);
        divideAndProcess(data, 0, data.length-1);
        Partition nextPartition;
        while ( ! stack.isEmpty() ) { 
            nextPartition = stack.pop();
            divideAndProcess(data, nextPartition.getFrom(), nextPartition.getTo());
        }
        printArry("", data);
    }

    private static void printArry(String inline, int[] arr) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb1.append("| ");
        sb3.append("| ");
        for (int i = 0; i < arr.length; i++) {
            sb1.append(i).append(" ");
            sb3.append(arr[i]).append(" "); 
            if ( valueOf(arr[i]).length() > 1) {
                sb1.append(" ");
            }
        }
        sb1.append("|");
        sb3.append("|");
        System.out.println(inline + sb1.toString());
        System.out.println(inline + sb3.toString());
    }
    
    static void divideAndProcess(int[] data, int from, int to) {
        System.out.printf("divide! from: %d, to: %d \n", from, to);
        int length = to - from + 1;
        if ( length <= 1 ) {
            return;
        } else if ( length == 2 ) {
            compareAndSwap(data, to, from);
            return;
        }
        
        int low = from;
        int high = to;
        int base = (to + from) / 2;
        System.out.println("  chosen base: " + base);
        
        boolean swap = true;
        while ( swap ) {     
            swap = false;
            while ( (data[high] > data[base]) && high > from ) {
                high--;
                System.out.println("  high: " + high);
            }
            
            while ( (data[low] < data[base]) && low < length ) {
                low++;
                System.out.println("  low: " + low);
            } 
            
            if ( low < high ) {
                swap = compareAndSwap(data, high, low);
                if ( low == base && swap ) {
                    base = high;
                } else if ( high == base && swap ) {
                    base = low;
                }                
            }
        }
        System.out.println("  final base: " + base);
        stack.push(new Partition(base, to));
        stack.push(new Partition(from, base-1));        
    }
    
    static boolean compareAndSwap(int[] data, int high, int low) {
        if ( data[low] > data[high] ) {
            System.out.println("    swap: ");
            printArry("    ", data);
            System.out.printf("    [%d] <-> [%d] \n", low, high);
            int swap = data[low];
            data[low] = data[high];
            data[high] = swap;
            printArry("    ", data);
            return true;
        } else {
            return false;
        }
    }
}
