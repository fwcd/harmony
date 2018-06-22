package com.fwcd.harmony.scale;

import java.util.ArrayList;
import java.util.List;

import com.fwcd.harmony.Step;

public class Chromatic extends TemplateScaleClass {
	private final RelativeNote key;

	public Chromatic(RelativeNote key) {
		this.key = key;
	}

	@Override
	public List<RelativeNote> getNotes() {
		List<RelativeNote> notes = new ArrayList<>();
		RelativeNote lastNote = key;
		notes.add(lastNote);

		for (int i=0; i<12; i++) {
			lastNote = lastNote.plus(Step.HALF, variants -> variants.get(0));
			notes.add(lastNote);
		}

		return notes;
	}

	@Override
	public RelativeNote getKey() { return key; }
}