package com.fwcd.harmony;

import java.util.List;
import java.util.function.Function;

public class Note {
	private final NoteClass noteClass;
	private final Octave octave;

	public Note(String name) {
		int lastIndex = name.length() - 1;
		char lastChar = name.charAt(lastIndex);
		if (!Character.isDigit(lastChar)) {
			throw new IllegalArgumentException(name + " (Note) needs to have the syntax <NoteClass><Octave index>, for example: C#3");
		}
		noteClass = NoteClass.of(name.substring(0, lastIndex));
		octave = Octave.nr(Character.digit(lastChar, 10));
	}

	public Note(NoteClass noteClass, Octave octave) {
		this.noteClass = noteClass;
		this.octave = octave;
	}

	public Note plusDiatonicStep(Step step) {
		NoteClass newNoteClass = noteClass.plusDiatonicStep(step);
		boolean nextOctave = newNoteClass.ordinal() < noteClass.ordinal();
		return new Note(newNoteClass, octave.plus(nextOctave ? 1 : 0));
	}

	public Note plus(Step step, Function<List<NoteClass>, NoteClass> enharmonicVariantChooser) {
		NoteClass newNoteClass = noteClass.plus(step, enharmonicVariantChooser);
		boolean nextOctave = newNoteClass.ordinal() < noteClass.ordinal();
		return new Note(newNoteClass, octave.plus(nextOctave ? 1 : 0));
	}

	public Alteration getAlteration() { return noteClass.getAlteration(); }

	public Pitch getPitch() { return new Pitch(noteClass.getPitchClass(), octave); }

	public NoteClass getNoteClass() { return noteClass; }

	public Octave getOctave() { return octave; }

	@Override
	public String toString() {
		return noteClass.toString() + octave.getSpnIndex();
	}
}