package com.fwcd.harmony.scale;

import java.util.ArrayList;
import java.util.List;

import com.fwcd.harmony.Step;

final class ScaleUtils {
	private ScaleUtils() {}

	public static List<RelativeNote> createDiatonicScale(RelativeNote key, Step... steps) {
		RelativeNote lastNote = key;
		List<RelativeNote> notes = new ArrayList<>();
		notes.add(key);

		for (Step step : steps) {
			lastNote = lastNote.plusDiatonicStep(step);
			notes.add(lastNote);
		}

		return notes;
	};
}