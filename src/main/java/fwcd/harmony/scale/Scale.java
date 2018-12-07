package fwcd.harmony.scale;

import java.util.List;
import java.util.stream.Collectors;

import fwcd.harmony.Note;
import fwcd.harmony.OctaveIndex;

public class Scale {
	private final ScaleClass scaleClass;
	private final OctaveIndex octave;

	public Scale(ScaleClass scaleClass, OctaveIndex octave) {
		this.scaleClass = scaleClass;
		this.octave = octave;
	}

	public static Scale createMajor(Note key) { return new Scale(new DiatonicMajor(new RelativeNote(key.getNoteClass())), key.getOctave()); }

	public static Scale createNaturalMinor(Note key) { return new Scale(new DiatonicNaturalMinor(new RelativeNote(key.getNoteClass())), key.getOctave()); }

	public static Scale createChromatic(Note key) { return new Scale(new Chromatic(new RelativeNote(key.getNoteClass())), key.getOctave()); }

	public List<Note> getNotes() {
		return scaleClass.getNotes().stream()
				.map(relativeNote -> relativeNote.toNote(octave))
				.collect(Collectors.toList());
	}

	public Note getKey() { return scaleClass.getKey().toNote(octave); }

	public ScaleClass getScaleClass() { return scaleClass; }

	public OctaveIndex getOctave() { return octave; }

	@Override
	public String toString() {
		return getNotes().toString();
	}

	@Override
	public int hashCode() {
		return 3 * scaleClass.hashCode() * octave.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Scale other = (Scale) obj;
		return other.scaleClass.equals(scaleClass) && other.octave.equals(octave);
	}
}
