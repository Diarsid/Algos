package diarsid.algos.search;

/**
 * @author Diarsid
 */
class BinarySearch {
        
    BinarySearch() {
    }
    
    public static void main(String[] args) {
        int[] data = {1, 5, 8, 12, 13, 18, 23, 56, 87, 95};
        int asked = 1;
        System.out.println("result: index of '" + asked + "' is: " + search(asked, data));
    }
    
    static int search(final int asked, int [] data) {
        if (data.length == 0) {
            return -1;
        }
        
        if (data.length == 1) {
            if (data[0] == asked) {
                return 0;
            } else {
                return -1;
            }
        }
        
        int from = 0;
        int to = data.length;
        int midIndex = getMiddleIndexBetween(from, to);
        while ( from != to ) {    
            if ( (midIndex == data.length) || (midIndex < 0) ) {
                return -1;
            }            
            if ( asked == data[midIndex] ) {
                return midIndex;
            } else if ( asked > data[midIndex] ) {
                from = midIndex + 1;
                midIndex = getMiddleIndexBetween(from, to);
            } else {
                to = midIndex;
                midIndex = getMiddleIndexBetween(from, to);
            }
        }
        return -1;
    }
    
    static int getMiddleIndexBetween(int from, int to) {
        return (( (to - from) / 2 ) + from );
    }
}
