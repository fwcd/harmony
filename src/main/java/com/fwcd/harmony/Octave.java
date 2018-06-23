package com.fwcd.harmony;

public class Octave {
	private static final OctavePool pool = new OctavePool(0, 6);
	public static final Octave SUB_CONTRA = pool.get(0); // C0
	public static final Octave CONTRA = pool.get(1); // C1
	public static final Octave GREAT = pool.get(2); // C2
	public static final Octave SMALL = pool.get(3); // C3
	public static final Octave ONE_LINED = pool.get(4); // C4
	public static final Octave TWO_LINED = pool.get(5); // C5
	public static final Octave THREE_LINED = pool.get(6); // C6

	private final int spnIndex; // Index in scientific pitch notation

	public static Octave nr(int spnIndex) {
		return pool.get(spnIndex);
	}

	Octave(int spnIndex) {
		this.spnIndex = spnIndex;
	}

	public Octave plus(int octaves) {
		return pool.get(spnIndex + octaves);
	}

	public Octave down() { return plus(-1); }

	public Octave up() { return plus(1); }

	public int getSpnIndex() { return spnIndex; }

	@Override
	public boolean equals(Object obj) {
		return spnIndex == ((Octave) obj).spnIndex;
	}

	@Override
	public String toString() {
		return "Octave C" + spnIndex;
	}
}
