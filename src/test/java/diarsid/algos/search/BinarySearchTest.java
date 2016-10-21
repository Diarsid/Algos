package diarsid.algos.search;

import org.junit.Test;

import static org.junit.Assert.*;
import static diarsid.algos.search.BinarySearch.search;

/** *
 * @author Diarsid
 */
public class BinarySearchTest {
    
    private int[] dataSet;
            
    @Test
    public void testSearcExistedElementInEvenArray() {
        dataSet = new int[]{2, 3, 6, 9, 12, 15, 17, 23, 34, 41};
        int result = -1;
        
        result = search(9, dataSet);
        assertEquals(3, result);
        
        result = search(34, dataSet);
        assertEquals(8, result);
        
        result = search(2, dataSet);
        assertEquals(0, result);
        
        result = search(41, dataSet);
        assertEquals(9, result);
    }
    
    @Test
    public void testSearcExistedElementInOddArray() {
        dataSet = new int[]{2, 3, 6, 9, 12, 15, 17, 23, 34};
        int result = -1;
        
        result = search(9, dataSet);
        assertEquals(3, result);
        
        result = search(17, dataSet);
        assertEquals(6, result);
        
        result = search(2, dataSet);
        assertEquals(0, result);
        
        result = search(34, dataSet);
        assertEquals(8, result);
    }
    
    @Test
    public void searchUnexistedElement() {
        dataSet = new int[]{2, 3, 6, 9, 12, 15, 17, 23, 34};
        int result = 1;
        
        result = search(-28, dataSet);
        assertEquals(-1, result);
        
        result = search(1000, dataSet);
        assertEquals(-1, result);
        
        result = search(16, dataSet);
        assertEquals(-1, result);
        
        result = search(5, dataSet);
        assertEquals(-1, result);
    }
    
    @Test
    public void searchInEmptyArray() {
        dataSet = new int[]{};
        int result = 1;
        
        result = search(5, dataSet);
        assertEquals(-1, result);
    }
    
    @Test
    public void searchExisetedInArrayWithOneElement() {
        dataSet = new int[]{5};
        int result = -1;
        
        result = search(5, dataSet);
        assertEquals(0, result);
    }
    
    @Test
    public void searchUnexisetedInArrayWithOneElement() {
        dataSet = new int[]{5};
        int result = 0;
        
        result = search(8, dataSet);
        assertEquals(-1, result);
    }
}