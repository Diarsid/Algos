/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package diarsid.algos.trees.traversal;

import java.util.ArrayDeque;
import java.util.Deque;

import diarsid.algos.trees.TreeNode;

/**
 *
 * @author Diarsid
 */
public class TreeTraversal {
    
    private TreeTraversal() {
    }
    
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode("1");
        TreeNode n2 = new TreeNode("2");
        TreeNode n3 = new TreeNode("3");
        TreeNode n4 = new TreeNode("4");
        TreeNode n5 = new TreeNode("5");
        TreeNode n6 = new TreeNode("6");
        TreeNode n7 = new TreeNode("7");
        
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n5.setRight(n6);
        n3.setLeft(n7);
        
        breadthFirst(n1);
    }
    
    public static void preOrder(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        
        TreeNode current;
        while ( ! stack.isEmpty() ) {
            current = stack.pop();
            visit(current);
            
        }
    }
    
    public static void breadthFirst(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);        
        TreeNode current = stack.peek();
        
        while ( ! stack.isEmpty() ) {
            current = stack.pop();
            visit(current);            
            if ( current.hasRight() ) {
                stack.push(current.getRight());
            } 
            if ( current.hasLeft() ) {
                stack.push(current.getLeft());
            }             
        }
    }
    
    public static void inOrderCanonical(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);        
        TreeNode current = stack.peek();
        
        while ( current.hasLeft() ) {                
            stack.push(current.getLeft());
            current = current.getLeft();
        }
        
        while ( ! stack.isEmpty() ) {
            current = stack.pop();
            visit(current);
            
            if ( current.hasRight() ) {
                stack.push(current.getRight());
                current = current.getRight();
                while ( current.hasLeft() ) {
                    stack.push( current.getLeft() );
                    current = current.getLeft();
                }
            } 
        }
    }
    
    public static void inOrderMy(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);        
        TreeNode current = stack.peek();
        
        while ( ! stack.isEmpty() ) {
            
            while ( current.hasLeft() ) {                
                stack.push(current.getLeft());
                current = current.getLeft();
            }
            
            stack.pop();
            visit(current);
            
            if ( current.hasRight() ) {
                stack.push(current.getRight());
                current = current.getRight();
            } else {
                while ( ! current.hasRight() && ! stack.isEmpty() ) {
                    current = stack.pop();
                    visit(current);
                }
                if ( current.hasRight() ) {
                    stack.push(current.getRight());
                    current = current.getRight();
                }                
            }            
        }
    }

    private static void visit(TreeNode current) {
        System.out.println(current.getValue());
    }
}
