package fwcd.harmony.utils;

import java.util.List;

@FunctionalInterface
public interface Chooser<T> {
	T chooseFrom(List<T> list);
}
