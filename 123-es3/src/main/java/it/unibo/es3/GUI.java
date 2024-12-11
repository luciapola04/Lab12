package it.unibo.es3;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GUI extends JFrame {
    
    private final Map<JButton, Pair<Integer, Integer>> griglia = new HashMap<>();
    private final Logics logics;
    
    /**
     * GUI's constructor.
     * @param size the size of the grid
     */
    public GUI(int size) {
        this.logics = new LogicsImpl(size);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*size, 70*size);
        
        JPanel panel = new JPanel(new GridLayout(size,size));
        this.getContentPane().add(panel, BorderLayout.CENTER);
        JPanel panel2 = new JPanel(new BorderLayout());
        final JButton button = new JButton(">");
        panel2.add(button);
        this.getContentPane().add(panel2, BorderLayout.SOUTH); 
        /**
        * Helper
        */
        button.addActionListener(e -> {
            logics.hit();
            this.refreshView();
            if(logics.toQuit()) {
                System.exit(0);
            }
        });
             
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                final JButton jb = new JButton(" ");
                this.griglia.put(jb,new Pair<>(i,j));
                panel.add(jb);
            }
        }
        this.refreshView();
        this.setVisible(true);
    }

    /**
     * Method for updating the grid
     */
    private void refreshView() {
        Set<Pair<Integer, Integer>> set = logics.getPos();
        griglia.forEach((jb, p) -> jb.setText(set.contains(p) ? "*" : ""));
    }
}