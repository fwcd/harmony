package com.fwcd.harmony;

import com.fwcd.harmony.utils.Chooser;

public class Note {
	private final NoteClass noteClass;
	private final OctaveIndex octave;

	public Note(String name) {
		try {
			int i = name.length();
			char c;
			
			do {
				i--;
				c = name.charAt(i - 1);
			} while (Character.isDigit(c) || (c == '-'));
			
			noteClass = NoteClass.of(name.substring(0, i));
			octave = OctaveIndex.nr(Integer.parseInt(name.substring(i)));
		} catch (IndexOutOfBoundsException | NumberFormatException e) {
			throw new IllegalArgumentException(name + " (Note) needs to have the syntax <NoteClass><Octave index>, for example: C#3");
		}
	}

	public Note(NoteClass noteClass, OctaveIndex octave) {
		this.noteClass = noteClass;
		this.octave = octave;
	}

	public Note plusDiatonicStep(Step step) {
		NoteClass newNoteClass = noteClass.plusDiatonicStep(step);
		boolean nextOctave = newNoteClass.ordinal() < noteClass.ordinal();
		return new Note(newNoteClass, octave.plus(nextOctave ? 1 : 0));
	}

	public Note plus(Step step, Chooser<NoteClass> enharmonicVariantChooser) {
		NoteClass newNoteClass = noteClass.plus(step, enharmonicVariantChooser);
		boolean nextOctave = newNoteClass.ordinal() < noteClass.ordinal();
		return new Note(newNoteClass, octave.plus(nextOctave ? 1 : 0));
	}

	public Alteration getAlteration() { return noteClass.getAlteration(); }

	public Pitch getPitch() { return new Pitch(noteClass.getPitchClass(), octave); }

	public NoteClass getNoteClass() { return noteClass; }

	public OctaveIndex getOctave() { return octave; }

	@Override
	public String toString() {
		return noteClass.toString() + octave.getSpnIndex();
	}

	@Override
	public int hashCode() {
		return 7 * noteClass.hashCode() * octave.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Note other = (Note) obj;
		return noteClass.equals(other.noteClass) && octave.equals(other.octave);
	}
}
