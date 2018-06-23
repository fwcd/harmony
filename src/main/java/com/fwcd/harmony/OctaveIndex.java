package com.fwcd.harmony;

public class OctaveIndex {
	private static final OctavePool pool = new OctavePool(0, 6);
	public static final OctaveIndex ZERO = pool.get(0);
	public static final OctaveIndex SUB_CONTRA = ZERO; // C0
	public static final OctaveIndex CONTRA = pool.get(1); // C1
	public static final OctaveIndex GREAT = pool.get(2); // C2
	public static final OctaveIndex SMALL = pool.get(3); // C3
	public static final OctaveIndex ONE_LINED = pool.get(4); // C4
	public static final OctaveIndex TWO_LINED = pool.get(5); // C5
	public static final OctaveIndex THREE_LINED = pool.get(6); // C6

	private final int spnIndex; // Index in scientific pitch notation

	public static OctaveIndex nr(int spnIndex) {
		return pool.get(spnIndex);
	}

	OctaveIndex(int spnIndex) {
		this.spnIndex = spnIndex;
	}

	public OctaveIndex plus(int octaves) {
		return pool.get(spnIndex + octaves);
	}

	public OctaveIndex down() { return plus(-1); }

	public OctaveIndex up() { return plus(1); }

	public int getSpnIndex() { return spnIndex; }

	@Override
	public boolean equals(Object obj) {
		return spnIndex == ((OctaveIndex) obj).spnIndex;
	}

	@Override
	public String toString() {
		return "Octave C" + spnIndex;
	}
}
