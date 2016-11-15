/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diarsid.algos.sort;

/**
 *
 * @author Diarsid
 */
public class Partition {
    
    private final int from;
    private final int to;
    
    public Partition(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.from;
        hash = 17 * hash + this.to;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final Partition other = ( Partition ) obj;
        if ( this.from != other.from ) {
            return false;
        }
        if ( this.to != other.to ) {
            return false;
        }
        return true;
    }
    
    
}
