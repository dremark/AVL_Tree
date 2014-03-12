package AvlTree;

import java.awt.Point;

/**
 * Entity class node AVL tree.
 *
 * @author Gnylorybov Evgeniy
 */
public class AvlNode {
    public AvlNode left;
    public AvlNode right;
    public AvlNode parent;
    public int key;
    public int balance;
    public Point point;
    
    public AvlNode() {}

    public AvlNode(int key) {
        left=null;
        right=null;
        parent=null;
        this.key=key;
    }
    
    @Override
    public String toString() {return " [key = "+key+" [left = "+left+", right = "+right+"]]";}

}
