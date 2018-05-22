package com.fwcd.harmony.scale;

import java.util.ArrayList;
import java.util.List;

import com.fwcd.harmony.Note;
import com.fwcd.harmony.Step;

public class ChromaticScale extends TemplateScale {
	private final Note key;

	public ChromaticScale(Note key) {
		this.key = key;
	}

	@Override
	public List<Note> getNotes() {
		List<Note> notes = new ArrayList<>();
		Note lastNote = key;
		notes.add(lastNote);

		for (int i=0; i<12; i++) {
			lastNote = lastNote.plus(Step.HALF, variants -> variants.get(0));
			notes.add(lastNote);
		}

		return notes;
	}

	@Override
	public Note getKey() { return key; }
}