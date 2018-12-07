package fwcd.harmony.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * A lazily initialized immutable reference.
 */
public final class Lazy<T> {
	private Supplier<T> supplier;
	private T value;

	private Lazy(T value) {
		this.supplier = null;
		this.value = value;
	}

	private Lazy(Supplier<T> supplier) {
		this.supplier = supplier;
		this.value = null;
	}

	public static <T> Lazy<T> of(Supplier<T> supplier) { return new Lazy<>(supplier); }

	public static <T> Lazy<T> literal(T literal) { return new Lazy<>(literal); }

	@SafeVarargs
	public static <T> Lazy<List<T>> literalList(T... literals) { return literal(Arrays.asList(literals)); }

	@SafeVarargs
	public static <T> Lazy<Set<T>> literalSet(T... literals) { return literal(Arrays.stream(literals).collect(Collectors.toSet())); }

	@SafeVarargs
	public static <T> Lazy<List<T>> list(Supplier<T>... suppliers) {
		return of(() -> Arrays.stream(suppliers)
			.map(Supplier::get)
			.collect(Collectors.toList())
		);
	}

	@SafeVarargs
	public static <T> Lazy<Set<T>> set(Supplier<T>... suppliers) {
		return of(() -> Arrays.stream(suppliers)
			.map(Supplier::get)
			.collect(Collectors.toSet())
		);
	}

	public T get() {
		if (value == null) {
			value = supplier.get();
		}

		return value;
	}
}
