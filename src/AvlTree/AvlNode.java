package AvlTree;

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
    
    public AvlNode() {}

    public AvlNode(int key) {
        left=null;
        right=null;
        parent=null;
        this.key=key;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof AvlNode == false) {return false;}
        AvlNode tmp = (AvlNode)obj;
        if(this.key == tmp.key) {return true;}
        return false;
    }
    
    @Override
    public String toString() {return " [key = "+key+" [left = "+left+", right = "+right+"]]";}

}
