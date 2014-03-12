package AvlTree;

import java.awt.Color;
import java.awt.Point;

/**
 * This class is responsible for the mechanics of AVL tree.
 *
 * @author Gnylorybov Evgeniy
 */
public class AvlTree {
    
    private AvlNode root; 
    private static final Point START_COORDINATES = new Point(395, 125);
    private static final int STEP_BY_X = 40;
    private static final int STEP_BY_Y = 80;
    private static final int BIG_STEP_BY_X = 90;
    
    /**This string contains a message about successful or not successful,
     * adding or removing a node.*/
    private static String msg = "";
  
    protected static String getMsg() {return msg;}
    
    protected AvlNode getRoot() {return root;}
    
    /**Method is responsible for creating a node.
     * Invokes a method to add a node.
     * Invokes the automatic adjustment width wood.
     * 
     * @param  key 
     *          value stored in the node
     */
    public void add(int key) {
        AvlNode node = new AvlNode(key);
        node.isNew = true;
        addToAvlTree(root, node);
        extendTree(root);
    }
    
    /**Method is responsible for the automatic expansion and
     * contraction of tree in horizontal.
     * 
     * @param  node 
     *          node for which it is checked whether expansion or contraction
     * 
     */
    private void extendTree(AvlNode node) {
        if(node == null) {return;}
        if(node.left != null && node.right != null) {
            if(node.left.left !=null ||
                    node.left.right != null ||
                    node.right.left != null ||
                    node.right.right != null) {
                cleanTree(node);
                if(node != root) {
                    if(node.parent.right == node) {
                        AvlFrame.cleanSquare(node);
                        AvlFrame.cleanLine(node.parent, node);
                        node.point = new Point(
                                node.point.x + BIG_STEP_BY_X,
                                node.point.y);
                        AvlFrame.drawLine(node.parent, node);
                        AvlFrame.drawSquare(node.parent);
                        AvlFrame.drawSquare(node);
                    }
                    if(node.parent.left == node) {
                        AvlFrame.cleanSquare(node);
                        AvlFrame.cleanLine(node.parent, node);
                        node.point = new Point(
                                node.point.x - BIG_STEP_BY_X,
                                node.point.y);
                        AvlFrame.drawLine(node.parent, node);
                        AvlFrame.drawSquare(node.parent);
                        AvlFrame.drawSquare(node);
                    }
                }
                node.left.point = new Point(
                        node.point.x - BIG_STEP_BY_X,
                        node.left.point.y);
                node.right.point = new Point(
                        node.point.x + BIG_STEP_BY_X,
                        node.right.point.y);
                AvlFrame.drawLine(node, node.left);
                AvlFrame.drawLine(node, node.right);
                AvlFrame.drawSquare(node.left);
                AvlFrame.drawSquare(node.right);
                AvlFrame.drawSquare(node);
                drawTree(node.left);
                drawTree(node.right);
                extendTree(node.left);
                extendTree(node.right);
                if(root.left != null) {
                    AvlFrame.drawLine(root, root.left);
                    AvlFrame.drawSquare(root.left);
                }
                if(root.right != null) {
                    AvlFrame.drawLine(root, root.right);
                    AvlFrame.drawSquare(root.right);
                }
                AvlFrame.drawSquare(root);
            }
        }
    }
    
    /**Method is responsible for cleaning tree.
     * 
     * @param  node 
     *          node whose descendants are cleared
     * 
     */
    private void cleanTree(AvlNode node) {
        if(node == null) {return;}
        if(node.nodeColor == Color.GREEN) {node.isNew = true;}
        if(node.left != null) {
            AvlFrame.cleanSquare(node.left);
            AvlFrame.cleanLine(node, node.left);
        }
        if(node.right != null) {
            AvlFrame.cleanSquare(node.right);
            AvlFrame.cleanLine(node, node.right);
        }
        cleanTree(node.left);
        cleanTree(node.right);
    }
    
    /**Method is responsible for drawing the tree.
     * 
     * @param  node 
     *          node whose successors are drawn
     * 
     */
    private void drawTree(AvlNode node) {
        if(node == null) {return;}
        if(node.left != null && node.left != root.left) {
            node.left.point = new Point(
                    node.left.parent.point.x - STEP_BY_X,
                    node.left.parent.point.y + STEP_BY_Y);
            AvlFrame.drawLine(node, node.left);
            AvlFrame.drawSquare(node);
            AvlFrame.drawSquare(node.left);
        }
        if(node.right != null && node.right != root.right) {
            node.right.point = new Point(
                    node.right.parent.point.x + STEP_BY_X,
                    node.right.parent.point.y + STEP_BY_Y);
            AvlFrame.drawLine(node, node.right);
            AvlFrame.drawSquare(node);
            AvlFrame.drawSquare(node.right);
        }
        drawTree(node.left);
        drawTree(node.right);
    }
    
    /**Method is responsible for adding a node to the tree.
     * 
     * @param  nodeNew 
     *          node is added
     * @param  currentRoot 
     *          node to which is added
     */
    private void addToAvlTree(AvlNode currentRoot, AvlNode nodeNew) {
        if(root == null) {
            root = nodeNew;
            msg = " " + nodeNew.key + " Added";
            nodeNew.point = START_COORDINATES;
            AvlFrame.drawSquare(nodeNew);
        }
        else {
            if(currentRoot.key == nodeNew.key) {msg = " Node already exist.";}
            else {
                msg = " " + nodeNew.key + " Added";
                if(nodeNew.key < currentRoot.key) {
                    if(currentRoot.left == null) {
                        currentRoot.left = nodeNew;
                        nodeNew.parent = currentRoot;
                        nodeNew.point = new Point(
                                currentRoot.point.x - STEP_BY_X,
                                currentRoot.point.y + STEP_BY_Y);
                        recursiveBalance(currentRoot);
                    } 
                    else {
                        addToAvlTree(currentRoot.left, nodeNew);
                    }
                } 
                else {
                    if(currentRoot.right == null) {
                        currentRoot.right = nodeNew;
                        nodeNew.parent = currentRoot;
                        nodeNew.point = new Point(
                                currentRoot.point.x + STEP_BY_X,
                                currentRoot.point.y + STEP_BY_Y);
                        recursiveBalance(currentRoot);
                    }
                    else {
                        addToAvlTree(currentRoot.right, nodeNew);
                    }
                } 
            }
        }
    }
 
    /**Method is responsible for balancing the tree.
     * 
     * @param  current 
     *          node at which it is checked whether the balance
     * 
     */
    private void recursiveBalance(AvlNode current) {
        setBalance(current);
        int balance = current.balance;
        if(balance == -2) {
            if(height(current.left.left) >= height(current.left.right)) {
                current = rotateRight(current);
            }
            else {current = doubleRotateLeftRight(current);}
        }
        else {
            if(balance == 2) {
                if(height(current.right.right) >= height(current.right.left)) {
                    current = rotateLeft(current);
                }
                else {
                    current = doubleRotateRightLeft(current);
                }
            }
        }
        if(current.parent != null) {recursiveBalance(current.parent);}
        else {
            root = current;
            AvlFrame.cleanSquare(current);
            if(current.left != null) {AvlFrame.cleanLine(current, current.left);}
            if(current.right != null) {AvlFrame.cleanLine(current, current.right);}
            current.point = START_COORDINATES;
            if(current.left != null) {
                AvlFrame.drawLine(current, current.left);
                AvlFrame.drawSquare(current.left);
            }
            if(current.right != null) {
                AvlFrame.drawLine(current, current.right);
                AvlFrame.drawSquare(current.right);
            }
            AvlFrame.drawSquare(current);
        }
    }
    
    /**Method of measuring the maximum depth of the node.
     * 
     * @param  current 
     *          node whose depth is measured
     * @return The max depth of node current.
     * 
     */
    private int height(AvlNode current) {
        if(current == null) {return -1;}
        if(current.left == null && current.right == null) {return 0;}
        else {
            if(current.left==null) {return 1 + height(current.right);}
            else {
                if(current.right==null) {return 1 + height(current.left);}
                else {return 1 + Math.max(height(current.left), height(current.right));}
            }
        }
    }
 
    /**Method sets the balance node.
     * 
     * @param  current 
     *          node which is set to balance
     * 
     */
    private void setBalance(AvlNode current) {
        current.balance = height(current.right) - height(current.left);
    }
    
    /**Method that calls methods of searching the deleted node and
     * adjusting the width of the tree.
     * 
     * @param  key 
     *          the value stored in the node to be removed
     * 
     */
    public void remove(int key) {
        removeAvlNode(root,key);
        extendTree(root);
    }

    /**Method of finding the deleted node.
     * 
     * @param  key 
     *          the value stored in the node to be removed
     * @param  node 
     *          node checks on the content value to be deleted
     * 
     */
    private void removeAvlNode(AvlNode node,int key) {
        if(node == null) {msg = " Node not exist.";}
        else {
            msg = " " + key + " Removed";
            if(node.key == key) {removeFoundNode(node);}
            else {
                if(node.key > key)  {removeAvlNode(node.left,key);}
                else {removeAvlNode(node.right,key);}
            }
        }
    }

    /**Method is responsible for removing a node.
     * 
     * @param  nodeDetected 
     *          deleted node
     * 
     */
    public void removeFoundNode(AvlNode nodeDetected) {
        AvlNode nodeTmp1;
        if(nodeDetected.left == null || nodeDetected.right == null) {
            if(nodeDetected.left == null && nodeDetected.right == null) {
                if(nodeDetected.parent == null) {
                    AvlFrame.cleanSquare(nodeDetected);
                    root = null;
                    nodeDetected = null;
                    return;
                }
            }
            nodeTmp1 = nodeDetected;
        } 
        else {
            nodeTmp1 = successor(nodeDetected);
            nodeDetected.key = nodeTmp1.key;
        }
        AvlNode nodeTmp2;
        if(nodeTmp1.left != null) {nodeTmp2 = nodeTmp1.left;}
        else {nodeTmp2 = nodeTmp1.right;}
        if(nodeTmp2 != null) {nodeTmp2.parent = nodeTmp1.parent;}
        if(nodeTmp1.parent == null) {
            AvlFrame.cleanSquare(nodeTmp1);
            AvlFrame.cleanSquare(nodeTmp2);
            AvlFrame.cleanLine(nodeTmp1, nodeTmp2);
            root = nodeTmp2;
            nodeTmp2.point = START_COORDINATES;
            AvlFrame.drawSquare(nodeTmp2);
        }
        else {
            if(nodeTmp1 == nodeTmp1.parent.left) {
                if(nodeTmp2 == null) {
                    AvlFrame.cleanSquare(nodeTmp1);
                    AvlFrame.cleanLine(nodeTmp1, nodeTmp1.parent);
                    AvlFrame.drawSquare(nodeTmp1.parent);
                }
                else {
                    AvlFrame.cleanLine(nodeTmp1.parent, nodeTmp1);
                    AvlFrame.cleanLine(nodeTmp1, nodeTmp2);
                    AvlFrame.cleanSquare(nodeTmp1);
                    AvlFrame.cleanSquare(nodeTmp2);
                    nodeTmp2.point = new Point(
                            nodeTmp1.point.x,
                            nodeTmp1.point.y);
                    AvlFrame.drawLine(nodeTmp1.parent, nodeTmp2);
                    AvlFrame.drawSquare(nodeTmp1.parent);
                    AvlFrame.drawSquare(nodeTmp2);
                }
                nodeTmp1.parent.left = nodeTmp2;
            }
            else {
                if(nodeTmp2 == null) {
                    AvlFrame.cleanSquare(nodeTmp1);
                    AvlFrame.cleanLine(nodeTmp1, nodeTmp1.parent);
                    AvlFrame.drawSquare(nodeTmp1.parent);
                }
                else {
                    AvlFrame.cleanLine(nodeTmp1.parent, nodeTmp1);
                    AvlFrame.cleanLine(nodeTmp1, nodeTmp2);
                    AvlFrame.cleanSquare(nodeTmp1);
                    AvlFrame.cleanSquare(nodeTmp2);
                    nodeTmp2.point = new Point(
                            nodeTmp1.point.x,
                            nodeTmp1.point.y);
                    AvlFrame.drawLine(nodeTmp1.parent, nodeTmp2);
                    AvlFrame.drawSquare(nodeTmp1.parent);
                    AvlFrame.drawSquare(nodeTmp2);
                }
                nodeTmp1.parent.right = nodeTmp2;
            }
            recursiveBalance(nodeTmp1.parent);
        }
    }
     
    /**Method returns the successor of a given node in the tree.
    * 
    * @param nodeIncomer 
    *         the predecessor
    * @return The successor of node nodeIncomer.
    *
    */
    public AvlNode successor(AvlNode nodeIncomer) {
        if(nodeIncomer.right != null) {
            AvlNode nodeTmp1 = nodeIncomer.right;
            while(nodeTmp1.left != null) {
                nodeTmp1 = nodeTmp1.left;
            }
            return nodeTmp1;
        }
        else {
            AvlNode nodeTmp2 = nodeIncomer.parent;
            while(nodeTmp2 != null && nodeIncomer == nodeTmp2.right) {
                nodeIncomer = nodeTmp2;
                nodeTmp2 = nodeIncomer.parent;
            }
            return nodeTmp2;
        }     
    }
    
    /**Method rotatable part of the tree to the left.
     * 
     * @param  current 
     *          top node of the rotatable part
     * @return The root of the new rotated tree.
     * 
     */
      private AvlNode rotateLeft(AvlNode current) {
        AvlFrame.cleanSquare(current);
        AvlFrame.cleanSquare(current.right);
        AvlFrame.cleanLine(current, current.right);
        if(current.right.right != null) {
            AvlFrame.cleanSquare(current.right.right);
            AvlFrame.cleanLine(current.right, current.right.right);
            if(current.right.right.right != null) {
                AvlFrame.cleanLine(current.right.right, current.right.right.right);
            }
            if(current.right.right.left != null) {
                AvlFrame.cleanLine(current.right.right, current.right.right.left);
            }
        }
        AvlNode result = current.right;
        result.parent = current.parent;
        current.right = result.left;
        if(result.left != null) {
            AvlFrame.cleanLine(result, result.left);
            AvlFrame.cleanSquare(result.left);
            if(result.left.left != null) {
                AvlFrame.cleanLine(result.left.left, result.left);
            }
            if(result.left.right != null) {
                AvlFrame.cleanLine(result.left.right, result.left);
            }
        }
        current.point = new Point(
                current.point.x - STEP_BY_X,
                current.point.y + STEP_BY_Y);
        result.point = new Point(
                current.point.x + STEP_BY_X,
                current.point.y - STEP_BY_Y);
        if(result.right != null) {
            result.right.point = new Point(
                    result.right.point.x - STEP_BY_X,
                    result.right.point.y - STEP_BY_Y);
        }
        AvlFrame.drawLine(current, result);
        if(current.right != null) {
            current.right.parent = current;
            current.right.point = new Point(
                    current.point.x + STEP_BY_X,
                    current.point.y + STEP_BY_Y);
        }
        result.left = current;
        current.parent = result;
        if(result.parent != null) {
            if(result.parent.right == current) {result.parent.right = result;}
            else {
                if(result.parent.left == current) {result.parent.left = result;}
            }
        }
        return result;
    }
    
    /**Method rotatable part of the tree to the right.
     * 
     * @param  current 
     *          top node of the rotatable part
     * @return The root of the new rotated tree.
     * 
     */
    private AvlNode rotateRight(AvlNode current) {
        AvlFrame.cleanSquare(current);
        AvlFrame.cleanSquare(current.left);
        AvlFrame.cleanLine(current, current.left);
        if(current.left.left != null) {
            AvlFrame.cleanSquare(current.left.left);
            AvlFrame.cleanLine(current.left, current.left.left);
            if(current.left.left.left != null) {
                AvlFrame.cleanSquare(current.left.left.left);
                AvlFrame.cleanLine(current.left.left, current.left.left.left);
            }
            if(current.left.left.right != null) {
                AvlFrame.cleanSquare(current.left.left.right);
                AvlFrame.cleanLine(current.left.left, current.left.left.right);
            }
        }
        if(current.left.right != null) {
            AvlFrame.cleanSquare(current.left.right);
            AvlFrame.cleanLine(current.left, current.left.right);
            if(current.left.right.left != null) {
                AvlFrame.cleanSquare(current.left.right.left);
                AvlFrame.cleanLine(current.left.right, current.left.right.left);
            }
            if(current.left.right.right != null) {
                AvlFrame.cleanSquare(current.left.right.right);
                AvlFrame.cleanLine(current.left.right, current.left.right.right);
            }
        }
        AvlNode result = current.left;
        result.parent = current.parent;
        current.left = result.right;
        if(current.right != null) {
            current.point = new Point(
                current.right.point.x,
                current.right.point.y);
            current.right.point = new Point(
                    current.point.x + STEP_BY_X,
                    current.point.y + STEP_BY_Y);
        }
        else {
            current.point = new Point(
                current.point.x + STEP_BY_X,
                current.point.y + STEP_BY_Y);
        }
        result.point = new Point(
                current.point.x - STEP_BY_X,
                current.point.y - STEP_BY_Y);
        if(result.left != null) {
                result.left.point = new Point(
                result.left.point.x + STEP_BY_X,
                result.left.point.y - STEP_BY_Y);
        }
        if(current.left != null) {
            current.left.parent = current;
            current.left.point = new Point(
                    current.left.parent.point.x - STEP_BY_X,
                    current.left.parent.point.y + STEP_BY_Y);
        }
        result.right = current;
        current.parent = result;
        if(result.parent != null) {
            if(result.parent.right == current) {result.parent.right = result;}
            else {
                if(result.parent.left == current) {result.parent.left = result;}
            }
        }
        return result;
    }
    
    /**
    * 
    * @param current
    *           the node for the rotation
    * @return The root after the double rotation.
    */
    private AvlNode doubleRotateLeftRight(AvlNode current) {
        current.left = rotateLeft(current.left);
        return rotateRight(current);
    }

    /**
    * 
    * @param current
    *           the node for the rotation
    * @return The root after the double rotation.
    */
    private AvlNode doubleRotateRightLeft(AvlNode current) {
        current.right = rotateRight(current.right);
        return rotateLeft(current);
    }
    
    @Override
    public String toString() {
        if(root == null) {return "";}
        return "AvlTree: " + root;
    }
  
}
