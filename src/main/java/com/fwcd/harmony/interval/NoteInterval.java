package com.fwcd.harmony.interval;

import com.fwcd.harmony.Note;
import com.fwcd.harmony.NoteClass;
import com.fwcd.harmony.OctaveIndex;
import com.fwcd.harmony.Pitch;

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
