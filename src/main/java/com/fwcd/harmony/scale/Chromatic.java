package com.fwcd.harmony.scale;

import java.util.ArrayList;
import java.util.List;

import com.fwcd.harmony.NoteClass;
import com.fwcd.harmony.Step;

public class Chromatic extends TemplateScaleClass {
	private final RelativeNote key;
	private final List<RelativeNote> notes;

	public Chromatic(NoteClass key) { this(new RelativeNote(key)); }

	public Chromatic(RelativeNote key) {
		this.key = key;

		notes = new ArrayList<>();
		RelativeNote lastNote = key;
		notes.add(lastNote);

		for (int i=0; i<12; i++) {
			lastNote = lastNote.plus(Step.HALF, variants -> variants.get(0));
			notes.add(lastNote);
		}
	}

	@Override
	public List<RelativeNote> getNotes() { return notes; }

	@Override
	public RelativeNote getKey() { return key; }
}