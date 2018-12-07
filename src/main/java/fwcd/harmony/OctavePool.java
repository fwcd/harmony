package fwcd.harmony;

import fwcd.harmony.utils.IntRange;

public class OctavePool {
	private final OctaveIndex[] octaves;
	private final int firstOctaveSpnIndex;

	public OctavePool(int startSpnIndex, int endSpnIndex) {
		firstOctaveSpnIndex = startSpnIndex;
		octaves = new IntRange(startSpnIndex, endSpnIndex + 1)
				.mapToObj(OctaveIndex::new)
				.toArray(OctaveIndex[]::new);
	}

	public OctaveIndex get(int spnIndex) {
		int arrIndex = spnIndex - firstOctaveSpnIndex;
		if (arrIndex >= 0 && arrIndex < octaves.length) {
			return octaves[arrIndex];
		} else {
			return new OctaveIndex(spnIndex);
		}
	}
}
