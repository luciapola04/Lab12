package it.unibo.es3;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LogicsImpl implements Logics{

    private final int size;
    private Random rnd = new Random();
    private Set<Pair<Integer, Integer>> set = new HashSet<>();

    public LogicsImpl(int size) {
        if(size < 0) {
            throw new IllegalArgumentException();
        }
        this.size = size;
        while(set.size() < 3) {
            this.set.add(new Pair<Integer,Integer>(rnd.nextInt(this.size), rnd.nextInt(this.size)));
        }
    }

    @Override
    public boolean isClose(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
        return !p1.equals(p2) 
            && Math.abs(p1.getX() - p2.getX()) <= 1 
            && Math.abs(p1.getY() - p2.getY()) <= 1;
    }

    @Override
    public void hit() {
        Set<Pair<Integer, Integer>> updatedSet = new HashSet<>();
        for(int i=0; i<this.size; i++) {
            for(int j=0; j<this.size; j++) {
                Pair<Integer, Integer> newP = new Pair<Integer,Integer>(i, j);
                if(this.set.stream().anyMatch(p -> isClose(p, newP))) {
                    updatedSet.add(newP);
                }
            }
        }
        this.set.addAll(updatedSet);
    }
    
    @Override
    public Set<Pair<Integer, Integer>> getPos() {
        return this.set;
    }

    @Override
    public boolean toQuit() {
        return this.set.size() == this.size * this.size;
    }
}

