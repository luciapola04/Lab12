package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {
	private List<Integer> list;

	public LogicsImpl(int size) {
		if(size <= 0) {
			throw new IllegalArgumentException();
		}
		this.list = new ArrayList<>(Collections.nCopies(size, 0));
	}

	@Override
	public int size() {
		return this.list.size();
	}

	@Override
	public List<Integer> values() {
		return this.list;
	}

	@Override
	public List<Boolean> enablings() {
		return list.stream()
			.map(e -> e < this.list.size())
			.collect(Collectors.toList());
	}

	@Override
	public int hit(int elem) {
		this.list.set(elem, list.get(elem)+1);
		return this.list.get(elem);
	}

	@Override
	public String result() {
		return list.stream()
			.map(Object::toString)
			.collect(Collectors.joining("|", "<<", ">>"));
	}

	@Override
	public boolean toQuit() {
		return this.list.stream().allMatch(e -> e == this.list.get(0));
	}
}
