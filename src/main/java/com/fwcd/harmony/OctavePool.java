package com.fwcd.harmony;

import com.fwcd.harmony.utils.IntRange;

public class OctavePool {
	private final Octave[] octaves;
	private final int firstOctaveSpnIndex;

	public OctavePool(int startSpnIndex, int endSpnIndex) {
		firstOctaveSpnIndex = startSpnIndex;
		octaves = new IntRange(startSpnIndex, endSpnIndex + 1)
				.mapToObj(Octave::new)
				.toArray(Octave[]::new);
	}

	public Octave get(int spnIndex) {
		int arrIndex = spnIndex - firstOctaveSpnIndex;
		if (arrIndex >= 0 && arrIndex < octaves.length) {
			return octaves[arrIndex];
		} else {
			return new Octave(spnIndex);
		}
	}
}
