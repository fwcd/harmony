package com.fwcd.harmony.scale;

public enum DiatonicMajorDegree {
	TONIC(0),
	SUPERTONIC(1),
	MEDIANT(2),
	SUBDOMINANT(3),
	DOMINANT(4),
	SUBMEDIANT(5),
	LEADING_TONE(6);

	private final int index;

	private DiatonicMajorDegree(int index) { this.index = index; }

	public int getIndex() { return index; }
}
