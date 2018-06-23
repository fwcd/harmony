package com.fwcd.harmony.scale;

import java.util.function.UnaryOperator;

import com.fwcd.harmony.Note;
import com.fwcd.harmony.NoteClass;
import com.fwcd.harmony.OctaveIndex;
import com.fwcd.harmony.Step;
import com.fwcd.harmony.utils.Chooser;

/**
 * A note class that stores an octave offset.
 */
public class RelativeNote {
	private final NoteClass noteClass;
	private final int octavesDelta;

	public RelativeNote(NoteClass noteClass) {
		this.noteClass = noteClass;
		octavesDelta = 0;
	}

	public RelativeNote(NoteClass noteClass, int octavesDelta) {
		this.noteClass = noteClass;
		this.octavesDelta = octavesDelta;
	}

	public RelativeNote map(UnaryOperator<Note> mapper) {
		Note result = mapper.apply(new Note(noteClass, OctaveIndex.nr(octavesDelta)));
		return new RelativeNote(result.getNoteClass(), result.getOctave().getSpnIndex());
	}

	public RelativeNote plus(Step step, Chooser<NoteClass> enharmonicVariantChooser) { return map(note -> note.plus(step, enharmonicVariantChooser)); }

	public RelativeNote plusDiatonicStep(Step step) { return map(note -> note.plusDiatonicStep(step)); }

	public Note toNote(OctaveIndex baseOctave) { return new Note(noteClass, baseOctave.plus(octavesDelta)); }

	public NoteClass getNoteClass() { return noteClass; }

	public int getOctavesDelta() { return octavesDelta; }

	@Override
	public int hashCode() {
		return 9 * noteClass.hashCode() * octavesDelta;
	}

	@Override
	public boolean equals(Object obj) {
		RelativeNote other = (RelativeNote) obj;
		return noteClass.equals(other.noteClass) && octavesDelta == other.octavesDelta;
	}

	@Override
	public String toString() {
		String postfix = (octavesDelta < 0) ? Integer.toString(octavesDelta) : ("+" + octavesDelta);
		return noteClass.toString() + postfix;
	}
}
