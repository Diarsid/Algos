/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diarsid.algos.trees;

import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 *
 * @author Diarsid
 */
public class TreeNode {
    
    private final String value;    
    private TreeNode left;
    private TreeNode right;
    
    public TreeNode(String value) {
        this.value = value;
    }
    
    public boolean isLeaf() {
        return ( isNull(this.right) && isNull(this.left) );
    }
    
    public boolean hasLeft() {
        return nonNull(this.left);
    }
    
    public boolean hasRight() {
        return nonNull(this.right);
    }

    public String getValue() {
        return this.value;
    }
    
    public TreeNode getLeft() {
        return this.left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return this.right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.value);
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
        final TreeNode other = ( TreeNode ) obj;
        if ( !Objects.equals(this.value, other.value) ) {
            return false;
        }
        return true;
    }
}
