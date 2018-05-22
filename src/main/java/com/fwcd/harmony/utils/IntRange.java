package com.fwcd.harmony.utils;

import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntRange {
	private final int inclusiveStart;
	private final int exclusiveEnd;

	public IntRange(int inclusiveStart, int exclusiveEnd) {
		this.inclusiveStart = inclusiveStart;
		this.exclusiveEnd = exclusiveEnd;
	}

	public int getInclusiveStart() { return inclusiveStart; }

	public int getExclusiveEnd() { return exclusiveEnd; }

	public int getLength() { return exclusiveEnd - inclusiveStart; }

	public int[] toArray() {
		int[] arr = new int[getLength()];
		Arrays.setAll(arr, i -> i + inclusiveStart);
		return arr;
	}

	public IntStream stream() {
		return Arrays.stream(toArray());
	}

	public IntStream map(IntUnaryOperator mapper) {
		return stream().map(mapper);
	}

	public <T> Stream<T> mapToObj(IntFunction<T> mapper) {
		return stream().mapToObj(mapper);
	}
}