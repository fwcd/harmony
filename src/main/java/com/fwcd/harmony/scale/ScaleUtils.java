package com.fwcd.harmony.scale;

import java.util.ArrayList;
import java.util.List;

import com.fwcd.harmony.Note;
import com.fwcd.harmony.Step;

final class ScaleUtils {
	private ScaleUtils() {}

	public static List<Note> createDiatonicScale(Note key, Step... steps) {
		Note lastNote = key;
		List<Note> notes = new ArrayList<>();
		notes.add(key);

		for (Step step : steps) {
			lastNote = lastNote.plusDiatonicStep(step);
			notes.add(lastNote);
		}

		return notes;
	};
}