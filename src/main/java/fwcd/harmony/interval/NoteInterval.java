package fwcd.harmony.interval;

import fwcd.harmony.Note;
import fwcd.harmony.NoteClass;
import fwcd.harmony.OctaveIndex;
import fwcd.harmony.Pitch;

public interface NoteInterval extends PitchInterval {
	Note apply(Note base, int times);

	@Override
	default Pitch apply(Pitch base, int times) {
		return apply(new Note(base.getPitchClass().getNoteClasses().get(0), base.getOctave()), times).getPitch();
	}

	default NoteClass apply(NoteClass base, int times) {
		return apply(new Note(base, OctaveIndex.ZERO), times).getNoteClass();
	}
}
