package it.unibo.es2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LogicsImpl implements Logics{

    private List<List<Boolean>> griglia;

    public LogicsImpl(final int size) {
        if(size < 0) {
            throw new IllegalArgumentException();
        }
        this.griglia = new ArrayList<>();
        for(int i=0; i<size; i++) {
            final List<Boolean> row = new ArrayList<>();
            this.griglia.add(row);
            for(int j=0; j<size; j++) {
                row.add(false);
            }
        }
    }

    private Boolean get(int row, int column) {
        return this.griglia.get(row).get(column);
    }

    @Override
    public Boolean hit(final int row, final int column) {
        final boolean newValue = !this.get(row, column);
        this.griglia.get(row).set(column, newValue);
        return newValue;
    }

    @Override
    public Boolean fullRows() {
        return this.griglia.stream().anyMatch(l -> l.stream().allMatch(b -> b));
    }

    @Override
    public Boolean fullCols() {
        return IntStream.range(0, this.griglia.size()-1)
            .anyMatch(i -> this.griglia.stream().allMatch(l -> l.get(i)));
    }

}
