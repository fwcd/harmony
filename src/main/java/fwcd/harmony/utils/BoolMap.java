package fwcd.harmony.utils;

public class BoolMap<V> {
	private V whenFalse = null;
	private V whenTrue = null;

	public void put(boolean key, V value) {
		if (key) {
			whenTrue = value;
		} else {
			whenFalse = value;
		}
	}

	public boolean containsKey(boolean key) {
		return get(key) != null;
	}

	public boolean containsValue(V value) {
		return whenTrue.equals(value) || whenFalse.equals(value);
	}

	public V get(boolean key) {
		return key ? whenTrue : whenFalse;
	}

	public void putIfAbsent(boolean key, V value) {
		if (!containsKey(key)) {
			put(key, value);
		}
	}
}
