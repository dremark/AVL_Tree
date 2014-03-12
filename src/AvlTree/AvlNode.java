package AvlTree;

import java.awt.Color;
import java.awt.Point;

/**
 * Entity class node AVL tree.
 *
 * @author Gnylorybov Evgeniy
 */
public class AvlNode {
    protected AvlNode left;
    protected AvlNode right;
    protected AvlNode parent;
    protected int key;
    protected int balance;
    protected Point point;
    protected boolean isNew = false;
    protected Color nodeColor;
    
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
