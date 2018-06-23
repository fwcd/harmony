package com.fwcd.harmony.scale;

import java.util.List;

public interface ScaleClass {
	RelativeNote getKey();

	RelativeNote getDegree(ScaleDegree degree);

	/**
	 * Returns the notes from the key upwards.
	 */
	List<RelativeNote> getNotes();
}