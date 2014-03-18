package AvlTree;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Class responsible for drawing frame with AVL tree.
 *
 * @author Gnylorybov Evgeniy
 */
public class AvlFrame extends javax.swing.JFrame {
    
    private static AvlFrame generalFrame = new AvlFrame();
    private static AvlTree tree = new AvlTree();
    private static final int SIDE_EXTERNAL_SQUARE = 54;
    private static final int SIDE_SQUARE = 50;

    public AvlFrame() {
        initComponents();
        setVisible(true);
        setLocation(50, 50);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuPanel = new javax.swing.JPanel();
        inputValue = new javax.swing.JTextField();
        addNode = new javax.swing.JButton();
        inputLabel = new javax.swing.JLabel();
        deleteNode = new javax.swing.JButton();
        outputMsg = new javax.swing.JLabel();
        visualPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTree = new javax.swing.JTextArea();
        deleteTree = new javax.swing.JButton();
        reDrawTree = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AVL Tree");
        setBackground(new java.awt.Color(204, 204, 204));
        setName("AVL Tree"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowDeiconified(java.awt.event.WindowEvent evt) {
                formWindowDeiconified(evt);
            }
        });

        inputValue.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        inputValue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        addNode.setText("Add Node");
        addNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNodeActionPerformed(evt);
            }
        });

        inputLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        inputLabel.setText("Enter value:");

        deleteNode.setText("Delete Node");
        deleteNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteNodeActionPerformed(evt);
            }
        });

        outputMsg.setBackground(new java.awt.Color(255, 255, 255));
        outputMsg.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        outputMsg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addComponent(inputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputValue, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addNode, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteNode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(outputMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addNode)
                        .addComponent(inputValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(inputLabel)
                        .addComponent(deleteNode))
                    .addComponent(outputMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        visualPanel.setBackground(new java.awt.Color(255, 255, 255));
        visualPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        visualPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        visualPanel.setPreferredSize(new java.awt.Dimension(50, 50));

        outputTree.setColumns(20);
        outputTree.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        outputTree.setRows(1);
        jScrollPane1.setViewportView(outputTree);

        javax.swing.GroupLayout visualPanelLayout = new javax.swing.GroupLayout(visualPanel);
        visualPanel.setLayout(visualPanelLayout);
        visualPanelLayout.setHorizontalGroup(
            visualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visualPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        visualPanelLayout.setVerticalGroup(
            visualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, visualPanelLayout.createSequentialGroup()
                .addContainerGap(310, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        deleteTree.setText("Delete Tree");
        deleteTree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTreeActionPerformed(evt);
            }
        });

        reDrawTree.setText("ReDrawTree");
        reDrawTree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reDrawTreeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(visualPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addComponent(MenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reDrawTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(visualPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reDrawTree)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteTree)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**Button is responsible for adding nodes.*/
    private void addNodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNodeActionPerformed
        try {
            int key = Integer.parseInt(inputValue.getText());
            tree.add(key);
            outputTree.setText(tree.toString());
            outputMsg.setText(AvlTree.getMsg());
        }
        catch(NumberFormatException ex) {outputMsg.setText(" Incorrect format of value");}
    }//GEN-LAST:event_addNodeActionPerformed

    /**Button is responsible for removing nodes.*/
    private void deleteNodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteNodeActionPerformed
        try {
            int valueIn = Integer.parseInt(this.inputValue.getText());
            tree.remove(valueIn);
            outputTree.setText(tree.toString());
            outputMsg.setText(AvlTree.getMsg());
        }
        catch(NumberFormatException ex) {outputMsg.setText(" Incorrect format of value");}
    }//GEN-LAST:event_deleteNodeActionPerformed

    /**Button is responsible for removing tree.*/
    private void deleteTreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTreeActionPerformed
        delateTree();
        outputTree.setText("");
    }//GEN-LAST:event_deleteTreeActionPerformed

    private void formWindowDeiconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeiconified
        outputMsg.setText(" Auto redrawing not work, please press ReDrawTree.");
        /*reDrawTree(tree.getRoot());*/ //TODO: not work
    }//GEN-LAST:event_formWindowDeiconified

    /**Button is responsible for redrawing tree.*/
    private void reDrawTreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reDrawTreeActionPerformed
        reDrawTree(tree.getRoot());
    }//GEN-LAST:event_reDrawTreeActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                getFrame();
            }
        });
    }
    
    private static AvlFrame getFrame() {return generalFrame;}
    
    /**Method is responsible for redrawing tree.
     * 
     * @param  node 
     *          node which will be drawn
     * 
     */
    private static void reDrawTree(AvlNode node) {
        if(node == null) {return;}
        drawSquare(node);
        if(node.left != null) {
            drawLine(node, node.left);
            drawSquare(node);
            reDrawTree(node.left);
        }
        if(node.right != null) {
            drawLine(node, node.right);
            drawSquare(node);
            reDrawTree(node.right);
        }
    }
    
    /**Method is responsible for drawing square.
     * 
     * @param  node 
     *          node which will be drawn
     * 
     */
    public static void drawSquare(AvlNode node) {
        if(node == null) {return;}
        Graphics2D gr = (Graphics2D)generalFrame.getGraphics();
        gr.setColor(Color.BLACK);
        gr.fillRect(
            node.point.x - SIDE_EXTERNAL_SQUARE/2,
            node.point.y - SIDE_EXTERNAL_SQUARE/2,
            SIDE_EXTERNAL_SQUARE,
            SIDE_EXTERNAL_SQUARE);
        if(AvlTree.getList().indexOf(node) == AvlTree.getList().size()-1) {
            gr.setColor(Color.GREEN);
        }
        else {gr.setColor(Color.RED);}
        gr.fillRect(
            node.point.x - SIDE_SQUARE/2,
            node.point.y - SIDE_SQUARE/2,
            SIDE_SQUARE,
            SIDE_SQUARE);
        gr.setColor(Color.BLACK);
        gr.setFont(new java.awt.Font("Times New Roman", 1, 14));
        int strLength = new Integer(node.key).toString().length();
        for(int i = 1; i <= new Integer(Integer.MAX_VALUE).toString().length()+1; i++) {
            if(strLength==i) {
                if(i > 7) {
                    gr.setFont(new java.awt.Font("Times New Roman", 1, 10));
                    gr.drawString(
                            "" + node.key,
                            node.point.x - 3 - i * 2,
                            node.point.y + 3);
                }
                else {gr.drawString(
                        "" + node.key,
                        node.point.x - 3 - i * 3,
                        node.point.y + 5);}
            }
        }
    }
    
    /**Method is responsible for cleaning square.
     * 
     * @param  node 
     *          node which will be clean
     * 
     */
    public static void cleanSquare(AvlNode node) {
        if(node == null) {return;}
        Graphics2D gr = (Graphics2D)AvlFrame.getFrame().getGraphics();
        gr.setColor(Color.WHITE);
        gr.fillRect(
            node.point.x - SIDE_EXTERNAL_SQUARE/2,
            node.point.y - SIDE_EXTERNAL_SQUARE/2,
            SIDE_EXTERNAL_SQUARE,
            SIDE_EXTERNAL_SQUARE);
    }
    
    /**Method of connecting nodes line.
     * 
     * @param  nodeFirst 
     *          now connects nodes
     * @param  nodeSecond 
     *          now connects nodes
     * 
     */
    public static void drawLine(AvlNode nodeFirst, AvlNode nodeSecond) {
        Graphics2D gr = (Graphics2D)getFrame().getGraphics();
        gr.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f));
        gr.drawLine(nodeFirst.point.x, nodeFirst.point.y, nodeSecond.point.x, nodeSecond.point.y);
    }
    
    /**Method of erasing the line now connects nodes.
     * 
     * @param  nodeFirst 
     *          now connects nodes
     * @param  nodeSecond 
     *          now connects nodes
     * 
     */
    public static void cleanLine(AvlNode nodeFirst, AvlNode nodeSecond) {
        Graphics2D gr = (Graphics2D)getFrame().getGraphics();
        gr.setColor(Color.WHITE);
        gr.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f));
        gr.drawLine(nodeFirst.point.x, nodeFirst.point.y, nodeSecond.point.x, nodeSecond.point.y);
    }
    
    /**Method is responsible for removing tree.*/
    private static void delateTree() {
        tree = new AvlTree();
        Graphics2D gr = (Graphics2D)getFrame().getGraphics();
        gr.setColor(Color.WHITE);
        gr.fillRect(16, 70, 767, 403);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JButton addNode;
    private javax.swing.JButton deleteNode;
    private javax.swing.JButton deleteTree;
    private javax.swing.JLabel inputLabel;
    private javax.swing.JTextField inputValue;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel outputMsg;
    private javax.swing.JTextArea outputTree;
    private javax.swing.JButton reDrawTree;
    private javax.swing.JPanel visualPanel;
    // End of variables declaration//GEN-END:variables
}
