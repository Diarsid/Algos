/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diarsid.algos.sort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

import static diarsid.algos.sort.BubbleSort.sort;

/**
 *
 * @author Diarsid
 */
public class BubbleSortTest {

    public BubbleSortTest() {
    }


    /**
     * Test of sort method, of class BubbleSort.
     */
    @Test
    public void testSort_even_array() {
        int[] data = {10, 2, 8, 6, 1, 4};
        int[] sorted = {1, 2, 4, 6, 8, 10};
        sort(data);
        assertArrayEquals(sorted, data);
    }
    
    @Test
    public void testSort_odd_array() {
        int[] data = {10, 2, 8, 6, 1};
        int[] sorted = {1, 2, 6, 8, 10};
        sort(data);
        assertArrayEquals(sorted, data);
    }
    
    @Test
    public void testSort_0_length_array() {
        int[] data = {};
        int[] sorted = {};
        sort(data);
        assertArrayEquals(sorted, data);
    }
    
    @Test
    public void testSort_1_length_array() {
        int[] data = {3};
        int[] sorted = {3};
        sort(data);
        assertArrayEquals(sorted, data);
    }
    
    @Test
    public void testSort_2_length_array() {
        int[] data = {5, 2};
        int[] sorted = {2, 5};
        sort(data);
        assertArrayEquals(sorted, data);
    }

}