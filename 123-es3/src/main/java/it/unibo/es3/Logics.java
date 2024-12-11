package it.unibo.es3;

import java.util.Set;
/**
* The interface of the View's controller
* */
public interface Logics {


    /**
     * @param p1
     * @param p2
     * @return true if p1 and p2 are neighbours, false otherwise 
     */
    boolean isClose(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2);

    /**
     * 
     */
    void hit();

    /**
     * @return a set which contains the cells with *
     */
    Set<Pair<Integer, Integer>> getPos();


    /**
     * @return true if ALL the cells of the grid contains *, false otherwise 
     */
    boolean toQuit();
}
