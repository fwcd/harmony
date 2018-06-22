package com.fwcd.harmony.scale;

public enum DiatonicNaturalMinorDegree {
	TONIC(0),
	SUPERTONIC(1),
	MEDIANT(2),
	SUBDOMINANT(3),
	DOMINANT(4),
	SUBMEDIANT(5),
	SUBTONIC(6);

	private final int index;

	private DiatonicNaturalMinorDegree(int index) { this.index = index; }

	public int getIndex() { return index; }
}
